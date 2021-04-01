package com.kumarrittik99.gutenbergproject.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.kumarrittik99.gutenbergproject.R;
import com.kumarrittik99.gutenbergproject.adapters.GenreAdapter;
import com.kumarrittik99.gutenbergproject.databinding.ActivityMainBinding;
import com.kumarrittik99.gutenbergproject.models.BookDataResponse;
import com.kumarrittik99.gutenbergproject.models.Genre;
import com.kumarrittik99.gutenbergproject.services.BookDataService;
import com.kumarrittik99.gutenbergproject.services.RetrofitInstance;
import com.kumarrittik99.gutenbergproject.utilities.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements GenreAdapter.GenreClickListener {

    private ActivityMainBinding binding;
    private List<Genre> genreList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);

        //setting up the genre list recycler view
        setupGenreRecyclerview();

    }

    private void setupGenreRecyclerview() {
        genreList = Constants.getGenreList();
        GenreAdapter adapter = new GenreAdapter(MainActivity.this, genreList, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        binding.rvMainActivity.setAdapter(adapter);
        binding.rvMainActivity.setLayoutManager(layoutManager);
    }


    @Override
    public void onClickGenreItem(int position) {
        Intent intent = new Intent(MainActivity.this, BooksActivity.class);
        intent.putExtra("genre_title", genreList.get(position).getGenreName());
        startActivity(intent);
    }
}