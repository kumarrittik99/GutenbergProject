package com.kumarrittik99.gutenbergproject.repositories;

import android.app.Application;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.kumarrittik99.gutenbergproject.models.Book;
import com.kumarrittik99.gutenbergproject.models.BookDataResponse;
import com.kumarrittik99.gutenbergproject.paging.BookDataSource;
import com.kumarrittik99.gutenbergproject.paging.BookDataSourceSearchedFactory;
import com.kumarrittik99.gutenbergproject.paging.BooksDataSourceFactory;
import com.kumarrittik99.gutenbergproject.services.BookDataService;
import com.kumarrittik99.gutenbergproject.services.RetrofitInstance;
import com.kumarrittik99.gutenbergproject.views.BooksActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BooksRepository {

    private Application application;

    private LiveData<PagedList<Book>> bookPagedListLiveData;
    private LiveData<PagedList<Book>> bookPagedListSearchedLiveData;

    public BooksRepository(Application application) {
        this.application = application;
    }

    public LiveData<PagedList<Book>> getBookPagedList(String genreTitle) {
        BooksDataSourceFactory factory = new BooksDataSourceFactory(application, genreTitle);
        MutableLiveData<BookDataSource> bookDataSourceMutableLiveData = factory.getMutableLiveData();

        PagedList.Config config = (new PagedList.Config.Builder())
                                    .setEnablePlaceholders(true)
                                    .setInitialLoadSizeHint(32)
                                    .setPageSize(20)
                                    .setPrefetchDistance(2)
                                    .build();

        Executor executor = Executors.newFixedThreadPool(5);

        bookPagedListLiveData = (new LivePagedListBuilder<Integer, Book>(factory, config))
                                .setFetchExecutor(executor)
                                .build();

        return bookPagedListLiveData;
    }


    public LiveData<PagedList<Book>> getBookPagedListSearched(String genreTitle, String queryString) {
        BookDataSourceSearchedFactory factory = new BookDataSourceSearchedFactory(application, genreTitle, queryString);

        PagedList.Config config = (new PagedList.Config.Builder())
                .setEnablePlaceholders(true)
                .setInitialLoadSizeHint(32)
                .setPageSize(20)
                .setPrefetchDistance(2)
                .build();

        Executor executor = Executors.newFixedThreadPool(5);

        bookPagedListSearchedLiveData = (new LivePagedListBuilder<Integer, Book>(factory, config))
                                        .setFetchExecutor(executor)
                                        .build();

        return bookPagedListSearchedLiveData;
    }
}
