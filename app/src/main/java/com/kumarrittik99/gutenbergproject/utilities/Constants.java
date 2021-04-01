package com.kumarrittik99.gutenbergproject.utilities;

import com.kumarrittik99.gutenbergproject.R;
import com.kumarrittik99.gutenbergproject.models.Genre;

import java.util.ArrayList;
import java.util.List;

public class Constants {

    public static final String BASE_URL =  "http://skunkworks.ignitesol.com:8000/";

    public static final String[] GENRES = {"Fiction", "Drama", "Humour", "Politics", "Philosophy", "History", "Adventure"};
    public static final int[] GENRES_ICONS = {R.drawable.fiction, R.drawable.drama, R.drawable.humor, R.drawable.politics,
                                                R.drawable.philosophy, R.drawable.history, R.drawable.adventure};

    public static List<Genre> getGenreList() {
        List<Genre> genreList = new ArrayList<>();
        for(int i=0;i<GENRES.length;i++) {
            Genre genre = new Genre(GENRES[i], GENRES_ICONS[i]);
            genreList.add(genre);
        }
        return genreList;
    }

}
