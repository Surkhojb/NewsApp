package com.clean.juanjo.newsapp.injection.component;

import android.content.Context;

import android.content.res.Resources;
import com.clean.juanjo.newsapp.NewsApp;
import com.clean.juanjo.newsapp.data.INewsRepository;
import com.clean.juanjo.newsapp.injection.module.LocalDataSourceModule;
import com.clean.juanjo.newsapp.injection.module.RemoteDataSourceModule;
import com.clean.juanjo.newsapp.injection.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Juanjo Berenguer.
 * Email: surkhojb@gmail.com.
 * Date: 01/03/2018.
 */

@Singleton
@Component(modules = {AppModule.class,RemoteDataSourceModule.class, LocalDataSourceModule.class})
public interface AppComponent {
    void inject(NewsApp app);

    Context context();

    INewsRepository repository();
}
