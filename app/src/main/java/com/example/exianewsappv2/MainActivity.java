package com.example.exianewsappv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Toast;

import com.example.exianewsappv2.adapter.NewsAdapter;
import com.example.exianewsappv2.helpers.LoadingIndicator;
import com.example.exianewsappv2.model.ArticlesItem;
import com.example.exianewsappv2.model.ResponseArticles;
import com.example.exianewsappv2.networkUtils.NetworkConfig;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.list_of_news)
    RecyclerView listOfNews;

    @BindView(R.id.activity_main_layout)
    CoordinatorLayout mainLayout;

    NewsAdapter newsAdapter;
    List<ArticlesItem> articles;
    LoadingIndicator loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        articles = new ArrayList<>();
        loading = new LoadingIndicator(this);
        listOfNews.setLayoutManager(new LinearLayoutManager(this));

        /*List<NewsModel> newsModels = new ArrayList<>();
        newsModels.add(new NewsModel("Sven-Goran Eriksson Pernah Diancam Mau Dibunuh Alex Ferguson",
                "Jakarta - Sven-Goran Eriksson mengungkapkan bahwa dirinya sempat ingin dibunuh oleh Sir Alex Ferguson. Apa permasalahannya?",
                "https://akcdn.detik.net.id/community/media/visual/2017/06/15/9d46ff4f-e846-4d77-a340-28f3688eee76_169.jpg?w=700&q=80",
                "Minggu, 13 Okt 2019 21:06 WIB",
                "https://sport.detik.com/sepakbola/bola-dunia/d-4744572/sven-goran-eriksson-pernah-diancam-mau-dibunuh-alex-ferguson"));

        newsModels.add(new NewsModel("Timnas Indonesia Tak Boleh Andalkan Keberuntungan Lawan Vietnam",
                "Denpasar - Timnas Indonesia berjumpa Vietnam di Kualifikasi Piala Dunia 2022 Zona Asia. Skuat Garuda tak boleh berharap pada keberuntungan meski punya catatan oke.",
                "https://akcdn.detik.net.id/community/media/visual/2016/12/04/f0b5ae5b-2b63-41b3-acb8-d340c5c204b6_169.jpg?w=700&q=80",
                "Minggu, 13 Okt 2019 23:22 WIB",
                "https://sport.detik.com/sepakbola/liga-indonesia/d-4744624/timnas-indonesia-tak-boleh-andalkan-keberuntungan-lawan-vietnam"));

        newsModels.add(new NewsModel("Indonesia Vs Vietnam: Skuat Garuda Dihantam 1-3",
                "Gianyar - Indonesia kembali menelan kekalahan di Kualifikasi Piala Dunia 2022. Menjamu Vietnam, Indonesia dipaksa menyerah dengan skor akhir 1-3.",
                "https://akcdn.detik.net.id/community/media/visual/2019/10/15/e853c0dd-6897-4db0-b35b-519565a86f44_169.jpeg?w=700&q=80",
                "Selasa, 15 Okt 2019 20:24 WIB",
                "https://sport.detik.com/sepakbola/liga-indonesia/d-4747224/indonesia-vs-vietnam-skuat-garuda-dihantam-1-3"));


        newsModels.add(new NewsModel("Indonesia Digasak Vietnam, Irfan Bachdim: Pemain Harus Bercermin",
                "Jakarta - Irfan Bachdim menyebut kekalahan Indonesia atas Vietnam terjadi karena pemain kurang konsentrasi. Skuat Garuda disebutnya harus introspeksi.",
                "https://akcdn.detik.net.id/community/media/visual/2019/10/15/45b0ea64-2e28-43b5-a88c-49e962420888_169.jpeg?w=700&q=80",
                "Selasa, 15 Okt 2019 21:46 WIB",
                "https://sport.detik.com/sepakbola/liga-indonesia/d-4747304/indonesia-digasak-vietnam-irfan-bachdim-pemain-harus-bercermin"));

        newsModels.add(new NewsModel("Dicari! Kapten untuk Timnas Indonesia",
                "Gianyar - Timnas Indonesia kalah lagi di Kualifikasi Piala Dunia 2022, kali ini dari Vietnam dengan skor 1-3. Masalah kepemimpinan disorot, siapa mampu jadi kapten?",
                "https://akcdn.detik.net.id/community/media/visual/2019/10/15/eb68893e-d137-4c98-9fb1-82374ec44950_169.jpeg?w=700&q=80",
                "Selasa, 15 Okt 2019 22:07 WIB",
                "https://sport.detik.com/sepakbola/liga-indonesia/d-4747321/dicari-kapten-untuk-timnas-indonesia"));



        NewsStore.setNewsModels(newsModels);*/

        /*newsAdapter = new NewsAdapter(NewsStore.getNewsModels());
        listOfNews.setLayoutManager(new LinearLayoutManager(this));
        listOfNews.setAdapter(newsAdapter);*/

        loadDataArticles();

    }

    private void loadDataArticles() {
        loading.showLoadingIndicator();
        Call<ResponseArticles>call = NetworkConfig.service.getArticles("3aa66a534dbe4bdea05f7a067f7a5fec","id");
        call.enqueue(new Callback<ResponseArticles>() {
            @Override
            public void onResponse(Call<ResponseArticles> call, Response<ResponseArticles> response) {
                loading.dismissLoading();
                showNewsApiSnack();
                if (response.isSuccessful()){
                    ResponseArticles responseArticles = response.body();
                    NewsStore.setNewsModels(responseArticles.getArticles());

                    newsAdapter = new NewsAdapter(responseArticles.getArticles());
                    listOfNews.setAdapter(newsAdapter);
                }else {
                    Toast.makeText(MainActivity.this, "Sorry,something wrong with connection", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseArticles> call, Throwable t) {
                loading.dismissLoading();
                t.getMessage();
            }
        });
    }

    private void showNewsApiSnack(){
        Snackbar.make(mainLayout,"Powered by Newsapi.org",Snackbar.LENGTH_LONG)
                .setAction("Visit", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        loadToTheSourceApi();
                    }
                }).show();
    }

    private void loadToTheSourceApi(){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://newsapi.org")));
    }
}
