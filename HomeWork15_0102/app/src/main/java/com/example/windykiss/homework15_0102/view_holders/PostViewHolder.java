package com.example.windykiss.homework15_0102.view_holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.windykiss.homework15_0102.R;
import com.example.windykiss.homework15_0102.models.PostModel;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by WindyKiss on 10/26/2016.
 */

public class PostViewHolder extends RecyclerView.ViewHolder{
    @BindView(R.id.tv_title)
    TextView tv_title;

    @BindView(R.id.tv_content)
    TextView tv_content;

    public PostViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

    }

    public void bind(PostModel post){
        tv_title.setText(post.getTitle());
        tv_content.setText(post.getContent());
    }
}
