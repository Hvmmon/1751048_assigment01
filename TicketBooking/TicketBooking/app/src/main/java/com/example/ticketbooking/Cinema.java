package com.example.ticketbooking;

import java.util.List;

public class Cinema {
    private List<ShowTimes> showTimeLists;
    static boolean choosed;
    private String nCinema;
    Cinema(String nameCinema,List<ShowTimes> showtime, boolean choosed)
    {
        this.nCinema=nameCinema;
        showTimeLists=showtime;
        this.choosed = choosed;
    }

    public String getNameCinema()
    {
        return nCinema;
    }
    public List<ShowTimes> getShowTimeList()
    {
        return showTimeLists;
    }

}

