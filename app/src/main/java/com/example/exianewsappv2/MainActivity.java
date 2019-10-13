package com.example.exianewsappv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.exianewsappv2.model.NewsModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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

        NewsStore.setNewsModels(newsModels);
    }
}
