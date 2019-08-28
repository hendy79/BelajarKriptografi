package com.kalk_kripto.hendy.belajarkriptografi;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class BantuanUtama extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bantuan);
        setTitle("Bantuan Utama");
        ImageView imgview;
        imgview=(ImageView) findViewById(R.id.imgBP1);
        imgview.setImageResource(R.drawable.banp1);
    }
}
