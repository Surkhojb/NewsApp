package com.clean.juanjo.newsapp.injection.module;

import com.clean.juanjo.newsapp.data.remote.NewsApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Juanjo Berenguer.
 * Email: surkhojb@gmail.com.
 * Date: 01/03/2018.
 */

@Module
public class RemoteDataSourceModule {
    private final static String BASE_URL = "https://newsapi.org/v2/";

    public RemoteDataSourceModule() {
    }

    @Provides
    @Singleton
    OkHttpClient providesClient(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder().addInterceptor(interceptor).build();
    }

    @Singleton
    @Provides
    Gson providesGson(){
        return new GsonBuilder().create();
    }

    @Provides
    @Singleton
    Retrofit providesRetrofit(OkHttpClient client,Gson gson){
        return new Retrofit.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .baseUrl(BASE_URL)
                .build();
    }

    @Provides
    @Singleton
    NewsApi proviesNewsApi(Retrofit retrofit){
        return retrofit.create(NewsApi.class);
    }
}
