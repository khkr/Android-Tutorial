package com.fsemicolon.timerdemo;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new CountDownTimer(10000,1000) {
            @Override
            public void onTick(long l) {

                // Countdown is happening every second

                Log.i("Seconds left", String.valueOf(l/1000));

            }

            @Override
            public void onFinish() {

                Log.i("Done", "Count down timer finished");

            }
        }.start();




//        //We are using other counter which is commented out right now
//
//        final Handler handler = new Handler();
//
//        Runnable run = new Runnable() {
//            @Override
//            public void run() {
//
//                Toast.makeText(MainActivity.this, "One Second delay", Toast.LENGTH_SHORT).show();
//
//               //Here we are asking to delay the activity by a second
//                handler.postDelayed(this,1000);
//
//            }
//        };
//
//        //We are asking the handler to run a runnable method
//        handler.post(run);





    }
}
