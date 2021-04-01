package com.kumarrittik99.gutenbergproject.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BookDataResponse {

    @SerializedName("count")
    private Integer count;

    @SerializedName("next")
    private String next;

    @SerializedName("previous")
    private Object previous;

    @SerializedName("results")
    private List<Book> results = null;

    public BookDataResponse() {
    }


    public BookDataResponse(Integer count, String next, Object previous, List<Book> results) {
        super();
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public Object getPrevious() {
        return previous;
    }

    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    public List<Book> getBooks() {
        return results;
    }

    public void setBooks(List<Book> results) {
        this.results = results;
    }

}