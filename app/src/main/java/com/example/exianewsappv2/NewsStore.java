package com.example.exianewsappv2;

import com.example.exianewsappv2.model.ArticlesItem;

import java.util.ArrayList;
import java.util.List;

public class NewsStore {
    private static List<ArticlesItem> newsModels = new ArrayList<>();


    public static List<ArticlesItem> getNewsModels() {
        return newsModels;
    }

    public static void setNewsModels(List<ArticlesItem> newsModels) {
        NewsStore.newsModels = newsModels;
    }

}
