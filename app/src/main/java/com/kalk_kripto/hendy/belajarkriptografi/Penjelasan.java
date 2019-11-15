package com.kalk_kripto.hendy.belajarkriptografi;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.air.sdk.addons.airx.AirBannerListener;
import com.air.sdk.addons.airx.AirFullscreenListener;
import com.air.sdk.injector.AirBanner;
import com.air.sdk.injector.AirFullscreen;

public class Penjelasan extends AppCompatActivity {
    TextView tv1;
    AirFullscreen airFullscreen;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penjelasan);
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        TextView title = toolbar.findViewById(R.id.toolbar_title);
        Button backbut = toolbar.findViewById(R.id.back);
        title.setText("Penjelasan");
        backbut.setVisibility(View.VISIBLE);
        backbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        tv1=(TextView) findViewById(R.id.penjtv);
        Intent tangkapdt = getIntent();
        tv1.setText(tangkapdt.getStringExtra("pJ"));
        AirBanner airBanner = new AirBanner(this);
        airBanner.setAdListener(new AirBannerListener() {
            @Override
            public void onAdLoaded(View view) {
                ((FrameLayout) findViewById(R.id.banner1)).removeAllViews();
                ((FrameLayout) findViewById(R.id.banner1)).addView(view);
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
        airFullscreen = new AirFullscreen(this);
        airFullscreen.setAdListener(new AirFullscreenListener() {
            @Override
            public void onAdFailed(String s) {
            }
            @Override
            public void onAdLoaded() {
                /*
                * Invoked when Fullscreen Ad is ready to be
                shown after load function was called.
                */
            }
            @Override
            public void onAdShown() {
                /*
                 * Invoked when the Fullscreen Ad is shown
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
        airFullscreen.loadAd();
        airFullscreen.showAd();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        airFullscreen.loadAd();
        airFullscreen.showAd();
    }

}
