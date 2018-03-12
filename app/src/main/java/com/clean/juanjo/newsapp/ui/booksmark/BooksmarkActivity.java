package com.clean.juanjo.newsapp.ui.booksmark;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.clean.juanjo.newsapp.NewsApp;
import com.clean.juanjo.newsapp.R;
import com.clean.juanjo.newsapp.injection.component.BooksmarkActivityComponent;
import com.clean.juanjo.newsapp.injection.component.DaggerBooksmarkActivityComponent;
import com.clean.juanjo.newsapp.injection.module.BooksmarkActivityModule;
import com.clean.juanjo.newsapp.ui.booksmark.modelview.BooksmarkAdapter;
import com.clean.juanjo.newsapp.ui.booksmark.modelview.BooksmarkViewModel;
import com.clean.juanjo.newsapp.ui.booksmark.modelview.BooksmarkViewModelFactory;
import javax.inject.Inject;

public class BooksmarkActivity extends AppCompatActivity {

    @BindView(R.id.rv_booksmark)
    RecyclerView rvBooksmark;
    BooksmarkAdapter rvAdapter;

    @Inject
    BooksmarkViewModelFactory booksmarkViewModelFactory;
    BooksmarkViewModel booksmarkViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booksmark);
        ButterKnife.bind(this);
        injectDependencies();
        initRecyclerView();

        booksmarkViewModel = ViewModelProviders.of(this,booksmarkViewModelFactory).get(BooksmarkViewModel.class);
        booksmarkViewModel.booksmark().observe(this,articleModels -> rvAdapter.refreshArticles(articleModels));
        booksmarkViewModel.loadBooksmark();
    }

  private void initRecyclerView() {
      rvBooksmark.setHasFixedSize(true);
      rvBooksmark.setLayoutManager(new LinearLayoutManager(this));
      rvAdapter = new BooksmarkAdapter();
      rvBooksmark.setAdapter(rvAdapter);
  }

  private void injectDependencies() {
        DaggerBooksmarkActivityComponent.builder()
                .appComponent(NewsApp.getComponent())
                .booksmarkActivityModule(new BooksmarkActivityModule())
                .build()
                .inject(this);
    }
}
