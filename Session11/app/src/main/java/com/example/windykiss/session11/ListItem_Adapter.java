package com.example.windykiss.session11;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.windykiss.session11.fragments.JsonFragment;
import com.example.windykiss.session11.jsmodels.JSONModel_Turn01;
import com.example.windykiss.session11.jsmodels.ListTurn02;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WindyKiss on 10/2/2016.
 */

public class ListItem_Adapter extends ArrayAdapter<ListTurn02> {

    public ListItem_Adapter(Context context, int resource, List<ListTurn02> objects) {
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
        ListTurn02 listItem = getItem(position);
        new ListItemHolder(convertView).setData(listItem);

        return convertView;

    }
}
