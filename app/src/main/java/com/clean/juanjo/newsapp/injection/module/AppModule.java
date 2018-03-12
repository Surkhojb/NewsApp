package com.clean.juanjo.newsapp.injection.module;

import android.content.Context;

import android.content.res.Resources;
import com.clean.juanjo.newsapp.NewsApp;
import com.clean.juanjo.newsapp.data.INewsRepository;
import com.clean.juanjo.newsapp.data.NewsRepository;
import com.clean.juanjo.newsapp.data.local.ILocalDataSource;
import com.clean.juanjo.newsapp.data.local.LocalDataSource;
import com.clean.juanjo.newsapp.data.remote.IRemoteDataSource;
import com.clean.juanjo.newsapp.data.remote.RemoteDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Juanjo Berenguer.
 * Email: surkhojb@gmail.com.
 * Date: 01/03/2018.
 */

@Module
public class AppModule {
    private NewsApp app;

    public AppModule(NewsApp app) {
        this.app = app;
    }

    @Singleton
    @Provides
    Context providesAppContext(){
        return app.getApplicationContext();
    }

    @Singleton
    @Provides
    IRemoteDataSource providesRemote(RemoteDataSource remoteDataSource){
        return remoteDataSource;
    }

    @Singleton
    @Provides
    ILocalDataSource providesLocalDb(LocalDataSource localDataSource){
        return localDataSource;
    }

    @Singleton
    @Provides
    INewsRepository providesRepository(NewsRepository newsRepository){
        return newsRepository;
    }
}
