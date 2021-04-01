package com.kumarrittik99.gutenbergproject.models;

import com.google.gson.annotations.SerializedName;

public class Author {

    @SerializedName("birth_year")
    private Integer birthYear;

    @SerializedName("death_year")
    private Integer deathYear;

    @SerializedName("name")
    private String name;

    public Author() {

    }

    public Author(Integer birthYear, Integer deathYear, String name) {
        this.birthYear = birthYear;
        this.deathYear = deathYear;
        this.name = name;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
