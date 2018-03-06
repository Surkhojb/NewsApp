package com.clean.juanjo.newsapp.data.remote;

import com.clean.juanjo.newsapp.domain.News;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Juanjo Berenguer.
 * Email: surkhojb@gmail.com.
 * Date: 01/03/2018.
 */

public interface NewsApi {
    @GET("top-headlines?sources=ars-technica")
    Observable<News> getNews(@Query("apiKey") String apiKey);

    @GET("everything")
    Observable<News> getNewsBySearch(@Query("q") String query, @Query("apiKey")String apiKey);
}
