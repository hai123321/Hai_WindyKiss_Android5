package com.example.windykiss.homeworksession15.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.windykiss.homeworksession15.MainActivity;
import com.example.windykiss.homeworksession15.R;
import com.example.windykiss.homeworksession15.TempNote;
import com.example.windykiss.homeworksession15.managers.DBHelper;
import com.example.windykiss.homeworksession15.models.CategoryModel;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddFragment extends Fragment {

    @BindView(R.id.btn_fr_add)
    Button btn_add;

    @BindView(R.id.et_title)
    EditText et_title;
    @BindView(R.id.et_content)
    EditText et_content;
    @BindView(R.id.et_create_time)
    EditText et_create_time;

    public AddFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_add, container, false);
        ButterKnife.bind(this, v);
        addListeners();
        return v;
    }

    private void addListeners() {
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TempNote tempNote = new TempNote(
                    et_title.getText().toString(),
                        et_content.getText().toString(),
                        et_create_time.getText().toString()
                );
                DBHelper.getInstance().insert(tempNote);
                CategoryModel.list.add(new CategoryModel(tempNote.getTitle()));
                ((MainActivity)getActivity()).notifiDataSetchange();
                ((MainActivity)getActivity()).reset();

                getFragmentManager().popBackStack();
            }
        });
    }

}
