package com.kalk_kripto.hendy.belajarkriptografi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.air.sdk.addons.airx.AirBannerListener;
import com.air.sdk.injector.AirBanner;

public class BantuanFiturAplikasi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bantuan1);
        setTitle("Bantuan Fitur Aplikasi");
        AirBanner airBanner = new AirBanner(this);
        airBanner.setAdListener(new AirBannerListener() {
            @Override
            public void onAdLoaded(View view) {
                ((FrameLayout) findViewById(R.id.banner2)).removeAllViews();
                ((FrameLayout) findViewById(R.id.banner2)).addView(view);
            }
            @Override
            public void onAdFailed(String s) {
                /*
                * Invoked when there is no Fullscreen Ad
                available after calling load function.
                */
            }
            @Override
            public void onAdClosed() {
                /*
                * Invoked when the ad is closed and the user
                is about to return to the application.
                */
            }
            @Override
            public void onAdClicked() {
                /*
                * Invoked when the end user clicked on the
                Fullscreen ad.
                */
            }
            @Override
            public void onLeaveApplication() {
                /*
                * Invoked when the user is about to leave
                the application.
                */
            }
        });
        airBanner.loadAd(AirBanner.BANNER);
        Intent intent = getIntent();
        TextView tv;
        ImageView img;
        switch (intent.getExtras().getInt("key")){
            case 1:
                tv = findViewById(R.id.b1tv1);
                tv.setText(R.string.bmenu11);
                img = findViewById(R.id.b1im1);
                img.setImageResource(R.drawable.menu11);
                tv = findViewById(R.id.b1tv2);
                tv.setText(R.string.bmenu12);
                img = findViewById(R.id.b1im2);
                img.setImageResource(R.drawable.menu12);
                tv = findViewById(R.id.b1tv3);
                tv.setText(R.string.bmenu13);
                img = findViewById(R.id.b1im3);
                img.setImageResource(R.drawable.menu13);
                tv = findViewById(R.id.b1tv4);
                tv.setText(R.string.bmenu14);
                img = findViewById(R.id.b1im4);
                img.setImageResource(R.drawable.menu14);
                break;
            case 2:
                tv = findViewById(R.id.b1tv1);
                tv.setText(R.string.bmenu21);
                tv = findViewById(R.id.b1tv2);
                tv.setText(R.string.bmenu22);
                tv = findViewById(R.id.b1tv3);
                tv.setText(R.string.bmenu23);
                tv = findViewById(R.id.b1tv4);
                tv.setText(R.string.bmenu24);
                img = findViewById(R.id.b1im1);
                img.setImageResource(R.drawable.menu21);
                img = findViewById(R.id.b1im2);
                img.setImageResource(R.drawable.menu22);
                img = findViewById(R.id.b1im3);
                img.setImageResource(R.drawable.menu23);
                img = findViewById(R.id.b1im4);
                img.setImageResource(R.drawable.menu24);
                break;
            case 3:
                tv = findViewById(R.id.b1tv1);
                tv.setText(R.string.bmenu31);
                tv = findViewById(R.id.b1tv2);
                tv.setText(R.string.bmenu32);
                tv = findViewById(R.id.b1tv3);
                tv.setText(R.string.bmenu33);
                tv = findViewById(R.id.b1tv4);
                tv.setText(R.string.bmenu34);
                img = findViewById(R.id.b1im1);
                img.setImageResource(R.drawable.menu31);
                img = findViewById(R.id.b1im2);
                img.setImageResource(R.drawable.menu32);
                img = findViewById(R.id.b1im3);
                img.setImageResource(R.drawable.menu33);
                img = findViewById(R.id.b1im4);
                img.setImageResource(R.drawable.menu34);
                break;
            case 4:
                tv = findViewById(R.id.b1tv1);
                tv.setText(R.string.bmenu41);
                tv = findViewById(R.id.b1tv2);
                tv.setText(R.string.bmenu42);
                tv = findViewById(R.id.b1tv3);
                tv.setText(R.string.bmenu43);
                tv = findViewById(R.id.b1tv4);
                tv.setText(R.string.bmenu44);
                img = findViewById(R.id.b1im1);
                img.setImageResource(R.drawable.menu41);
                img = findViewById(R.id.b1im2);
                img.setImageResource(R.drawable.menu42);
                img = findViewById(R.id.b1im3);
                img.setImageResource(R.drawable.menu43);
                img = findViewById(R.id.b1im4);
                img.setImageResource(R.drawable.menu44);
                break;
            case 5:
                tv = findViewById(R.id.b1tv1);
                tv.setText(R.string.bmenu51);
                tv = findViewById(R.id.b1tv2);
                tv.setText(R.string.bmenu52);
                tv = findViewById(R.id.b1tv3);
                tv.setText(R.string.bmenu53);
                tv = findViewById(R.id.b1tv4);
                tv.setText(R.string.bmenu54);
                img = findViewById(R.id.b1im1);
                img.setImageResource(R.drawable.menu51);
                img = findViewById(R.id.b1im2);
                img.setImageResource(R.drawable.menu52);
                img = findViewById(R.id.b1im3);
                img.setImageResource(R.drawable.menu53);
                img = findViewById(R.id.b1im4);
                img.setImageResource(R.drawable.menu54);
                break;
            case 6:
                tv = findViewById(R.id.b1tv1);
                tv.setText(R.string.bmenu61);
                tv = findViewById(R.id.b1tv2);
                tv.setText(R.string.bmenu62);
                tv = findViewById(R.id.b1tv3);
                tv.setText(R.string.bmenu63);
                tv = findViewById(R.id.b1tv4);
                tv.setText(R.string.bmenu64);
                tv = findViewById(R.id.b1tv5);
                tv.setVisibility(View.VISIBLE);
                tv.setText(R.string.bmenu65);
                img = findViewById(R.id.b1im1);
                img.setImageResource(R.drawable.menu61);
                img = findViewById(R.id.b1im2);
                img.setImageResource(R.drawable.menu62);
                img = findViewById(R.id.b1im3);
                img.setImageResource(R.drawable.menu63);
                img = findViewById(R.id.b1im4);
                img.setImageResource(R.drawable.menu64);
                Button bt = findViewById(R.id.b1bt);
                bt.setVisibility(View.VISIBLE);
                break;
            default:
                Toast.makeText(this,"Halaman Kosong!",Toast.LENGTH_SHORT).show();
        }
    }

    public void b1bt(View view){
        Intent intent = new Intent(BantuanFiturAplikasi.this,BantuanFiturAplikasi.class);
        intent.putExtra("key",3);
        startActivity(intent);
    }
}
