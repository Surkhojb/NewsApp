package com.clean.juanjo.newsapp.data.remote;

import com.clean.juanjo.newsapp.domain.News;

import io.reactivex.Observable;

/**
 * Created by Juanjo Berenguer.
 * Email: surkhojb@gmail.com.
 * Date: 01/03/2018.
 */

public interface IRemoteDataSource {
    Observable<News> getNews();
    Observable<News> getNewsBySearch(String query);
}
