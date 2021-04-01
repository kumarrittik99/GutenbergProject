package com.kumarrittik99.gutenbergproject.services;

import com.kumarrittik99.gutenbergproject.utilities.Constants;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static final String BASE_URL = Constants.BASE_URL;
    private static Retrofit instance;

    public static BookDataService getService() {
        if(instance == null) {
            instance = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return instance.create(BookDataService.class);
    }


}
