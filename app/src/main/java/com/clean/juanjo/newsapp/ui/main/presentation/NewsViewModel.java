package com.clean.juanjo.newsapp.ui.main.presentation;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.clean.juanjo.newsapp.data.INewsRepository;
import com.clean.juanjo.newsapp.domain.mapper.ArticleToArticleModelMapper;
import com.clean.juanjo.newsapp.domain.mapper.ArticleTransformer;
import com.clean.juanjo.newsapp.domain.model.ArticleModel;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Juanjo Berenguer.
 * Email: surkhojb@gmail.com.
 * Date: 01/03/2018.
 */

public class NewsViewModel extends ViewModel {
    private CompositeDisposable compositeDisposable;
    private MutableLiveData<List<ArticleModel>> listOfNews = new MutableLiveData<>();
    private INewsRepository newsRepository;
    private ArticleTransformer articleTransformer;

    public NewsViewModel(INewsRepository repository,ArticleTransformer transformer) {
        this.newsRepository = repository;
        compositeDisposable = new CompositeDisposable();
        this.articleTransformer = transformer;
    }

    @Override
    protected void onCleared() {
        if(compositeDisposable!=null && !compositeDisposable.isDisposed())
            compositeDisposable.clear();
    }

    public LiveData<List<ArticleModel>> news(){
        return listOfNews;
    }

    public void loadNews(){
       compositeDisposable.add(newsRepository.getNews().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(news -> listOfNews.setValue(articleTransformer.transform(news.getArticles()))));
    }

    public void loadNewsBySearch(String query) {
        compositeDisposable.add(newsRepository.getNewsBySearch(query).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(news -> listOfNews.setValue(articleTransformer.transform(news.getArticles()))));
    }

    public void insertToBooksMark(ArticleModel article){
        compositeDisposable.add(newsRepository.addBooksMark(articleTransformer.dtoMapper.inverseMap(article))
            .subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe());
    }
}
