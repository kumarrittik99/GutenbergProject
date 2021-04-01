package com.kumarrittik99.gutenbergproject.paging;

import android.app.Application;
import android.app.ProgressDialog;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.kumarrittik99.gutenbergproject.models.Book;
import com.kumarrittik99.gutenbergproject.models.BookDataResponse;
import com.kumarrittik99.gutenbergproject.services.BookDataService;
import com.kumarrittik99.gutenbergproject.services.RetrofitInstance;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookDataSource extends PageKeyedDataSource<Integer, Book> {

    public static final int FIRST_PAGE = 1;

    private BookDataService service;

    private Application application;
    private String genreTitle;

    public BookDataSource(Application application, String genreTitle) {
        this.service = RetrofitInstance.getService();
        this.application = application;
        this.genreTitle = genreTitle;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, Book> callback) {
        Call<BookDataResponse> call =  service.getAllBooksAccordingToGenre(genreTitle, FIRST_PAGE);
        call.enqueue(new Callback<BookDataResponse>() {
            @Override
            public void onResponse(Call<BookDataResponse> call, Response<BookDataResponse> response) {
                BookDataResponse res = response.body();
                if(res != null && res.getBooks() != null) {
                    List<Book> bookList = res.getBooks();
                    callback.onResult(bookList, null, FIRST_PAGE + 1);
                }
            }

            @Override
            public void onFailure(Call<BookDataResponse> call, Throwable t) {
                Toast.makeText(application, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Book> callback) {
        Call<BookDataResponse> call =  service.getAllBooksAccordingToGenre(genreTitle, params.key);
        call.enqueue(new Callback<BookDataResponse>() {
            @Override
            public void onResponse(Call<BookDataResponse> call, Response<BookDataResponse> response) {
                BookDataResponse res = response.body();
                if(res != null && res.getBooks() != null) {
                    List<Book> bookList = res.getBooks();
                    callback.onResult(bookList, params.key - 1);
                }
            }

            @Override
            public void onFailure(Call<BookDataResponse> call, Throwable t) {
                Toast.makeText(application, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Book> callback) {
        Call<BookDataResponse> call =  service.getAllBooksAccordingToGenre(genreTitle, params.key);
        call.enqueue(new Callback<BookDataResponse>() {
            @Override
            public void onResponse(Call<BookDataResponse> call, Response<BookDataResponse> response) {
                BookDataResponse res = response.body();
                if(res != null && res.getBooks() != null) {
                    List<Book> bookList = res.getBooks();
                    callback.onResult(bookList, params.key + 1);
                }
            }

            @Override
            public void onFailure(Call<BookDataResponse> call, Throwable t) {
                Toast.makeText(application, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
