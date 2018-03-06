package com.clean.juanjo.newsapp.domain.model;

import com.clean.juanjo.newsapp.domain.Article;

/**
 * Created by Juanjo Berenguer.
 * Email: surkhojb@gmail.com.
 * Date: 06/03/2018.
 */

public class ArticleMapper implements Mapper<ArticleModel,Article> {
    @Override
    public ArticleModel map(Article article) {
        ArticleModel model = new ArticleModel();
        model.setTitle(article.getTitle());
        model.setDescription(article.getDescription());
        model.setDateAndAuthor(article.getPublishedAt() + article.getAuthor());
        model.setSource(article.getSource().getName());
        model.setUrlImage(article.getUrlToImage());
        model.setUrlToArticle(article.getUrl());

        return model;
    }

    @Override
    public Article inverseMap(ArticleModel articleModel) {
        return null;
    }
}
