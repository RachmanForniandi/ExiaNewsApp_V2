package com.example.exianewsappv2;

import com.example.exianewsappv2.model.NewsModel;

import java.util.ArrayList;
import java.util.List;

public class NewsStore {
    private static List<NewsModel> newsModels = new ArrayList<>();


    public static List<NewsModel> getNewsModels() {
        return newsModels;
    }

    public static void setNewsModels(List<NewsModel> newsModels) {
        NewsStore.newsModels = newsModels;
    }
    
}
