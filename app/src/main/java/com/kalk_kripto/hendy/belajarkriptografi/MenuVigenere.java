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

public class MenuVigenere extends AppCompatActivity {
    EditText edittext;
    String input,output,key;
    String penjelasan;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layar_menu8);
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        TextView title = toolbar.findViewById(R.id.toolbar_title);
        Button backbut = toolbar.findViewById(R.id.back);
        title.setText("Vigenere Cipher");
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
                ((FrameLayout) findViewById(R.id.bannerm8)).removeAllViews();
                ((FrameLayout) findViewById(R.id.bannerm8)).addView(view);
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
                Intent intent = new Intent(MenuVigenere.this, BantuanFiturAplikasi.class);
                intent.putExtra("key",8);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public boolean nonAlphabetic(String mess) {
        mess=mess.toUpperCase();
        char[] chars = mess.toCharArray();
        for(char c : chars) {
            if(c > 90 || c < 65) {
                return true;
            }
        }
        return false;
    }

    public void vig1(View view) {
        button = (Button) findViewById(R.id.penjx);
        edittext = (EditText) findViewById(R.id.etvi3);
        key = edittext.getText().toString();
        if (!nonAlphabetic(key)) {
            if (!TextUtils.isEmpty(edittext.getText().toString())) {
                edittext = (EditText) findViewById(R.id.etvi1);
                if (!TextUtils.isEmpty(edittext.getText().toString())) {
                    input = edittext.getText().toString();
                    AlgVig pro = new AlgVig(input, key, true);
                    output = pro.getResult();
                    penjelasan = pro.getPenj();
                    edittext = (EditText) findViewById(R.id.etvi2);
                    edittext.setText(output, TextView.BufferType.EDITABLE);
                    button.setVisibility(view.VISIBLE);
                } else {
                    button.setVisibility(view.GONE);
                    Toast.makeText(MenuVigenere.this, "HARAP MASUKAN PLAIN TEXT YANG INGIN DI-ENCRYPT!", Toast.LENGTH_SHORT).show();
                }
            } else {
                button.setVisibility(view.GONE);
                Toast.makeText(MenuVigenere.this, "HARAP MASUKAN KEY!", Toast.LENGTH_SHORT).show();
            }
        } else {
            button.setVisibility(view.GONE);
            Toast.makeText(MenuVigenere.this, "HARAP MASUKAN SATU KATA DALAM HURUF ALFABET SAJA!", Toast.LENGTH_SHORT).show();
        }
    }

    public void vig2(View view) {
        button = (Button) findViewById(R.id.penjx);
        edittext=(EditText) findViewById(R.id.etvi3);
        key = edittext.getText().toString();
        if (!nonAlphabetic(key)) {
            if(!TextUtils.isEmpty(edittext.getText().toString())) {
                edittext = (EditText) findViewById(R.id.etvi2);
                if (!TextUtils.isEmpty(edittext.getText().toString())) {
                    input = edittext.getText().toString();
                    AlgVig pro = new AlgVig(input, key, false);
                    output = pro.getResult();
                    penjelasan = pro.getPenj();
                    edittext = (EditText) findViewById(R.id.etvi1);
                    edittext.setText(output, TextView.BufferType.EDITABLE);
                    button.setVisibility(view.VISIBLE);
                } else {
                    button.setVisibility(view.GONE);
                    Toast.makeText(MenuVigenere.this, "HARAP MASUKAN CIPHER TEXT YANG INGIN DI-DECRYPT!", Toast.LENGTH_SHORT).show();
                }
            } else {
                button.setVisibility(view.GONE);
                Toast.makeText(MenuVigenere.this, "HARAP MASUKAN KEY!", Toast.LENGTH_SHORT).show();
            }
        } else {
            button.setVisibility(view.GONE);
            Toast.makeText(MenuVigenere.this, "HARAP MASUKAN SATU KATA DALAM HURUF ALFABET SAJA!", Toast.LENGTH_SHORT).show();
        }
    }

    public void penjx(View view) {
        Intent kirimdt = new Intent(MenuVigenere.this,Penjelasan.class);
        kirimdt.putExtra("pJ",penjelasan);
        startActivity(kirimdt);
    }
}
