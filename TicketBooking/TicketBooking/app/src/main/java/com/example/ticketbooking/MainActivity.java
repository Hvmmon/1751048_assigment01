package com.example.ticketbooking;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private final String TAG = this.getClass().getSimpleName();
    DateAdapter dateadapter;
    RecyclerView recyclerView;
    RecyclerView cinemaShowTimeRecyclerView;
    CinemaAdapter cinemaAdapter;

    CinemaShowTimeDataSource dataSource;
    CinemaShowTimeRepository dataRepository;
    TextView title;
    TextView rate;
    TextView duration;
    TextView type;
    TextView synopsis;
    TextView genres1;
    TextView genres2;
    FloatingActionButton nActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nActivity = (FloatingActionButton) findViewById(R.id.button_activity);
        nActivity.bringToFront();
        nActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Activity2.class);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.date_select);
        cinemaShowTimeRecyclerView = findViewById(R.id.show_time);
        dataSource = CinemaShowTimeDataSource.getInstance();
        dataRepository = CinemaShowTimeRepository.getInstance(dataSource);
        title = (TextView) findViewById(R.id.movie_title);
        rate = (TextView) findViewById(R.id.rating);
        duration = (TextView) findViewById(R.id.duration);
        type = (TextView) findViewById(R.id.type);
        synopsis = (TextView) findViewById(R.id.synopsis);
        genres1 = (TextView) findViewById(R.id.genres1);
        genres2 = (TextView) findViewById(R.id.genres2);


        //Find View By ID

        //Take the sample movie data from data repository
        InfoFilm movie = dataRepository.getMovieInfo();
        Log.d(TAG, String.format("Movie title: %s", movie.getTitle()));
        List<Cinema> ListCinemas;

        //Get list of date from data repository with start date. It will get 10 dates from dummy
        //data source
        Date startDate = new Date(2019, 05, 28);
        List<Date> listDates = dataRepository.getListDates(startDate);
        for (Date date : listDates) {
            Log.d(
                    TAG,
                    String.format("d/M/y = %d / %d / %d ;", date.getDate(), date.getMonth(), date.getYear()));
        }

        Date startTime = new Date(0, 0, 0, 10, 30);
        List<ShowTimes> listTimes = dataRepository.getListShowtimes(startTime);
        for (ShowTimes time : listTimes) {
            Log.d(
                    TAG,
                    String.format(
                            "h:m = %d : %d; is available = %b",
                            time.getTime().getHours(), time.getTime().getMinutes(), time.isAvailable()));
        }
        //Cinema info
        ListCinemas = new ArrayList<>();
        Cinema Cinema1 = new Cinema("BHD Q1", listTimes, false);
        Cinema Cinema2 = new Cinema("CGV Q2", listTimes, false);
        Cinema Cinema3 = new Cinema("CGV Q3", listTimes, false);
        Cinema Cinema4 = new Cinema("Lotte Dong Khoi", listTimes, false);
        Cinema Cinema5 = new Cinema("Cinestar Hai Ba Trung", listTimes, false);
        ListCinemas.add(Cinema1);
        ListCinemas.add(Cinema2);
        ListCinemas.add(Cinema3);
        ListCinemas.add(Cinema4);
        ListCinemas.add(Cinema5);

        //Movie info
        Load.setMovieName(movie.getTitle());
        title.setText(movie.getTitle());
        rate.setText(String.valueOf(movie.getRating()));
        duration.setText(String.valueOf(movie.getDuration()));
        type.setText(movie.getType());
        synopsis.setText(movie.getSynopsis());
        genres1.setText(movie.getGenres().get(0));
        genres2.setText(movie.getGenres().get(1));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        //Date scroll horizontal
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
            layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        layoutManager.scrollToPosition(10);

        recyclerView.setLayoutManager(layoutManager);
        dateadapter = new DateAdapter(listDates, this);
        recyclerView.setAdapter(dateadapter);

        //List movie cinema
        LinearLayoutManager layoutManagerCinema = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        layoutManagerCinema.scrollToPosition(5);

        cinemaShowTimeRecyclerView.setLayoutManager(layoutManagerCinema);
        cinemaAdapter = new CinemaAdapter(ListCinemas, this);
        cinemaShowTimeRecyclerView.setAdapter(cinemaAdapter);
    }


}

