package com.clean.juanjo.newsapp.data.remote;

import com.clean.juanjo.newsapp.domain.News;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Juanjo Berenguer.
 * Email: surkhojb@gmail.com.
 * Date: 01/03/2018.
 */

public interface NewsApi {
    @GET("top-headlines?sources=google-news&apiKey=629fee6ea2c14beeb0eb6496b90f2781")
    Observable<News> getNews();
}
