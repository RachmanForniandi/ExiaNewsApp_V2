package com.example.exianewsappv2.networkUtils;

import com.example.exianewsappv2.model.ResponseArticles;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsService {



    @GET("top-headlines")
    Call<ResponseArticles>getArticles(@Query("apiKey")String apiKey,
                                      @Query("country")String id);
}
