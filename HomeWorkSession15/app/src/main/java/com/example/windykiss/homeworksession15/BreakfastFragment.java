package com.example.windykiss.homeworksession15;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.windykiss.homeworksession15.adapters.BreakfastAdapter;
import com.example.windykiss.homeworksession15.models.BreakFastModel;
import com.example.windykiss.homeworksession15.models.CategoryModel;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class BreakfastFragment extends Fragment {
    @BindView(R.id.rv_fr)
    RecyclerView rv;
    private BreakfastAdapter breakfastAdapter;

    private static final BreakFastModel[] breakFast = new BreakFastModel[]{
            new BreakFastModel(R.drawable.american, "American"),
            new BreakFastModel(R.drawable.chinese, "Chinese"),
            new BreakFastModel(R.drawable.czech, "Czech"),
            new BreakFastModel(R.drawable.italian, "Italian"),
            new BreakFastModel(R.drawable.thai, "Thai"),
            new BreakFastModel(R.drawable.japanese, "Japanese")
    };

    public BreakfastFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_breakfast, container, false);
        ButterKnife.bind(this, v);
        setupUI(inflater.getContext());
        return v;
    }

    private void setupUI(Context context) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
        rv.setLayoutManager(gridLayoutManager);
        breakfastAdapter = new BreakfastAdapter();
        rv.setAdapter(breakfastAdapter);
        BreakFastModel.list.clear();
        for (BreakFastModel breakFastModel : breakFast) {
            BreakFastModel.list.add(breakFastModel);
        }
        breakfastAdapter.notifyDataSetChanged();
    }

}
