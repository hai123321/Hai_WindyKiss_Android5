package com.example.windykiss.lab01_sesson06;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WindyKiss on 10/2/2016.
 */

public class ListItem_Adapter extends ArrayAdapter<ListItem> {

    public ListItem_Adapter(Context context, int resource, List<ListItem> objects) {
        super(context, resource, objects);
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //1 Cang View
        LayoutInflater layoutInflater = LayoutInflater.from(this.getContext());

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_items,
                    parent,
                    false);
        }


        //2 Them View vao data
        ListItem listItem = getItem(position);
        new ListItemHolder(convertView).setData(listItem);

        return convertView;

    }
}
