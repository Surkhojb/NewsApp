package com.clean.juanjo.newsapp.data;

import com.clean.juanjo.newsapp.data.remote.RemoteDataSource;
import com.clean.juanjo.newsapp.domain.News;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Juanjo Berenguer.
 * Email: surkhojb@gmail.com.
 * Date: 01/03/2018.
 */

public class NewsRepository implements INewsRepository {

    @Inject
    public RemoteDataSource remote;

    @Inject
    public NewsRepository(){}

    @Override
    public Observable<News> getNews() {
        return remote.getNews();
    }
}
