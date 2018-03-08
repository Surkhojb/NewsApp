package com.clean.juanjo.newsapp.data;

import android.arch.lifecycle.LiveData;
import com.clean.juanjo.newsapp.data.local.ArticleDto;
import com.clean.juanjo.newsapp.data.local.LocalDataSource;
import com.clean.juanjo.newsapp.data.remote.RemoteDataSource;
import com.clean.juanjo.newsapp.domain.News;

import io.reactivex.Single;
import java.util.concurrent.Callable;
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
    public LocalDataSource local;

    @Inject
    public NewsRepository(){}

    @Override
    public Observable<News> getNews() {
        return remote.getNews();
    }

    @Override
    public Observable<News> getNewsBySearch(String query) {
        return remote.getNewsBySearch(query);
    }

    @Override public LiveData<ArticleDto> getBooksMark() {
        return null;
    }

    @Override public Single<Boolean> addBooksMark(ArticleDto article) {
        return Single.fromCallable(() -> {
            local.addBooksMark(article);
            return true;
        });
    }
}
