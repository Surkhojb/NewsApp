package com.clean.juanjo.newsapp.ui.main;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.clean.juanjo.newsapp.NewsApp;
import com.clean.juanjo.newsapp.R;
import com.clean.juanjo.newsapp.injection.component.DaggerMainActivityComponent;
import com.clean.juanjo.newsapp.injection.module.MainActivityModule;
import com.clean.juanjo.newsapp.ui.detail.DetailActivity;
import com.clean.juanjo.newsapp.ui.main.modelview.NewsViewModel;
import com.clean.juanjo.newsapp.ui.main.modelview.NewsViewModelFactory;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NewsClickListener{

    @BindView(R.id.rv_news)
    RecyclerView rvNews;
    NewsAdapter rvAdapter;

    @Inject
    NewsViewModelFactory newsFactory;
    NewsViewModel newsViewModel;

    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        injectDependencies();
        initRecyclerView();

        newsViewModel = ViewModelProviders.of(this,newsFactory).get(NewsViewModel.class);
        newsViewModel.news().observe(this, articles -> rvAdapter.refreshArticles(articles));
        newsViewModel.loadNews();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        final MenuItem searchItem = menu.findItem(R.id.action_search);

        searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override public boolean onQueryTextSubmit(String query) {
                newsViewModel.loadNewsBySearch(query);
                clearSearchView();
                return true;
            }

            @Override public boolean onQueryTextChange(String newText) {
                //textView.setText(newText);
                return true;
            }
        });

        return true;
    }

    private void clearSearchView() {
        searchView.clearFocus();
        searchView.onActionViewCollapsed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_refresh: newsViewModel.loadNews(); return true;
            default: return super.onOptionsItemSelected(item);
        }
    }

    private void initRecyclerView(){
        rvNews.setHasFixedSize(true);
        rvNews.setLayoutManager(new LinearLayoutManager(this));
        rvAdapter = new NewsAdapter();
        rvAdapter.setOnClickListener(this);
        rvNews.setAdapter(rvAdapter);
    }

    private void injectDependencies() {

        DaggerMainActivityComponent.builder()
                .appComponent(NewsApp.getComponent())
                .mainActivityModule(new MainActivityModule())
                .build()
                .inject(this);
    }



    @Override
    public void onNewClick(View v, int position) {
        Intent deailIntent = new Intent(this, DetailActivity.class);
        deailIntent.putExtra(DetailActivity.ARTICLE_EXTRA,rvAdapter.getArticle(position));
        startActivity(deailIntent);
    }

    @Override
    public void onBooksMarkClick(View v, int position) {
        newsViewModel.insertToBooksMark(rvAdapter.getArticle(position));
    }

    @Override
    public void onShareClick(View v, int position) {
       final String shareUrl = String.format("See this article: %s",rvAdapter.getArticle(position).getUrlToArticle());
       Intent shareIntent = new Intent();
       shareIntent.setAction(Intent.ACTION_SEND);
       shareIntent.putExtra(Intent.EXTRA_TEXT,shareUrl);
       shareIntent.setType("text/plain");
       startActivity(shareIntent);
    }
}
