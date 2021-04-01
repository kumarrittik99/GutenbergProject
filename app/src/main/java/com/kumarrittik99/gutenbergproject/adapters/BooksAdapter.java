package com.kumarrittik99.gutenbergproject.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.kumarrittik99.gutenbergproject.R;
import com.kumarrittik99.gutenbergproject.databinding.LayoutBookItemBinding;
import com.kumarrittik99.gutenbergproject.models.Book;

import java.util.List;

public class BooksAdapter extends PagedListAdapter<Book, BooksAdapter.BooksHolder> {

    private Context context;
    private LayoutInflater layoutInflater;
    private BookClickListener bookClickListener;

    public BooksAdapter(Context context, BookClickListener bookClickListener) {
        super(DIFF_CALLBACK);
        this.context = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.bookClickListener = bookClickListener;
    }

    //need this diffutil call back in order to check wether two items are same or not
    private static DiffUtil.ItemCallback<Book> DIFF_CALLBACK = new DiffUtil.ItemCallback<Book>() {
        @Override
        public boolean areItemsTheSame(@NonNull Book oldItem, @NonNull Book newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Book oldItem, @NonNull Book newItem) {
            return oldItem.equals(newItem);
        }
    };

    @NonNull
    @Override
    public BooksHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.layout_book_item, parent, false);
        BooksHolder holder = new BooksHolder(view, bookClickListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull BooksHolder holder, int position) {
        LayoutBookItemBinding binding = holder.binding;
        Book book = getItem(position);
        String imageUrl = book.getFormats().getImageJpeg();
        Glide.with(context)
                .load(imageUrl)
                .centerCrop()
                .placeholder(R.drawable.loading)
                .into(binding.ivBookImage);
        binding.tvBookTitle.setText(book.getTitle());
        if(book.getAuthors().size() > 0) {
            binding.tvBookAuthor.setText(book.getAuthors().get(0).getName());
        }
    }


    public class BooksHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private LayoutBookItemBinding binding;
        private BookClickListener bookClickListener;

        public BooksHolder(@NonNull View itemView, BookClickListener bookClickListener) {
            super(itemView);

            binding = DataBindingUtil.bind(itemView);
            binding.getRoot().setOnClickListener(this);
            this.bookClickListener = bookClickListener;
        }

        @Override
        public void onClick(View v) {
            bookClickListener.onBookClick(getAdapterPosition());
        }
    }

    public interface BookClickListener {
        void onBookClick(int position);
    }
}
