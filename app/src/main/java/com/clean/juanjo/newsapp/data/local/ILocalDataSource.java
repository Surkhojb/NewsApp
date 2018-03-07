package com.clean.juanjo.newsapp.data.local;

import android.arch.lifecycle.LiveData;
import java.util.List;

/**
 * Created by Juanjo Berenguer.
 * Email: surkhojb@gmail.com.
 * Date: 07/03/2018.
 */

public interface ILocalDataSource {
  LiveData<List<ArticleDto>> getArticles();
  void addBooksMark(ArticleDto article);
  void deleteBooksMark(ArticleDto article);
}
