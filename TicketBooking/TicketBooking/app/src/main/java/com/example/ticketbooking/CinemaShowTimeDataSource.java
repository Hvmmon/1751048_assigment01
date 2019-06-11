package com.example.ticketbooking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CinemaShowTimeDataSource {
    private static CinemaShowTimeDataSource instance;

    public static CinemaShowTimeDataSource getInstance() {
        if (instance == null) {
            instance = new CinemaShowTimeDataSource();
        }
        return instance;
    }

    public List<Date> getListDates(Date sDate, int nDate) {
        List<Date> listDates = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sDate);
        for (int i = 0; i < nDate; i++) {
            listDates.add(calendar.getTime());

            //Increase 1 date
            calendar.add(Calendar.DATE, 1);
        }
        return listDates;
    }

    public List<ShowTimes> getListShowtimes(Date sTime, int nTime) {
        List<ShowTimes> listShowtimes = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sTime);
        boolean available;
        for (int i = 0; i < nTime; i++) {
            Date showtimeTemp = calendar.getTime();
            //Make showtimes(available and unavailable)
            if (showtimeTemp.getMinutes() <=15 ) {
                available = false;
            } else {
                available = true;
            }
            listShowtimes.add(new ShowTimes(calendar.getTime(), available));

            //Increase 35 mins
            calendar.add(Calendar.MINUTE, 45);
        }
        return listShowtimes;
    }

    public InfoFilm getMovieInfo() {
        return new InfoFilm(
                "Interstellar",
                "3D",
                "In Earth's future, a global crop blight and second Dust Bowl are slowly rendering the planet uninhabitable. Professor Brand (Michael Caine), a brilliant NASA physicist, is working on plans to save mankind by transporting Earth's population to a new home via a wormhole. But first, Brand must send former NASA pilot Cooper (Matthew McConaughey) and a team of researchers through the wormhole and across the galaxy to find out which of three planets could be mankind's new home.",
                4.8,
                152,
                Arrays.asList("Fiction", "Mystery"));
    }
}
