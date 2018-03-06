package com.clean.juanjo.newsapp.domain.model;

import java.io.Serializable;

/**
 * Created by Juanjo Berenguer.
 * Email: surkhojb@gmail.com.
 * Date: 06/03/2018.
 */

public class ArticleModel implements Serializable {
    private String title;
    private String description;
    private String dateAndAuthor;
    private String source;
    private String urlImage;
    private String urlToArticle;

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
