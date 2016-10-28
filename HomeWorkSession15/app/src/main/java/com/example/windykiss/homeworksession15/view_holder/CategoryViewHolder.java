package com.example.windykiss.homeworksession15.view_holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.windykiss.homeworksession15.R;
import com.example.windykiss.homeworksession15.models.CategoryModel;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by WindyKiss on 10/25/2016.
 */

public class CategoryViewHolder extends RecyclerView.ViewHolder{
    @BindView(R.id.tv_title)
    TextView tv;
    public CategoryViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(CategoryModel categoryModel){
        tv.setText(categoryModel.getTitle());
    }
}
