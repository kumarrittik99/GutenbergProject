package com.kumarrittik99.gutenbergproject.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Book {

    @SerializedName("id")
    private Integer id;

    @SerializedName("authors")
    private List<Author> authors = null;

    @SerializedName("bookshelves")
    private List<String> bookshelves = null;

    @SerializedName("download_count")
    private Integer downloadCount;

    @SerializedName("formats")
    private Formats formats;

    @SerializedName("languages")
    private List<String> languages = null;

    @SerializedName("media_type")
    private String mediaType;

    @SerializedName("subjects")
    private List<String> subjects = null;

    @SerializedName("title")
    private String title;

    public Book() {
    }

    public Book(Integer id, List<Author> authors, List<String> bookshelves, Integer downloadCount, Formats formats, List<String> languages, String mediaType, List<String> subjects, String title) {
        super();
        this.id = id;
        this.authors = authors;
        this.bookshelves = bookshelves;
        this.downloadCount = downloadCount;
        this.formats = formats;
        this.languages = languages;
        this.mediaType = mediaType;
        this.subjects = subjects;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<String> getBookshelves() {
        return bookshelves;
    }

    public void setBookshelves(List<String> bookshelves) {
        this.bookshelves = bookshelves;
    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }

    public Formats getFormats() {
        return formats;
    }

    public void setFormats(Formats formats) {
        this.formats = formats;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean equals(Book newItem) {
        return this == newItem;
    }
}
