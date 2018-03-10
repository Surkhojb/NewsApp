package com.clean.juanjo.newsapp.injection.component;

import com.clean.juanjo.newsapp.injection.PerActivity;
import com.clean.juanjo.newsapp.injection.module.AppModule;
import com.clean.juanjo.newsapp.injection.module.BooksmarkActivityModule;
import com.clean.juanjo.newsapp.ui.booksmark.BooksmarkActivity;

import dagger.Component;

/**
 * Created by Juanjo Berenguer.
 * Email: surkhojb@gmail.com.
 * Date: 10/3/18.
 */

@PerActivity
@Component(dependencies = AppComponent.class, modules = BooksmarkActivityModule.class)
public interface BooksmarkActivityComponent {
    void inject(BooksmarkActivity activity);
}
