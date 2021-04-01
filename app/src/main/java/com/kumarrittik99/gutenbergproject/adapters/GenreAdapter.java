package com.kumarrittik99.gutenbergproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.kumarrittik99.gutenbergproject.R;
import com.kumarrittik99.gutenbergproject.databinding.LayoutGenreItemBinding;
import com.kumarrittik99.gutenbergproject.models.Genre;
import java.util.List;

public class GenreAdapter extends RecyclerView.Adapter<GenreAdapter.GenreViewHolder> {

    private Context context;
    private LayoutInflater layoutInflater;
    private List<Genre> genreList = null;
    private GenreClickListener genreListener;

    public GenreAdapter(Context context, List<Genre> genreList, GenreClickListener genreListener) {
        this.context = context;
        this.genreList = genreList;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.genreListener = genreListener;
    }

    @NonNull
    @Override
    public GenreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.layout_genre_item, parent, false);
        GenreViewHolder holder = new GenreViewHolder(view, genreListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull GenreViewHolder holder, int position) {
        LayoutGenreItemBinding binding = holder.binding;
        Genre genre = genreList.get(position);
        binding.ivGenreIcon.setImageResource(genre.getGenreImageId());
        binding.tvGenreTitle.setText(genre.getGenreName());
    }

    @Override
    public int getItemCount() {
        return genreList.size();
    }

    public class GenreViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private LayoutGenreItemBinding binding = null;
        private GenreClickListener listener;

        public GenreViewHolder(@NonNull View itemView, GenreClickListener listener) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
            binding.getRoot().setOnClickListener(this);
            this.listener = listener;
        }

        @Override
        public void onClick(View v) {
            listener.onClickGenreItem(getAdapterPosition());
        }
    }

    public interface GenreClickListener {
        public void onClickGenreItem(int position);
    }
}
