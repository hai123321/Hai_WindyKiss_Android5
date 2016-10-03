package com.example.windykiss.lab01_sesson06;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by WindyKiss on 10/2/2016.
 */

public class Turn1 extends RelativeLayout {

    @BindView(R.id.tv_value)
    TextView tv_value;

    @BindView(R.id.iv_add)
    ImageView iv_add;

    @BindView(R.id.iv_remove)
    ImageView iv_remove;

    @BindView(R.id.tv_string)
    TextView tv_string;

    private int value;


    public Turn1(Context context, AttributeSet attrs) {
        super(context, attrs);
        initFromContext(context, attrs);
        addListener();
    }

    public Turn1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initFromContext(context, attrs);
        addListener();
    }




    private void initFromContext(Context context, AttributeSet attributeSet) {
        View rootView = inflate(context, R.layout.view_compound_turn1, this);
        ButterKnife.bind(this, rootView);

        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.Turn1);
        int value = typedArray.getInt(R.styleable.Turn1_value, -1);
        String string = typedArray.getString(R.styleable.Turn1_label);
        typedArray.recycle();

        this.value = value;
        tv_value.setText(value + "");
        tv_string.setText(string);
        addListener();
    }

    public void addListener() {
        iv_add.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                value++;
                tv_value.setText(value + "");
            }
        });

        iv_remove.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                value--;
                tv_value.setText(value + "");
            }
        });
    }
}
