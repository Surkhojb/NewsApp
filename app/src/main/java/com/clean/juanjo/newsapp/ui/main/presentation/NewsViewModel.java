package com.clean.juanjo.newsapp.ui.main.presentation;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.clean.juanjo.newsapp.data.INewsRepository;
import com.clean.juanjo.newsapp.domain.News;

import org.reactivestreams.Subscription;

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
    private MutableLiveData<News> listOfNews = new MutableLiveData<>();
    private INewsRepository newsRepository;

    public NewsViewModel(INewsRepository repository) {
        this.newsRepository = repository;
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    protected void onCleared() {
        if(compositeDisposable!=null && !compositeDisposable.isDisposed())
            compositeDisposable.clear();
    }

    public LiveData<News> news(){
        return listOfNews;
    }

    public void loadNews(){
       compositeDisposable.add(newsRepository.getNews().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(news -> listOfNews.setValue(news)));
    }
}
