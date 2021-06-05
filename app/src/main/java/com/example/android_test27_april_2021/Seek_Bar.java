package com.example.android_test27_april_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class Seek_Bar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar);

        TextView textView = (TextView) findViewById(R.id.textView);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressBar.setProgress(progress);
                textView.setText("" + progress + "%");
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