package com.example.exianewsappv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.exianewsappv2.adapter.NewsAdapter;
import com.example.exianewsappv2.model.NewsModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.list_of_news)
    RecyclerView listOfNews;

    NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);



        List<NewsModel> newsModels = new ArrayList<>();
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



        NewsStore.setNewsModels(newsModels);

        newsAdapter = new NewsAdapter(NewsStore.getNewsModels());
        listOfNews.setLayoutManager(new LinearLayoutManager(this));
        listOfNews.setAdapter(newsAdapter);
    }
}
