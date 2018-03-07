package com.clean.juanjo.newsapp;

import android.app.Application;

import android.content.Context;
import com.clean.juanjo.newsapp.injection.component.AppComponent;

import com.clean.juanjo.newsapp.injection.component.DaggerAppComponent;
import com.clean.juanjo.newsapp.injection.module.AppModule;
import com.clean.juanjo.newsapp.injection.module.LocalDataSourceModule;
import com.clean.juanjo.newsapp.injection.module.RemoteDataSourceModule;

/**
 * Created by Juanjo Berenguer.
 * Email: surkhojb@gmail.com.
 * Date: 01/03/2018.
 */

public class NewsApp extends Application{

    private static AppComponent appComponent;


    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .remoteDataSourceModule(new RemoteDataSourceModule())
                .localDataSourceModule(new LocalDataSourceModule(this))
                .build();

        appComponent.inject(this);
    }

    public static AppComponent getComponent(){
        return appComponent;
    }
    public static Context getAppContext(){
        return appComponent.context();
    }
}
