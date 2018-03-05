package com.clean.juanjo.newsapp.ui.main.presentation;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.clean.juanjo.newsapp.data.INewsRepository;

import javax.inject.Inject;

/**
 * Created by Juanjo Berenguer.
 * Email: surkhojb@gmail.com.
 * Date: 01/03/2018.
 */

public class NewsViewModelFactory implements ViewModelProvider.Factory {

    private INewsRepository newsRepository;

    @Inject
    public NewsViewModelFactory(INewsRepository repository){
        this.newsRepository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(NewsViewModel.class))
            return (T) new NewsViewModel(newsRepository);
        throw new IllegalArgumentException("Unknow viewmodel class");
    }
}
