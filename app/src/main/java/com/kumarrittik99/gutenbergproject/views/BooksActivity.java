package com.kumarrittik99.gutenbergproject.views;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;


import com.kumarrittik99.gutenbergproject.R;
import com.kumarrittik99.gutenbergproject.adapters.BooksAdapter;
import com.kumarrittik99.gutenbergproject.databinding.ActivityBooksBinding;
import com.kumarrittik99.gutenbergproject.models.Book;
import com.kumarrittik99.gutenbergproject.models.BookDataResponse;
import com.kumarrittik99.gutenbergproject.models.Formats;
import com.kumarrittik99.gutenbergproject.services.BookDataService;
import com.kumarrittik99.gutenbergproject.services.RetrofitInstance;
import com.kumarrittik99.gutenbergproject.viewmodels.BooksActivityViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BooksActivity extends AppCompatActivity implements BooksAdapter.BookClickListener {

    private ActivityBooksBinding binding;
    private BooksActivityViewModel viewModel;

    private PagedList<Book> bookList;

    private String genreTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(BooksActivity.this, R.layout.activity_books);

        ViewModelProvider.AndroidViewModelFactory factory = new ViewModelProvider.AndroidViewModelFactory(getApplication());
        viewModel = new ViewModelProvider(BooksActivity.this, factory).get(BooksActivityViewModel.class);

        //getting data from intent
        genreTitle = getIntent().getStringExtra("genre_title");

        //setting up the toolbar
        setupToolBar();

        //setup search view
        setupSearchView();

        //call for books
        getAllBooksAccordingToGenre(genreTitle);
    }

    private void setupToolBar() {
        binding.tbBooksActivity.setTitle(genreTitle);
        binding.tbBooksActivity.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void setupSearchView() {
        binding.svBooksActivity.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                getAllBooksAccordingToSearched(genreTitle, query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        binding.svBooksActivity.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                getAllBooksAccordingToGenre(genreTitle);
                return false;
            }
        });
    }

    private void getAllBooksAccordingToGenre(String genreTitle) {
        binding.pbBooksActivity.setVisibility(View.VISIBLE);
        LiveData<PagedList<Book>> books = viewModel.getBookPagedListLiveData(genreTitle);

       books.observe(this, new Observer<PagedList<Book>>() {
           @Override
           public void onChanged(PagedList<Book> books) {
               bookList = books;
               setupBooksRecyclerview();
           }
       });
    }

    private void getAllBooksAccordingToSearched(String genreTitle, String searchQuery) {
        binding.pbBooksActivity.setVisibility(View.VISIBLE);
        LiveData<PagedList<Book>> books = viewModel.getBookPagedListSearched(genreTitle, searchQuery);

        books.observe(this, new Observer<PagedList<Book>>() {
            @Override
            public void onChanged(PagedList<Book> books) {
                bookList = books;
                setupBooksRecyclerview();
            }
        });
    }


    private void setupBooksRecyclerview() {
        BooksAdapter adapter = new BooksAdapter(BooksActivity.this,this);
        GridLayoutManager layoutManager = new GridLayoutManager(BooksActivity.this, 3);
        adapter.submitList(bookList);
        binding.rvBooksActivity.setAdapter(adapter);
        binding.rvBooksActivity.setLayoutManager(layoutManager);
        binding.pbBooksActivity.setVisibility(View.GONE);
    }

    @Override
    public void onBookClick(int position) {
        Book book = bookList.get(position);
        Formats formats = book.getFormats();
        String url = null;

        if(formats.getTextHtml() != null) {
            url = formats.getTextHtml();
        } else if (formats.getApplicationPdf() != null) {
            url = formats.getApplicationPdf();
        } else if (formats.getTextPlain() != null) {
            url = formats.getTextPlain();
        } else if (formats.getTextPlainCharsetUtf8() != null) {
            url = formats.getTextPlainCharsetUtf8();
        }

        openBrowser(url);
    }

    private void openBrowser(String url) {
        if(url != null) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);
        } else {
            showAlertDialouge();
        }
    }

    private void showAlertDialouge() {
        new AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage("No Viewable version available")
                .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                       dialogInterface.dismiss();
                    }
                }).show();
    }
}