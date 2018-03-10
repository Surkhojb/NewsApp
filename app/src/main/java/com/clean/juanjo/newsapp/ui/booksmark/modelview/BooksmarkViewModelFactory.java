package com.clean.juanjo.newsapp.ui.booksmark.modelview;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.clean.juanjo.newsapp.data.NewsRepository;
import com.clean.juanjo.newsapp.domain.mapper.ArticleTransformer;
import com.clean.juanjo.newsapp.ui.main.modelview.NewsViewModel;

import javax.inject.Inject;

/**
 * Created by Juanjo Berenguer.
 * Email: surkhojb@gmail.com.
 * Date: 10/3/18.
 */

public class BooksmarkViewModelFactory implements ViewModelProvider.Factory{

    private ArticleTransformer articleTransformer;
    private NewsRepository newsRepository;

    @Inject
    public BooksmarkViewModelFactory(NewsRepository repository,ArticleTransformer transformer){
        this.newsRepository = repository;
        this.articleTransformer = transformer;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(BooksmarkViewModel.class))
            return (T) new BooksmarkViewModel(newsRepository,articleTransformer);
        throw new IllegalArgumentException("Unknow viewmodel class");
    }
}
