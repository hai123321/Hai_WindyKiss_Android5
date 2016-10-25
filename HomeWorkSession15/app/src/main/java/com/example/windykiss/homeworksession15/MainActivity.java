package com.example.windykiss.homeworksession15;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.windykiss.homeworksession15.adapters.CategoryAdapter;
import com.example.windykiss.homeworksession15.models.CategoryModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.getName();

    private CategoryAdapter categoryAdapter;
    private static final CategoryModel[] categorymodel = new CategoryModel[]{
            new CategoryModel(R.drawable.breakfirst, "BREAKFAST"),
            new CategoryModel(R.drawable.coffee, "COFFEE"),
            new CategoryModel(R.drawable.appertizer, "APPETIZERS"),
            new CategoryModel(R.drawable.drinks, "DRINKS"),
            new CategoryModel(R.drawable.lunch, "LUNCH")
    };

    @BindView(R.id.rv)
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupUI();

//        changeFragment();


    }

    private void changeFragment() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        BreakfastFragment detailFragment = new BreakfastFragment();
        fragmentTransaction.replace(R.id.activity_main, detailFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


    private void setupUI() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);
        categoryAdapter = new CategoryAdapter();
        rv.setAdapter(categoryAdapter);
        CategoryModel.list.clear();
        for (CategoryModel categoryModel : categorymodel) {
            CategoryModel.list.add(categoryModel);
        }
        categoryAdapter.notifyDataSetChanged();
    }
}
