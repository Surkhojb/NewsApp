package com.clean.juanjo.newsapp.ui.booksmark;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.clean.juanjo.newsapp.NewsApp;
import com.clean.juanjo.newsapp.R;
import com.clean.juanjo.newsapp.injection.component.BooksmarkActivityComponent;
import com.clean.juanjo.newsapp.injection.component.DaggerBooksmarkActivityComponent;
import com.clean.juanjo.newsapp.injection.module.BooksmarkActivityModule;

public class BooksmarkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booksmark);
        injectDependencies();
    }

    private void injectDependencies() {
        DaggerBooksmarkActivityComponent.builder()
                .appComponent(NewsApp.getComponent())
                .booksmarkActivityModule(new BooksmarkActivityModule())
                .build()
                .inject(this);
    }
}
