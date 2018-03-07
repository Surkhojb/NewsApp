package com.clean.juanjo.newsapp.injection.module;

import android.arch.persistence.room.Room;
import com.clean.juanjo.newsapp.NewsApp;
import com.clean.juanjo.newsapp.data.local.ArticleDao;
import com.clean.juanjo.newsapp.data.local.ArticleDatabase;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by Juanjo Berenguer.
 * Email: surkhojb@gmail.com.
 * Date: 07/03/2018.
 */

@Module
public class LocalDataSourceModule {
  private ArticleDatabase database;
  private NewsApp application;

  public LocalDataSourceModule(NewsApp application) {
    this.application = application;
  }

  @Singleton
  @Provides
  ArticleDatabase provideDatabase(){
    database =  Room.databaseBuilder(application,ArticleDatabase.class,
        ArticleDatabase.DATABASE_NAME).build();
    return database;
  }

  @Singleton
  @Provides
  ArticleDao providesDao(){
    return database.articleDao();
  }

}
