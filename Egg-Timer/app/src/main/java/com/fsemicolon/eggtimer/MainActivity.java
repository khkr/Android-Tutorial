package com.fsemicolon.eggtimer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar timerSeekBar;
    TextView timerTextView;
    Button controlBtn;
    boolean counterIsActive = false;

    CountDownTimer countDownTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        controlBtn = (Button) findViewById(R.id.controller_button);

        timerTextView = (TextView) findViewById(R.id.timer_textView);

        timerSeekBar = (SeekBar) findViewById(R.id.timer_seekBar);

        //Max =600 since the max time we want is 10 minutes
        timerSeekBar.setMax(600);

        //since we want it to start at 30 seconds

        timerSeekBar.setProgress(30);

        timerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

                updateTimer(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    public void updateTimer(int progress) {
        int minutes = progress / 60;

        int seconds = progress % 60;

        String secondString = Integer.toString(seconds);

        if (seconds == 0) {
            secondString = "0" + secondString;
        } else if (seconds <= 9) {
            secondString = "0" + secondString;
        }


        timerTextView.setText(Integer.toString(minutes) + ":" + secondString);

    }

    public void resetTimer(){

        timerTextView.setText("0:30");
        timerSeekBar.setProgress(30);
        countDownTimer.cancel();
        controlBtn.setText("GO");
        timerSeekBar.setEnabled(true);
        counterIsActive = false;
    }


    public void controlTimer(View view) {
        if (!counterIsActive) {
            controlBtn.setText("Stop");
            counterIsActive = true;
            timerSeekBar.setEnabled(false);
          countDownTimer=  new CountDownTimer(timerSeekBar.getProgress() * 1000 + 100, 1000) {

                @Override
                public void onTick(long l) {

                    updateTimer((int) l / 1000);

                }

                @Override
                public void onFinish() {

                    timerTextView.setText("0:00");
                    MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.airhorn);
                    mediaPlayer.start();
                    resetTimer();

                }
            }.start();
        }
        else {
            resetTimer();
        }
    }

}
