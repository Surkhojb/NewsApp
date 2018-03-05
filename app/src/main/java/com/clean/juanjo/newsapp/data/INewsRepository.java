package com.clean.juanjo.newsapp.data;

import com.clean.juanjo.newsapp.domain.News;

import io.reactivex.Observable;

/**
 * Created by Juanjo Berenguer.
 * Email: surkhojb@gmail.com.
 * Date: 01/03/2018.
 */

public interface INewsRepository {
    Observable<News> getNews();
}
