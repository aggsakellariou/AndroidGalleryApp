package com.galleryapp;

public class Painting {
    private final int imageResource;
    private final String title;
    private final String artist;
    private final String year;
    private final String description;
    private final String category;

    public Painting(int imageResource, String title, String artist, String year, String description, String category) {
        this.imageResource = imageResource;
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.description = description;
        this.category = category;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getYear() {
        return year;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }
}