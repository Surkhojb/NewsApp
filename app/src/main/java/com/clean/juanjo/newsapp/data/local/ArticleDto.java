package com.clean.juanjo.newsapp.data.local;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Juanjo Berenguer.
 * Email: surkhojb@gmail.com.
 * Date: 07/03/2018.
 */

@Entity(tableName = "articles")
public class ArticleDto {
  @PrimaryKey(autoGenerate = true)
  private int id;
  @ColumnInfo(name = "title")
  private String title;
  @ColumnInfo(name = "description")
  private String description;
  @ColumnInfo(name = "author")
  private String dateAndAuthor;
  @ColumnInfo(name = "source")
  private String source;
  @ColumnInfo(name = "image_url")
  private String urlImage;
  @ColumnInfo(name = "url")
  private String urlToArticle;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getDateAndAuthor() {
    return dateAndAuthor;
  }

  public void setDateAndAuthor(String dateAndAuthor) {
    this.dateAndAuthor = dateAndAuthor;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public String getUrlImage() {
    return urlImage;
  }

  public void setUrlImage(String urlImage) {
    this.urlImage = urlImage;
  }

  public String getUrlToArticle() {
    return urlToArticle;
  }

  public void setUrlToArticle(String urlToArticle) {
    this.urlToArticle = urlToArticle;
  }
}
