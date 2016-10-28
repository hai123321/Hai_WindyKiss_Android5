package com.example.windykiss.homeworksession15;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.windykiss.homeworksession15.adapters.CategoryAdapter;
import com.example.windykiss.homeworksession15.fragments.AddFragment;
import com.example.windykiss.homeworksession15.fragments.EditFragment;
import com.example.windykiss.homeworksession15.managers.DBHelper;
import com.example.windykiss.homeworksession15.models.CategoryModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.getName();
    private List<TempNote> tempNoteList;
    public static int pos;
    private CategoryAdapter categoryAdapter;
    @BindView(R.id.btn_add)
    Button btn_add;

    @BindView(R.id.rv)
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        DBHelper.getInstance().init(this);
        setupUI();
        addListeners();
//        changeFragment();


    }

    private void addListeners() {
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(new AddFragment(), true);
            }
        });

        rv.addOnItemTouchListener(new RecyclerItemClickListener(this, rv, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                pos = position;
                changeFragment(new EditFragment(), true);
            }

            @Override
            public void onLongItemClick(View view, int position) {
                DBHelper.getInstance().delete(tempNoteList.get(position));
                tempNoteList = DBHelper.getInstance().selectAllNote();
                CategoryModel.list.clear();
                for (TempNote tempNote : tempNoteList) {
                    CategoryModel.list.add(new CategoryModel(tempNote.getTitle()));
                }
                categoryAdapter.notifyDataSetChanged();

                Log.d(TAG, "Long Click");
            }
        }));
    }

    private void changeFragment(Fragment fragment, Boolean addToBackStack) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_main, fragment);
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }
        fragmentTransaction.commit();
    }


    private void setupUI() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);
        categoryAdapter = new CategoryAdapter();
        rv.setAdapter(categoryAdapter);
        CategoryModel.list.clear();
        tempNoteList = DBHelper.getInstance().selectAllNote();
        for (TempNote tempNote : tempNoteList) {
            CategoryModel.list.add(new CategoryModel(tempNote.getTitle()));
        }
        categoryAdapter.notifyDataSetChanged();
    }

    public void notifiDataSetchange() {
        categoryAdapter.notifyDataSetChanged();
    }

    public TempNote getTmpNote(){
        return tempNoteList.get(pos);
    }

    public void reset(){
        tempNoteList = DBHelper.getInstance().selectAllNote();
    }

}
