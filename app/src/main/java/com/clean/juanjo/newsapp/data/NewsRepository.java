package com.clean.juanjo.newsapp.data;

import com.clean.juanjo.newsapp.data.local.ArticleDto;
import com.clean.juanjo.newsapp.data.local.ILocalDataSource;
import com.clean.juanjo.newsapp.data.remote.IRemoteDataSource;
import com.clean.juanjo.newsapp.domain.News;

import io.reactivex.Single;

import java.util.List;
import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Juanjo Berenguer.
 * Email: surkhojb@gmail.com.
 * Date: 01/03/2018.
 */

public class NewsRepository implements INewsRepository {

    @Inject
    public IRemoteDataSource remote;
    @Inject
    public ILocalDataSource local;

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

    @Override public Observable<List<ArticleDto>> getBooksMark() {
        return local.getArticles();
    }

    @Override public Single<Boolean> addBooksMark(ArticleDto article) {
        return Single.fromCallable(() -> {
            local.addBooksMark(article);
            return true;
        });
    }
}
