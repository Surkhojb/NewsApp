package com.clean.juanjo.newsapp.ui.main;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.clean.juanjo.newsapp.R;
import com.clean.juanjo.newsapp.domain.Article;
import com.clean.juanjo.newsapp.domain.model.ArticleModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Juanjo Berenguer.
 * Email: surkhojb@gmail.com.
 * Date: 05/03/2018.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    private List<ArticleModel> articles = new ArrayList<>();
    private NewsClickListener listener;

    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(NewsAdapter.ViewHolder holder, int position) {
        ArticleModel article = articles.get(position);
        holder.bind(article);
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public void refreshArticles(List<ArticleModel> list){
        if(!list.isEmpty()){
            articles.clear();
            articles = list;
            notifyDataSetChanged();
        }

    }

    public ArticleModel getArticle(int position){
        return articles.get(position);
    }

    public void setOnClickListener(NewsClickListener listener){
        this.listener = listener;
    }

    protected class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.cv_item)
        CardView itemCard;
        @BindView(R.id.iv_item_picture)
        ImageView itemPicture;
        @BindView(R.id.tv_item_title)
        TextView itemTitle;
        @BindView(R.id.tv_item_description)
        TextView itemDescription;
        @BindView(R.id.iv_item_booksmark)
        ImageView itemBooksmark;
        @BindView(R.id.iv_item_share)
        ImageView itemShare;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemCard.setOnClickListener(this);
            itemBooksmark.setOnClickListener(this);
            itemShare.setOnClickListener(this);
        }

        public void bind(ArticleModel article){
            itemTitle.setText(article.getTitle());
            itemDescription.setText(article.getDescription());
            Glide.with(itemPicture).load(article.getUrlImage()).into(itemPicture);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.iv_item_booksmark:
                    listener.onBooksMarkClick(v,getAdapterPosition());
                    break;
                case R.id.iv_item_share:
                    listener.onShareClick(v,getAdapterPosition());
                    break;
                default: listener.onNewClick(v,getAdapterPosition());
            }
        }
    }
}
