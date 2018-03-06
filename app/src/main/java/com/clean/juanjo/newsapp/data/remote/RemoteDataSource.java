package com.clean.juanjo.newsapp.data.remote;

import com.clean.juanjo.newsapp.BuildConfig;
import com.clean.juanjo.newsapp.domain.News;

import javax.inject.Inject;

import dagger.Lazy;
import io.reactivex.Observable;

/**
 * Created by Juanjo Berenguer.
 * Email: surkhojb@gmail.com.
 * Date: 01/03/2018.
 */

public class RemoteDataSource implements IRemoteDataSource{
    private final String API_KEY = BuildConfig.API_KEY;

    @Inject
    Lazy<NewsApi> newsApi;

    @Inject
    public RemoteDataSource(){}

    @Override
    public Observable<News> getNews() {
        return newsApi.get().getNews(API_KEY);
    }

    @Override
    public Observable<News> getNewsBySearch(String query) {

        return newsApi.get().getNewsBySearch(query,API_KEY);
    }
}
