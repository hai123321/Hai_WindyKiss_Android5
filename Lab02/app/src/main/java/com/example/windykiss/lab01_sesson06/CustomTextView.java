package com.example.windykiss.lab01_sesson06;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.widget.TextView;

import butterknife.BindColor;
import butterknife.ButterKnife;

/**
 * Created by WindyKiss on 10/2/2016.
 */

public class CustomTextView extends TextView {

    Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
    @BindColor(R.color.blue)
    int blueColor;

    @BindColor(R.color.colorAccent)
    int accentColor;

    @BindColor(R.color.colorPrimaryDark)
    int colorPrimaryDark;

    public CustomTextView(Context context) {
        super(context);
        ButterKnife.bind(this, this);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        ButterKnife.bind(this, this);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        ButterKnife.bind(this, this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        p.setColor(blueColor);
        int width = getWidth() / 2;
        canvas.drawCircle(3 * width / 4, width / 2, width / 2, p);

        p.setColor(accentColor);
        canvas.drawCircle(5 * width / 4, width / 2, width / 2, p);

        p.setColor(colorPrimaryDark);

        p.setStyle(Paint.Style.FILL);
//        canvas.drawCircle(3 * width / 4, width / 2, width / 2, p);
//        canvas.drawCircle(5 * width / 4, width / 2, width / 2, p);

    }
}
