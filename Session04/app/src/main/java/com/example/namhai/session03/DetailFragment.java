package com.example.namhai.session03;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    private int position;
    private TextView textViewName;
    private TextView textViewWeb;
    private TextView textViewPhone;

    private View.OnClickListener onClickListener;




    public DetailFragment() {
        // Required empty public constructor
    }

    public void setPosition(int position){
        this.position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_detail, container, false);
        getRefereces(v);
        addActionListener();
        Company split= MainActivity.arrayListCompany.get(position);
        textViewName.setText(split.getName());
        textViewWeb.setText(split.getWebsite());
        textViewPhone.setText(split.getPhone());

        return v;
    }

    public void getRefereces(View v){
        textViewName = (TextView) v.findViewById(R.id.textViewName);
        textViewWeb = (TextView) v.findViewById(R.id.textViewWeb);
        textViewPhone = (TextView) v.findViewById(R.id.textViewPhone);
    }

    public void addActionListener(){
        textViewWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Implict Itent
                String googleSearch = String.format("%s", textViewWeb.getText());
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(googleSearch));
                startActivity(intent);
            }
        });

        textViewPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = textViewPhone.getText().toString();
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone));
                startActivity(intent);
            }
        });
    }

}
