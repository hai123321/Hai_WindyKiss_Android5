package com.example.windykiss.lab01_sesson06;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by WindyKiss on 10/2/2016.
 */

public class ListItemHolder {
    @BindView(R.id.iv_item)
    public ImageView imageView;

    @BindView(R.id.tv_item_detail)
    public TextView tv_time_detail;

    @BindView(R.id.tv_item_time)
    public TextView tv_time;

    public ListItemHolder(View rootView) {
        ButterKnife.bind(this, rootView);
    }

    public void setData(ListItem listItem){
        tv_time_detail.setText(listItem.getTitle());
        tv_time.setText(listItem.getDetail());
        imageView.setImageResource(listItem.getImgageID());
    }
}
