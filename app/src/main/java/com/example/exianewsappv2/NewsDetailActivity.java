package com.example.exianewsappv2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.view.menu.MenuItemImpl;
import android.view.MenuItem;
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

    private static final String KEY_INDEX ="news_index";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        int index = getIntent().getIntExtra(KEY_INDEX,-1);

        if (index != -1){
            updateNewsDetail(index);
        }else {
            Toast.makeText(this, "Sorry incorrect index passed away", Toast.LENGTH_SHORT).show();
        }


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

        newsDetailWebView.loadUrl(NewsStore.getNewsModels().get(index).getUrl());
        getSupportActionBar().setTitle(NewsStore.getNewsModels().get(index).getTitle());
    }

    public static void launch(Context context,int index){
        Intent intent = new Intent(context,NewsDetailActivity.class);
        intent.putExtra(KEY_INDEX,index);
        context.startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
