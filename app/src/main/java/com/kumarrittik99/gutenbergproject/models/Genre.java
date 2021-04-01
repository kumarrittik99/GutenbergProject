package com.kumarrittik99.gutenbergproject.models;

public class Genre {

    private String genreName;

    private int genreImageId;

    public Genre(String genreName, int genreImageId) {
        this.genreName = genreName;
        this.genreImageId = genreImageId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public int getGenreImageId() {
        return genreImageId;
    }

    public void setGenreImage(int genreImageId) {
        this.genreImageId = genreImageId;
    }
}
