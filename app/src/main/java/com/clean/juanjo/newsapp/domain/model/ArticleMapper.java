package com.clean.juanjo.newsapp.domain.model;

import com.clean.juanjo.newsapp.domain.Article;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Juanjo Berenguer.
 * Email: surkhojb@gmail.com.
 * Date: 06/03/2018.
 */

public class ArticleMapper implements Mapper<ArticleModel,Article> {

    @Inject
    public ArticleMapper(){}

    @Override
    public ArticleModel map(Article article) {
        ArticleModel model = new ArticleModel();
        model.setTitle(article.getTitle());
        model.setDescription(article.getDescription());
        String date = String.format("%s-%s",article.getPublishedAt().substring(0,10),article.getAuthor());
        model.setDateAndAuthor(date);
        model.setSource(article.getSource().getName());
        model.setUrlImage(article.getUrlToImage());
        model.setUrlToArticle(article.getUrl());

        return model;
    }

    @Override
    public Article inverseMap(ArticleModel articleModel) {
        return null;
    }

    public List<ArticleModel> transform(List<Article> articles){
        List<ArticleModel> models = new ArrayList<>();
        for(Article ar : articles){
            models.add(this.map(ar));
        }

        return models;
    }
}
