package com.clean.juanjo.newsapp.domain.mapper;

import com.clean.juanjo.newsapp.data.local.ArticleDto;
import com.clean.juanjo.newsapp.domain.Article;
import com.clean.juanjo.newsapp.domain.model.ArticleModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by Juanjo Berenguer.
 * Email: surkhojb@gmail.com.
 * Date: 08/03/2018.
 */

public class ArticleTransformer {

  @Inject
  public ArticleDtoToArticleModelMapper dtoMapper;
  @Inject
  public ArticleToArticleModelMapper modelMapper;

  @Inject
  public ArticleTransformer(){}

  public List<ArticleModel> transform(List<Article> articles){
    List<ArticleModel> models = new ArrayList<>();
    for(Article ar : articles){
      models.add(modelMapper.map(ar));
    }

    return models;
  }

  public List<ArticleModel> transformDto(List<ArticleDto> articles){
    List<ArticleModel> models = new ArrayList<>();
    for(ArticleDto ar : articles){
      models.add(dtoMapper.map(ar));
    }

    return models;
  }
}
