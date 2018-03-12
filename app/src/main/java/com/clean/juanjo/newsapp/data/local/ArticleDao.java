package com.clean.juanjo.newsapp.data.local;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import java.util.List;

/**
 * Created by Juanjo Berenguer.
 * Email: surkhojb@gmail.com.
 * Date: 07/03/2018.
 */

@Dao
public interface ArticleDao {
  @Query("SELECT * FROM articles")
  List<ArticleDto> getBooksMarks();

  @Insert
  long insertArticle(ArticleDto article);

  @Delete
  void deleteArticle(ArticleDto article);
}
