package com.clean.juanjo.newsapp.domain.mapper;

import com.clean.juanjo.newsapp.data.local.ArticleDto;
import com.clean.juanjo.newsapp.domain.model.ArticleModel;
import javax.inject.Inject;

/**
 * Created by Juanjo Berenguer.
 * Email: surkhojb@gmail.com.
 * Date: 08/03/2018.
 */

public class ArticleDtoToArticleModelMapper implements Mapper<ArticleModel,ArticleDto> {

  @Inject
  public ArticleDtoToArticleModelMapper(){}

  @Override public ArticleModel map(ArticleDto dto) {
    ArticleModel model = new ArticleModel();
    model.setTitle(dto.getTitle());
    model.setDescription(dto.getDescription());
    model.setDateAndAuthor(dto.getDateAndAuthor());
    model.setSource(dto.getSource());
    model.setUrlImage(dto.getUrlImage());
    model.setUrlToArticle(dto.getUrlToArticle());

    return model;
  }

  @Override public ArticleDto inverseMap(ArticleModel model) {
    ArticleDto dto = new ArticleDto();
    dto.setTitle(model.getTitle());
    dto.setDescription(model.getDescription());
    dto.setDateAndAuthor(model.getDateAndAuthor());
    dto.setSource(model.getSource());
    dto.setUrlImage(dto.getUrlImage());
    dto.setUrlToArticle(dto.getUrlToArticle());

    return dto;
  }
}
