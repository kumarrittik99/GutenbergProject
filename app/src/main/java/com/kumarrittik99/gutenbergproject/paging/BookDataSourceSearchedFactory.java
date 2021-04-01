package com.kumarrittik99.gutenbergproject.paging;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

public class BookDataSourceSearchedFactory extends DataSource.Factory {

    private Application application;
    private String genreTitle;
    private String queryString;

    private MutableLiveData<BookDataSourceSearched> bookDataSourceSearchedMutableLiveData;

    public BookDataSourceSearchedFactory(Application application, String genreTitle, String queryString) {
        this.application = application;
        this.genreTitle = genreTitle;
        this.queryString = queryString;

        bookDataSourceSearchedMutableLiveData = new MutableLiveData<>();
    }



    @NonNull
    @Override
    public DataSource create() {
        BookDataSourceSearched bookDataSourceSearched = new BookDataSourceSearched(application, genreTitle, queryString);
        bookDataSourceSearchedMutableLiveData.postValue(bookDataSourceSearched);
        return bookDataSourceSearched;
    }

    public MutableLiveData<BookDataSourceSearched> getBookDataSourceSearchedMutableLiveData() {
        return bookDataSourceSearchedMutableLiveData;
    }
}
