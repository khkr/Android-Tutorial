package com.fsemicolon.eggtimer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar timerSeekBar;
    TextView timerTextView;
    Button controlBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controlBtn = (Button)findViewById(R.id.controller_button);

        timerTextView = (TextView)findViewById(R.id.timer_textView);

        timerSeekBar = (SeekBar)findViewById(R.id.timer_seekBar);

        //Max =600 since the max time we want is 10 minutes
        timerSeekBar.setMax(600);

        
    }
}
