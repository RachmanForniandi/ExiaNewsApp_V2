package com.example.exianewsappv2.helpers;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.exianewsappv2.R;

public class LoadingIndicator {
    Context context;
    TextView txtViewLoading;
    AlertDialog alertDialog;
    ImageView imgLoadingIndicator;

    public LoadingIndicator(Context context) {
        this.context = context;
    }

    public void showLoadingIndicator(){
        LayoutInflater inflater = LayoutInflater.from(context);
        View supportView = inflater.inflate(R.layout.loading_indicator, null);

        txtViewLoading = supportView.findViewById(R.id.txt_view_loading);
        imgLoadingIndicator = supportView.findViewById(R.id.img_loading_indicator);

        Glide.with(context)
                .load(R.drawable.dot_loading)
                .into(imgLoadingIndicator);

        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setView(supportView);
        alertDialog = builder.create();
        alertDialog.show();

        alertDialog.setCancelable(false);

    }

    public void dismissLoading(){
        alertDialog.dismiss();
    }
}
