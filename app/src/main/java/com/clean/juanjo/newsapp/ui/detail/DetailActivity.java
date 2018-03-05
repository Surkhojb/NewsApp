package com.clean.juanjo.newsapp.ui.detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.clean.juanjo.newsapp.R;
import com.clean.juanjo.newsapp.domain.Article;

import butterknife.BindView;
import butterknife.ButterKnife;
//TODO: Update layout with icon and better look
public class DetailActivity extends AppCompatActivity {
    public static String ARTICLE_EXTRA = "article";
    private Article article;

    @BindView(R.id.detail_image_header)
    ImageView imgArticle;
    @BindView(R.id.detail_author)
    TextView tvAuthor;
    @BindView(R.id.detail_updated)
    TextView tvUpdated;
    @BindView(R.id.detail_title)
    TextView tvTitle;
    @BindView(R.id.detail_description)
    TextView tvDescription;
    @BindView(R.id.detail_source)
    TextView tvSource;
    @BindView(R.id.detail_link)
    TextView tvLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        article = (Article) getIntent().getExtras().get(ARTICLE_EXTRA);
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
            default: return super.onOptionsItemSelected(item);
        }
    }

    private void loadArticle(Article article) {
        Glide.with(imgArticle).load(article.getUrlToImage()).into(imgArticle);
        tvAuthor.setText(article.getAuthor());
        tvUpdated.setText(article.getPublishedAt());
        tvTitle.setText(article.getTitle());
        tvDescription.setText(article.getDescription());
        tvSource.setText(article.getSource().getName());
    }
}
