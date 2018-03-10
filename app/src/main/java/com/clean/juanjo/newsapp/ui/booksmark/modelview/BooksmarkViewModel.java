package com.clean.juanjo.newsapp.ui.booksmark.modelview;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.clean.juanjo.newsapp.data.NewsRepository;
import com.clean.juanjo.newsapp.domain.Article;
import com.clean.juanjo.newsapp.domain.mapper.ArticleTransformer;
import com.clean.juanjo.newsapp.domain.model.ArticleModel;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Juanjo Berenguer.
 * Email: surkhojb@gmail.com.
 * Date: 10/3/18.
 */

public class BooksmarkViewModel extends ViewModel {
    private MutableLiveData<List<ArticleModel>> listOfBooksMark = new MutableLiveData<>();
    private NewsRepository newsRepository;
    private ArticleTransformer articleTransformer;

    public BooksmarkViewModel(NewsRepository repository, ArticleTransformer transformer) {
        this.newsRepository = repository;
        this.articleTransformer = transformer;
    }

    public LiveData<List<ArticleModel>> booksmark(){
        return listOfBooksMark;
    }

    public void loadBooksmark(){
        listOfBooksMark.postValue(articleTransformer.transformDto(newsRepository.getBooksMark().getValue()));
    }
}
