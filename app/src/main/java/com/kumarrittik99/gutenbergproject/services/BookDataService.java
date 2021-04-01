package com.kumarrittik99.gutenbergproject.services;

import com.kumarrittik99.gutenbergproject.models.BookDataResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BookDataService {

    @GET("books?mime_type=image/jpeg")
    Call<BookDataResponse> getAllBooksAccordingToGenre(@Query("topic") String genreTitle, @Query("page") int page);

    @GET("books?mime_type=image/jpeg")
    Call<BookDataResponse> getAllBooksAccordingToSearchQuery(@Query("topic") String genreTitle, @Query("search") String queryString, @Query("page") int page);

}
