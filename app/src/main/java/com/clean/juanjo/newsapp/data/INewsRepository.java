package com.clean.juanjo.newsapp.data;

import android.arch.lifecycle.LiveData;
import com.clean.juanjo.newsapp.data.local.ArticleDto;
import com.clean.juanjo.newsapp.domain.News;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by Juanjo Berenguer.
 * Email: surkhojb@gmail.com.
 * Date: 01/03/2018.
 */

public interface INewsRepository {
    Observable<News> getNews();
    Observable<News> getNewsBySearch(String query);
    Observable<List<ArticleDto>> getBooksMark();
    Single<Boolean> addBooksMark(ArticleDto article);
}
