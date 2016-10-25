package com.example.windykiss.homework15_0102.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.windykiss.homework15_0102.R;
import com.example.windykiss.homework15_0102.models.PostModel;
import com.example.windykiss.homework15_0102.view_holders.PostViewHolder;

/**
 * Created by WindyKiss on 10/26/2016.
 */

public class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {

    // Create new
    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 1 Inflate View
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_post, parent, false);

        // 2 Create View Holder
        PostViewHolder postViewHolder = new PostViewHolder(itemView);

        return postViewHolder;
    }

    // Update
    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        PostModel post = PostModel.list.get(position);
        holder.bind(post);
    }


    // Get count
    @Override
    public int getItemCount() {
        return PostModel.list.size();
    }

}
