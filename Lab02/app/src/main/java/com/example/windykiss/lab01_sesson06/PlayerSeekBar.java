package com.example.windykiss.lab01_sesson06;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by WindyKiss on 9/30/2016.
 */

public class PlayerSeekBar extends RelativeLayout {

    @BindView(R.id.sb_value)
    SeekBar seekbar;
    @BindView(R.id.tv_time_left)
    TextView tvTimeLeft;

    @BindView(R.id.tv_time_passed)
    TextView tvTimePassed;

    private int timeTotal = 300;
    private int timePassed;

    public PlayerSeekBar(Context context) {
        super(context);
        initFromContext(context);
    }

    public PlayerSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initFromContext(context);
    }

    public PlayerSeekBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initFromContext(context);
    }

    private void initFromContext(Context context) {
        View rootView = inflate(context, R.layout.player_seekbar, this);
        ButterKnife.bind(this, rootView);
        updateUI();
        addListener();
    }

    public int getTimeTotal() {
        return timeTotal;
    }

    public void setTimeTotal(int timeTotal) {
        this.timeTotal = timeTotal;
    }

    public int getTimePassed() {
        return timePassed;
    }

    public void setTimePassed(int timePassed) {
        this.timePassed = timePassed;
    }

    private void updateUI() {
        int timeLeft = timeTotal - timePassed;
        tvTimeLeft.setText(toTimeString(timeLeft));
        tvTimePassed.setText(toTimeString(timePassed));
        seekbar.setMax(timeTotal);
        seekbar.setProgress(timePassed);

    }

    private String toTimeString(int seconds) {
        String passed = "";
        String left = "";
        if ((seconds / 60) % 60 < 10) {
            passed = "0" + (seconds / 60) % 60;
        } else {
            passed += (seconds / 60) % 60;
        }
        if (seconds % 60 < 10) {
            left = "0" + seconds % 60;
        } else {
            left += seconds % 60;
        }
        return String.format("%2s:%2s", passed, left);
    }

    private void addListener() {
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    timePassed = seekBar.getProgress();
                    timeTotal = seekBar.getMax();
                    updateUI();
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
