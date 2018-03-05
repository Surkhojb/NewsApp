package com.clean.juanjo.newsapp.injection.component;

import com.clean.juanjo.newsapp.injection.PerActivity;
import com.clean.juanjo.newsapp.injection.module.MainActivityModule;
import com.clean.juanjo.newsapp.ui.main.MainActivity;

import dagger.Component;

/**
 * Created by Juanjo Berenguer.
 * Email: surkhojb@gmail.com.
 * Date: 01/03/2018.
 */

@PerActivity
@Component(dependencies = AppComponent.class,modules = MainActivityModule.class)
public interface MainActivityComponent {
    void inject(MainActivity activity);
}
