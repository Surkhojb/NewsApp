package com.clean.juanjo.newsapp.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import static com.clean.juanjo.newsapp.data.local.ArticleDatabase.DATABASE_VERSION;

/**
 * Created by Juanjo Berenguer.
 * Email: surkhojb@gmail.com.
 * Date: 07/03/2018.
 */

@Database(entities = ArticleDto.class , version = DATABASE_VERSION,exportSchema = false)
public abstract class ArticleDatabase extends RoomDatabase{
  protected static final int DATABASE_VERSION = 1;
  public static final String DATABASE_NAME = "news-app.db";

  public abstract ArticleDao articleDao();
}
