package com.kalk_kripto.hendy.belajarkriptografi;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.air.sdk.gdpr.ConsentBox;

public class LayarUtama extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Untuk melakukan delay atau penundaan ke activity yang lainya
        Handler delay = new Handler();
        delay.postDelayed(new Runnable() {
            @Override
            public void run() {
                //akses class yang lain atau pindah activity pakai intent
                startActivity(new Intent(LayarUtama.this,Pilihan.class));
                //KILL ACTIVITY
                finish();
            }
        },3000);
        ConsentBox consentBox = new ConsentBox(this);
        consentBox.show();
    }
}
