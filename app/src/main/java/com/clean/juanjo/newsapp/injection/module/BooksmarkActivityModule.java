package com.clean.juanjo.newsapp.injection.module;

import com.clean.juanjo.newsapp.data.INewsRepository;
import com.clean.juanjo.newsapp.data.NewsRepository;
import com.clean.juanjo.newsapp.domain.mapper.ArticleTransformer;
import com.clean.juanjo.newsapp.injection.PerActivity;
import com.clean.juanjo.newsapp.ui.booksmark.modelview.BooksmarkViewModelFactory;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Juanjo Berenguer.
 * Email: surkhojb@gmail.com.
 * Date: 10/3/18.
 */

@Module
public class BooksmarkActivityModule {

    public BooksmarkActivityModule(){}

    @PerActivity
    @Provides
    BooksmarkViewModelFactory providesFactory(INewsRepository repository,
                                              ArticleTransformer transformer){
        return new BooksmarkViewModelFactory(repository,transformer);
    }
}
