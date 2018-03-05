package com.clean.juanjo.newsapp.data.remote;

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

    @Inject
    Lazy<NewsApi> newsApi;

    @Inject
    public RemoteDataSource(){}

    @Override
    public Observable<News> getNews() {
        return newsApi.get().getNews();
    }
}
