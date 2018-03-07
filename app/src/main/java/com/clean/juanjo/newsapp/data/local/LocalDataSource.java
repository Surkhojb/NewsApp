package com.clean.juanjo.newsapp.data.local;

import android.arch.lifecycle.LiveData;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by Juanjo Berenguer.
 * Email: surkhojb@gmail.com.
 * Date: 07/03/2018.
 */

public class LocalDataSource implements ILocalDataSource {

  @Inject
  public LocalDataSource(){}

  @Override public LiveData<List<ArticleDto>> getArticles() {
    return null;
  }

  @Override public void addBooksMark(ArticleDto article) {

  }

  @Override public void deleteBooksMark(ArticleDto article) {

  }
}
