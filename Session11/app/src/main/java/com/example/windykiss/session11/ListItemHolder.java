package com.example.windykiss.session11;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.windykiss.session11.Constants.Constants;
import com.example.windykiss.session11.jsmodels.JSONModel_Turn01;
import com.example.windykiss.session11.jsmodels.ListTurn02;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by WindyKiss on 10/12/2016.
 */
public class ListItemHolder {
    @BindView(R.id.tv_item_title)
    public TextView tv_item_title;

    @BindView(R.id.iv_picture)
    public ImageView iv_picture;

    public ListItemHolder(View rootView) {
        ButterKnife.bind(this, rootView);
    }

    public void setData(ListTurn02 listItem){
        tv_item_title.setText(listItem.getDate_taken());
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage(listItem.getM(), iv_picture, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {

            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {

            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {

            }
        });

    }
}