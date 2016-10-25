package com.example.windykiss.homeworksession15.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.windykiss.homeworksession15.R;
import com.example.windykiss.homeworksession15.models.CategoryModel;
import com.example.windykiss.homeworksession15.view_holder.CategoryViewHolder;


/**
 * Created by WindyKiss on 10/23/2016.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {


    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 1 Inflate View
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_categories, parent, false);

        // 2 Create View Holder
        CategoryViewHolder categoryViewHolder = new CategoryViewHolder(itemView);

        return categoryViewHolder;
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        CategoryModel categoryModel = CategoryModel.list.get(position);
        holder.bind(categoryModel);
    }

    @Override
    public int getItemCount() {
        return CategoryModel.list.size();
    }
}
