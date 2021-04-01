package com.kumarrittik99.gutenbergproject.paging;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

import com.kumarrittik99.gutenbergproject.paging.BookDataSource;
import com.kumarrittik99.gutenbergproject.services.BookDataService;

public class BooksDataSourceFactory extends DataSource.Factory {

    private Application application;

    private String genreTitle;


    private BookDataSource dataSource;
    private MutableLiveData<BookDataSource> bookDataSourceMutableLiveData;

    public BooksDataSourceFactory(Application application, String genreTitle) {
        this.application = application;
        this.genreTitle = genreTitle;
        bookDataSourceMutableLiveData = new MutableLiveData<>();
    }

    @NonNull
    @Override
    public DataSource create() {
        dataSource = new BookDataSource(application, genreTitle);
        bookDataSourceMutableLiveData.postValue(dataSource);
        return dataSource;
    }

    public MutableLiveData<BookDataSource> getMutableLiveData() {
        return bookDataSourceMutableLiveData;
    }
}
