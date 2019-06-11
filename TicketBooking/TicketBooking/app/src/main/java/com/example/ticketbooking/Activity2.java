package com.example.ticketbooking;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    TextView title, dMonth, dWeek, time, cinemaName;
    FloatingActionButton toMainActivity;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        toMainActivity = findViewById(R.id.button_activity);

        setContentView(R.layout.activity_2);
        title = findViewById(R.id.movie_title_1);
        dMonth = findViewById(R.id.dMonth_1);
        dWeek = findViewById(R.id.dWeek_1);
        time = findViewById(R.id.time_Text_1);
        cinemaName = findViewById(R.id.Cinema_name_1);

        title.setText(Load.movieTitle);
        dMonth.setText(Load.dMonth);
        dWeek.setText(Load.dWeek);
        time.setText(Load.dTime);
        cinemaName.setText(Load.cinemaName);
    }
}