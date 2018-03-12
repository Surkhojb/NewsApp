package com.clean.juanjo.newsapp.data.local;

import android.arch.lifecycle.LiveData;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by Juanjo Berenguer.
 * Email: surkhojb@gmail.com.
 * Date: 07/03/2018.
 */

public class LocalDataSource implements ILocalDataSource {

  @Inject
  ArticleDao articleDao;

  @Inject
  public LocalDataSource(){}

  @Override public Observable<List<ArticleDto>> getArticles() {
    return Observable.fromCallable(() -> articleDao.getBooksMarks());
  }

  @Override public void addBooksMark(ArticleDto article) {
    articleDao.insertArticle(article);
  }

  @Override public void deleteBooksMark(ArticleDto article) {

  }
}
