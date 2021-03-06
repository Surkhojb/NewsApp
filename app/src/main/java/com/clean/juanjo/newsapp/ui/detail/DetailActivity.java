package com.clean.juanjo.newsapp.ui.detail;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.clean.juanjo.newsapp.R;
import com.clean.juanjo.newsapp.domain.model.ArticleModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.clean.juanjo.newsapp.ui.GlideApp;
import com.clean.juanjo.newsapp.ui.booksmark.BooksmarkActivity;

import javax.inject.Inject;

public class DetailActivity extends AppCompatActivity {
    public static String ARTICLE_EXTRA = "article";
    private ArticleModel article;

    @BindView(R.id.detail_image_header)
    ImageView imgArticle;
    @BindView(R.id.detail_author)
    TextView tvAuthor;
    @BindView(R.id.detail_title)
    TextView tvTitle;
    @BindView(R.id.detail_description)
    TextView tvDescription;
    @BindView(R.id.detail_link)
    Button btReadMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        article = (ArticleModel) getIntent().getExtras().get(ARTICLE_EXTRA);
        loadArticle(article);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_share: return true;
            case R.id.action_booksmark:
                startActivity(new Intent(this, BooksmarkActivity.class));
                return true;
            default: return super.onOptionsItemSelected(item);
        }
    }

    private void loadArticle(ArticleModel article) {
        GlideApp.with(imgArticle).load(article.getUrlImage())
            .placeholder(new ColorDrawable(getColor(R.color.colorPlaceHolder)))
            .error(new ColorDrawable(getColor(R.color.colorPlaceHolder))).into(imgArticle);
        tvAuthor.setText(article.getDateAndAuthor());
        tvTitle.setText(article.getTitle());
        tvDescription.setText(article.getDescription());
        btReadMore.setOnClickListener(view -> createCustomTab(article.getUrlToArticle()));
    }

    private void createCustomTab(String url){
        CustomTabsIntent.Builder intentBuilder = new CustomTabsIntent.Builder();
        intentBuilder.setToolbarColor(ContextCompat.getColor(this, R.color.colorPrimary));
        intentBuilder.setSecondaryToolbarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));

        CustomTabsIntent customTabsIntent = intentBuilder.build();
        customTabsIntent.launchUrl(this, Uri.parse(url));
    }
}
