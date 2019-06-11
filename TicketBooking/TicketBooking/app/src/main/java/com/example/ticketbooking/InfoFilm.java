package com.example.ticketbooking;

import java.util.ArrayList;
import java.util.List;

public class InfoFilm {
    private String title, type, synopsis;
    private double rating;
    private Integer duration;
    private List<String> genres;
    public ArrayList ShowTimes;

    public InfoFilm(
            String title,
            String type,
            String synopsis,
            double rating,
            Integer duration,
            List<String> genres) {
        this.title = title;
        this.rating = rating;
        this.duration= duration;
        this.type = type;
        this.synopsis = synopsis;
        this.genres = genres;
    }

    public String getTitle() {
        return this.title;
    }

    public Double getRating() { return this.rating; }

    public Integer getDuration() { return this.duration; }

    public String getSynopsis() {
        return this.synopsis;
    }

    public List<String> getGenres() {
        return this.genres;
    }

    public String getType() {
        return this.type;
    }
}
