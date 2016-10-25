package com.example.windykiss.homeworksession15;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by WindyKiss on 10/25/2016.
 */

public class OnMeasure extends RelativeLayout {
    public OnMeasure(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);

        int newHeightSize = widthSize;
        int newHeightMode = MeasureSpec.EXACTLY;
        int newHeightMeasureSpec = MeasureSpec.makeMeasureSpec(newHeightSize, newHeightMode);
        super.onMeasure(widthMeasureSpec, newHeightMeasureSpec);
    }
}
