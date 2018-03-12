package com.clean.juanjo.newsapp.ui.booksmark.modelview;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.clean.juanjo.newsapp.data.INewsRepository;
import com.clean.juanjo.newsapp.data.NewsRepository;
import com.clean.juanjo.newsapp.domain.Article;
import com.clean.juanjo.newsapp.domain.mapper.ArticleTransformer;
import com.clean.juanjo.newsapp.domain.model.ArticleModel;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Juanjo Berenguer.
 * Email: surkhojb@gmail.com.
 * Date: 10/3/18.
 */

public class BooksmarkViewModel extends ViewModel {
    private MutableLiveData<List<ArticleModel>> listOfBooksMark = new MutableLiveData<>();
    private INewsRepository newsRepository;
    private ArticleTransformer articleTransformer;
    private CompositeDisposable compositeDisposable;

    public BooksmarkViewModel(INewsRepository repository, ArticleTransformer transformer) {
        this.newsRepository = repository;
        this.articleTransformer = transformer;
        compositeDisposable = new CompositeDisposable();
    }

    @Override protected void onCleared() {
        if(compositeDisposable != null && !compositeDisposable.isDisposed())
            compositeDisposable.clear();
    }

    public LiveData<List<ArticleModel>> booksmark(){
        return listOfBooksMark;
    }

    public void loadBooksmark(){
        compositeDisposable.add(newsRepository.getBooksMark().subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(articleDtos -> listOfBooksMark.setValue(articleTransformer.transformDto(articleDtos))));
    }
}
