package com.kalk_kripto.hendy.belajarkriptografi;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.air.sdk.addons.airx.AirBannerListener;
import com.air.sdk.addons.airx.AirFullscreenListener;
import com.air.sdk.injector.AirBanner;
import com.air.sdk.injector.AirFullscreen;

public class Pilihan extends AppCompatActivity {
    AirFullscreen airFullscreen;
    AirBanner airBanner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilihan);
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        TextView title = toolbar.findViewById(R.id.toolbar_title);
        title.setText("Beranda");
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 2);
        }
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 3);
        }
        airBanner = new AirBanner(this);
        airBanner.setAdListener(new AirBannerListener() {
            @Override
            public void onAdLoaded(View view) {
                ((FrameLayout) findViewById(R.id.banner)).removeAllViews();
                ((FrameLayout) findViewById(R.id.banner)).addView(view);
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
                /*
                * Invoked when there is no Fullscreen Ad
                available after calling load function.
                */
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
    }

    //on backpress = ketika tombol back di anroid di click
    @Override
    public void onBackPressed() {
        //alertdialog merupakan sebuah class yang dapat dipanggil untuk membuat sebuah kelas dengan cara menambahkan command .Builder
        //alertkeluar adalah object dari class alertdialog
        AlertDialog.Builder alertkeluar = new AlertDialog.Builder(this);
        alertkeluar.setIcon(R.mipmap.ic_launcher);
        alertkeluar.setTitle("Informasi Keluar");
        alertkeluar.setMessage("Apakah anda yakin Mau Keluar?");
        //pemanggilan new dialoginterface dapat dicari dengan tombol ctrl + spasi
        //segala pencarian syntax dapat pakai ctrl + spasi
        alertkeluar.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                System.exit(0);
                moveTaskToBack(true);
            }
        });
        alertkeluar.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        alertkeluar.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        airBanner.loadAd(AirBanner.BANNER);
        airFullscreen.loadAd();
        airFullscreen.showAd();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mengenai:
                airFullscreen.loadAd();
                airFullscreen.showAd();
                startActivity(new Intent(Pilihan.this, Mengenai.class));
                return true;
            case R.id.bantuan:
                airFullscreen.loadAd();
                airFullscreen.showAd();
                startActivity(new Intent(Pilihan.this, BantuanUtama.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void menu1(View view) {
        airFullscreen.loadAd();
        airFullscreen.showAd();
        startActivity(new Intent(Pilihan.this, MenuASCII.class));}
    public void menu2(View view) {
        airFullscreen.loadAd();
        airFullscreen.showAd();
        startActivity(new Intent(Pilihan.this, MenuBiner.class));}
    public void menu3(View view) {
        airFullscreen.loadAd();
        airFullscreen.showAd();
        startActivity(new Intent(Pilihan.this, MenuXORtext.class));}
    public void menu4(View view) {
        airFullscreen.loadAd();
        airFullscreen.showAd();
        startActivity(new Intent(Pilihan.this, MenuXORascii.class));}
    public void menu5(View view) {
        airFullscreen.loadAd();
        airFullscreen.showAd();
        startActivity(new Intent(Pilihan.this, MenuRSA.class));}
    public void menu6(View view) {
        airFullscreen.loadAd();
        airFullscreen.showAd();
        startActivity(new Intent(Pilihan.this, MenuXORtextPhoto.class));}
    public void menu7(View view) {
        airFullscreen.loadAd();
        airFullscreen.showAd();
        startActivity(new Intent(Pilihan.this, MenuCaesar.class));}
    public void menu8(View view) {
        airFullscreen.loadAd();
        airFullscreen.showAd();
        startActivity(new Intent(Pilihan.this, MenuVigenere.class));}
}