package com.clean.juanjo.newsapp.ui.main.presentation;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.clean.juanjo.newsapp.data.INewsRepository;
import com.clean.juanjo.newsapp.domain.Article;
import com.clean.juanjo.newsapp.domain.News;
import com.clean.juanjo.newsapp.domain.model.ArticleMapper;
import com.clean.juanjo.newsapp.domain.model.ArticleModel;

import org.reactivestreams.Subscription;

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
    private ArticleMapper articleMapper;

    public NewsViewModel(INewsRepository repository,ArticleMapper mapper) {
        this.newsRepository = repository;
        compositeDisposable = new CompositeDisposable();
        this.articleMapper = mapper;
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
                .subscribe(news -> listOfNews.setValue(articleMapper.transform(news.getArticles()))));
    }
}
