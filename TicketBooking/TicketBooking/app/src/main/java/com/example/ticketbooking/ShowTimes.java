package com.example.ticketbooking;

import java.util.Date;

public class ShowTimes {
    private Date time;
    private boolean available;

    public ShowTimes(Date time, boolean available) {
        this.time = time;
        this.available = available;
    }

    public Date getTime() {
        return time;
    }

    public boolean isAvailable() {
        return available;
    }

}
