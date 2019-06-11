package com.example.ticketbooking;

import java.util.Date;
import java.util.List;

public class CinemaShowTimeRepository {
    private static CinemaShowTimeRepository instance;
    private CinemaShowTimeDataSource dataSource;

    public CinemaShowTimeRepository(CinemaShowTimeDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static CinemaShowTimeRepository getInstance(CinemaShowTimeDataSource dataSource) {
        if (instance == null) {
            instance = new CinemaShowTimeRepository(dataSource);
        }
        return instance;
    }

    public List<Date> getListDates(Date startDate) {
        return this.dataSource.getListDates(startDate, 10);
    }

    public List<ShowTimes> getListShowtimes(Date startTime) {
        return this.dataSource.getListShowtimes(startTime, 10);
    }

    public InfoFilm getMovieInfo() {
        return this.dataSource.getMovieInfo();
    }
}
