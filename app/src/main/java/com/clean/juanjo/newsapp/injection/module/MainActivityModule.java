package com.clean.juanjo.newsapp.injection.module;

import com.clean.juanjo.newsapp.data.INewsRepository;
import com.clean.juanjo.newsapp.domain.model.ArticleMapper;
import com.clean.juanjo.newsapp.injection.PerActivity;
import com.clean.juanjo.newsapp.ui.main.presentation.NewsViewModelFactory;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Juanjo Berenguer.
 * Email: surkhojb@gmail.com.
 * Date: 01/03/2018.
 */

@Module
public class MainActivityModule {

    public MainActivityModule() {}

    @PerActivity
    @Provides
    NewsViewModelFactory providesFactory(INewsRepository repository, ArticleMapper mapper){
        return new NewsViewModelFactory(repository,mapper);
    }


}
