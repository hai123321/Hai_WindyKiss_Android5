package com.example.windykiss.lab01_sesson06;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by WindyKiss on 9/30/2016.
 */

public class MeasureDemo extends RelativeLayout {
    public MeasureDemo(Context context) {
        super(context);
    }

    public MeasureDemo(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MeasureDemo(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        int newWidthSize = widthSize / 2;
        int newWidthMode = MeasureSpec.EXACTLY;
        int newWidthMeasureSpec = MeasureSpec.makeMeasureSpec(newWidthSize, newWidthMode);
        super.onMeasure(newWidthMeasureSpec, heightMeasureSpec);
    }
}
