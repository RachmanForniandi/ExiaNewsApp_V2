package com.example.exianewsappv2.networkUtils;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkConfig {

    public static HttpLoggingInterceptor logging = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    //private static final String API_KEY ="3aa66a534dbe4bdea05f7a067f7a5fec";

    public static OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(logging)
            .build();

    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build();

    public static NewsService service = retrofit.create(NewsService.class);
}
