package com.example.exianewsappv2;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsDetailActivity extends AppCompatActivity {

    @BindView(R.id.news_detail_webview)
    WebView newsDetailWebView;

    @BindView(R.id.progress_horizontal)
    ProgressBar progressHorizontal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        ButterKnife.bind(this);
    }

    public void updateNewsDetail(int index){
        newsDetailWebView.getSettings().setJavaScriptEnabled(true);
        newsDetailWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                progressHorizontal.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                progressHorizontal.setVisibility(View.GONE);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                progressHorizontal.setVisibility(View.GONE);
                Toast.makeText(NewsDetailActivity.this, "Error in loading webpage", Toast.LENGTH_SHORT).show();
            }
        });

        newsDetailWebView.loadUrl(NewsStore.getNewsModels().get(index).getUrlToArticle());
        getSupportActionBar().setTitle(NewsStore.getNewsModels().get(index).getTitle());
    }
}
