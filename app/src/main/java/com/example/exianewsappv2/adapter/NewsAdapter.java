package com.example.exianewsappv2.adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.exianewsappv2.helpers.FormatDateUtils;
import com.example.exianewsappv2.NewsDetailActivity;
import com.example.exianewsappv2.R;
import com.example.exianewsappv2.model.ArticlesItem;
import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private List<ArticlesItem> articlesItems;

    public NewsAdapter(List<ArticlesItem> articlesItems) {
        this.articlesItems = articlesItems;
    }
    @NonNull
    @Override
    public NewsAdapter.NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news,parent,false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.NewsViewHolder holder, final int position) {
        final ArticlesItem newsModel = articlesItems.get(position);
        holder.txtNewsTitle.setText(newsModel.getTitle());
        holder.txtNewsTime.setText(FormatDateUtils.formNewsApiDate(newsModel.getPublishedAt()));
        holder.txtNewsContent.setText(newsModel.getDescription());

        Glide.with(holder.imgNews.getContext())
                .load(newsModel.getUrlToImage())
                .centerCrop()
                .into(holder.imgNews);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAnalytics analytics = FirebaseAnalytics.getInstance(view.getContext());
                Bundle bundle = new Bundle();
                bundle.putString("index",String.valueOf(position));
                analytics.logEvent("newsClicked",bundle);
                NewsDetailActivity.launch(view.getContext(),position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articlesItems.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_news)
        ImageView imgNews;

        @BindView(R.id.txt_news_title)
        TextView txtNewsTitle;

        @BindView(R.id.txt_news_time)
        TextView txtNewsTime;

        @BindView(R.id.txt_news_content)
        TextView txtNewsContent;


        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
