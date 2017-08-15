package com.fsemicolon.timestable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    SeekBar seekBar;
    ListView timesTableListView;


    public void generateTimesTable(int timesTable)
    {
        //We are creating an array list to display the timestable

        ArrayList<String> timesTableContent = new ArrayList<String>();

        for(int i=1; i<=10; i++)
        {
            //We are adding the numbers to the times table

            timesTableContent.add(Integer.toString(i*timesTable));
        }

        //Now We need to add the array list to the list view
        //for that purpose we are going to use an Array Adapter

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,timesTableContent);

        timesTableListView.setAdapter(arrayAdapter);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        timesTableListView = (ListView) findViewById(R.id.times_table_list_view);

        // We want the tables up to 20 so we are setting the max value to be 20
        seekBar.setMax(20);

        // There is no min value in Seek bar but we can set the initial progress and I'll set it to 10
        seekBar.setProgress(10);

        //We want to update the progress on touching the Seek Bar, so we are using onSeekBarChangeListener

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                int min = 1;
                int timesTable;

                //We want the progress to be always greater than or equal to 1

                if (progress < 1) {
                    timesTable = min;
                    seekBar.setProgress(min);
                } else {
                    timesTable = progress;

                }

                generateTimesTable(timesTable);



            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        generateTimesTable(10);








    }
}
