package com.fsemicolon.showandhideui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView fsemicolon;
    Button showButton, HideButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fsemicolon = (TextView)findViewById(R.id.textView);
        showButton = (Button)findViewById(R.id.show_btn);
        HideButton = (Button)findViewById(R.id.hide_btn);


        fsemicolon.setVisibility(View.INVISIBLE);



        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fsemicolon.setVisibility(View.VISIBLE);
            }
        });

        HideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fsemicolon.setVisibility(View.INVISIBLE);
            }
        });


    }
}
