package com.example.windykiss.lab01_sesson06;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by WindyKiss on 9/30/2016.
 */

public class MeasureIV2 extends RelativeLayout {
    public MeasureIV2(Context context) {
        super(context);
    }

    public MeasureIV2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MeasureIV2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        int newHeightSize = widthSize *5/ 6;
        int newHeightMode = MeasureSpec.EXACTLY;
        int newHeightMeasureSpec = MeasureSpec.makeMeasureSpec(newHeightSize, newHeightMode);
        super.onMeasure(widthMeasureSpec, newHeightMeasureSpec);
    }
}
