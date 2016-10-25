package com.example.windykiss.homeworksession15.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.windykiss.homeworksession15.models.BreakFastModel;
import com.example.windykiss.homeworksession15.view_holder.BreakfastViewHolder;
import com.example.windykiss.homeworksession15.R;
import com.example.windykiss.homeworksession15.models.CategoryModel;

/**
 * Created by WindyKiss on 10/25/2016.
 */

public class BreakfastAdapter extends RecyclerView.Adapter<BreakfastViewHolder> {


    @Override
    public BreakfastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 1 Inflate View
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_sorts, parent, false);

        // 2 Create View Holder
        BreakfastViewHolder breakfastViewHolder = new BreakfastViewHolder(itemView);

        return breakfastViewHolder;
    }

    @Override
    public void onBindViewHolder(BreakfastViewHolder holder, int position) {
        BreakFastModel breakFastModel = BreakFastModel.list.get(position);
        holder.bind(breakFastModel);
    }

    @Override
    public int getItemCount() {
        return BreakFastModel.list.size();
    }
}