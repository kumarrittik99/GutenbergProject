package com.kumarrittik99.gutenbergproject.viewmodels;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.kumarrittik99.gutenbergproject.models.Book;
import com.kumarrittik99.gutenbergproject.paging.BookDataSource;
import com.kumarrittik99.gutenbergproject.paging.BooksDataSourceFactory;
import com.kumarrittik99.gutenbergproject.repositories.BooksRepository;
import com.kumarrittik99.gutenbergproject.services.BookDataService;
import com.kumarrittik99.gutenbergproject.services.RetrofitInstance;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class BooksActivityViewModel extends AndroidViewModel {

    private BooksRepository booksRepository;


    public BooksActivityViewModel(@NonNull Application application) {
        super(application);
        booksRepository = new BooksRepository(application);
    }


    public LiveData<PagedList<Book>> getBookPagedListLiveData(String genreTitle) {
        return booksRepository.getBookPagedList(genreTitle);
    }

    public LiveData<PagedList<Book>> getBookPagedListSearched(String genreTitle, String queryString) {
        return booksRepository.getBookPagedListSearched(genreTitle, queryString);
    }
}
