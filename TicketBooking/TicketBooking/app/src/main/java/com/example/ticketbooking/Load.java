package com.example.ticketbooking;

public class Load {
    static int cinemaChecked = -1;
    static int timeChecked=-1;
    static int tempCinema=-1;
    static int tempTime=-1;
    static int dateChecked=-1;
    static String movieTitle, cinemaName, dMonth, dWeek, dTime;

    static void setTemp(int Cinema,int Time)
    {
        tempCinema=Cinema;
        tempTime=Time;
    }
    static int getCinemaChecked(){
        return cinemaChecked;
    }
    static int getTimeChecked(){
        return timeChecked;
    }
    static int getDateChecked() {return dateChecked;}
    static void setCinemaChecked(int position){
        cinemaChecked = position;
    }
    static void setDateChecked(int position){dateChecked=position;}
    static void setTimeChecked(int position){
        timeChecked = position;
    }
    static void setMovieName(String movietitle){movieTitle=movietitle;}
    static void setCinemaName(String cinemaname){cinemaName=cinemaname;}
    static void setDayMonth(String dmonth){dMonth=dmonth;}
    static void setDayWeek(String dweek){dWeek=dweek;}
    static void setTime(String time){dTime=time;}

}

