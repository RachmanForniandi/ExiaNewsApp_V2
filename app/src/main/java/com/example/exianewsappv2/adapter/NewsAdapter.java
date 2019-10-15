package com.example.exianewsappv2.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.exianewsappv2.R;
import com.example.exianewsappv2.model.NewsModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private List<NewsModel> newsModels;

    public NewsAdapter(List<NewsModel> newsModels) {
        this.newsModels = newsModels;
    }
    @NonNull
    @Override
    public NewsAdapter.NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news,parent,false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.NewsViewHolder holder, int position) {
        final NewsModel newsModel = newsModels.get(position);
        holder.txtNewsTitle.setText(newsModel.getTitle());
        holder.txtNewsTime.setText(newsModel.getTime());
        holder.txtNewsContent.setText(newsModel.getDetails());

        Glide.with(holder.imgNews.getContext())
                .load(newsModel.getImageUrl())
                .centerCrop()
                .into(holder.imgNews);
    }

    @Override
    public int getItemCount() {
        return newsModels.size();
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
