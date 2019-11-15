package com.kalk_kripto.hendy.belajarkriptografi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.air.sdk.addons.airx.AirBannerListener;
import com.air.sdk.injector.AirBanner;

public class MenuCaesar extends AppCompatActivity {
    EditText edittext;
    String input,output;
    int key;
    String penjelasan;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layar_menu7);
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        TextView title = toolbar.findViewById(R.id.toolbar_title);
        Button backbut = toolbar.findViewById(R.id.back);
        title.setText("Caesar Cipher");
        backbut.setVisibility(View.VISIBLE);
        backbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        AirBanner airBanner = new AirBanner(this);
        airBanner.setAdListener(new AirBannerListener() {
            @Override
            public void onAdLoaded(View view) {
                ((FrameLayout) findViewById(R.id.bannerm7)).removeAllViews();
                ((FrameLayout) findViewById(R.id.bannerm7)).addView(view);
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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.bantuan, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.bantuan1:
                Intent intent = new Intent(MenuCaesar.this, BantuanFiturAplikasi.class);
                intent.putExtra("key",7);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void cae1(View view) {
        button = (Button) findViewById(R.id.penjx);
        edittext=(EditText) findViewById(R.id.etca3);
        String gtext = edittext.getText().toString();
        try {
            key=Integer.parseInt(gtext);
        if(!TextUtils.isEmpty(edittext.getText().toString())) {
            edittext = (EditText) findViewById(R.id.etca1);
            if (!TextUtils.isEmpty(edittext.getText().toString())) {
                input = edittext.getText().toString();
                AlgCaesar pro = new AlgCaesar(input, key, true);
                output = pro.getResult();
                penjelasan = pro.getPenj();
                edittext = (EditText) findViewById(R.id.etca2);
                edittext.setText(output, TextView.BufferType.EDITABLE);
                button.setVisibility(view.VISIBLE);
            } else {
                button.setVisibility(view.GONE);
                Toast.makeText(MenuCaesar.this, "HARAP MASUKAN PLAIN TEXT YANG INGIN DI-ENCRYPT!", Toast.LENGTH_SHORT).show();
            }
        } else {
            button.setVisibility(view.GONE);
            Toast.makeText(MenuCaesar.this, "HARAP MASUKAN KEY!", Toast.LENGTH_SHORT).show();
        }
        }catch (NumberFormatException e){
            button.setVisibility(view.GONE);
            Toast.makeText(MenuCaesar.this, "HARAP MASUKAN ANGKA SAJA DI KOLOM PERGESERAN!", Toast.LENGTH_SHORT).show();
        }
    }

    public void cae2(View view) {
        button = (Button) findViewById(R.id.penjx);
        edittext=(EditText) findViewById(R.id.etca3);
        String gtext = edittext.getText().toString();
        try {
            key=Integer.parseInt(gtext);
        if(!TextUtils.isEmpty(edittext.getText().toString())) {
            edittext = (EditText) findViewById(R.id.etca2);
            if (!TextUtils.isEmpty(edittext.getText().toString())) {
                input = edittext.getText().toString();
                AlgCaesar pro = new AlgCaesar(input, key, false);
                output = pro.getResult();
                penjelasan = pro.getPenj();
                edittext = (EditText) findViewById(R.id.etca1);
                edittext.setText(output, TextView.BufferType.EDITABLE);
                button.setVisibility(view.VISIBLE);
            } else {
                button.setVisibility(view.GONE);
                Toast.makeText(MenuCaesar.this, "HARAP MASUKAN CIPHER TEXT YANG INGIN DI-DECRYPT!", Toast.LENGTH_SHORT).show();
            }
        } else {
            button.setVisibility(view.GONE);
            Toast.makeText(MenuCaesar.this, "HARAP MASUKAN KEY!", Toast.LENGTH_SHORT).show();
        }
        }catch (NumberFormatException e){
            button.setVisibility(view.GONE);
            Toast.makeText(MenuCaesar.this, "HARAP MASUKAN ANGKA SAJA DI KOLOM PERGESERAN!", Toast.LENGTH_SHORT).show();
        }
    }

    public void penjx(View view) {
        Intent kirimdt = new Intent(MenuCaesar.this,Penjelasan.class);
        kirimdt.putExtra("pJ",penjelasan);
        startActivity(kirimdt);
    }
}
