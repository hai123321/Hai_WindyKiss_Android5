package com.example.windykiss.homeworksession15.view_holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.windykiss.homeworksession15.R;
import com.example.windykiss.homeworksession15.models.BreakFastModel;
import com.example.windykiss.homeworksession15.models.CategoryModel;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by WindyKiss on 10/25/2016.
 */

public class BreakfastViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.iv_fr)
    ImageView iv;

    @BindView(R.id.tv_fr)
    TextView tv;
    public BreakfastViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(BreakFastModel breakFastModel){
        iv.setImageResource(breakFastModel.getImgID());
        tv.setText(breakFastModel.getTitle());
    }
}
