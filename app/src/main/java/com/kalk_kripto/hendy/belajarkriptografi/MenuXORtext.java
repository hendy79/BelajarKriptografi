package com.kalk_kripto.hendy.belajarkriptografi;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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

public class MenuXORtext extends AppCompatActivity {
    EditText edittext;
    String input,key,output;
    String penjelasan;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layar_menu3);
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        TextView title = toolbar.findViewById(R.id.toolbar_title);
        Button backbut = toolbar.findViewById(R.id.back);
        title.setText("Konverter XOR");
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
                ((FrameLayout) findViewById(R.id.bannerm3)).removeAllViews();
                ((FrameLayout) findViewById(R.id.bannerm3)).addView(view);
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
                Intent intent = new Intent(MenuXORtext.this, BantuanFiturAplikasi.class);
                intent.putExtra("key",3);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void xor1(View view) {
        button = (Button) findViewById(R.id.penjx);
        edittext=(EditText) findViewById(R.id.etxor3);
        key = edittext.getText().toString();
        if(!TextUtils.isEmpty(edittext.getText().toString())) {
            edittext = (EditText) findViewById(R.id.etxor1);
            if (!TextUtils.isEmpty(edittext.getText().toString())) {
                input = edittext.getText().toString();
                AlgoritmaXOR pro = new AlgoritmaXOR(input, key, true);
                output = pro.getResult();
                penjelasan = pro.getPenj();
                edittext = (EditText) findViewById(R.id.etxor2);
                edittext.setText(output, TextView.BufferType.EDITABLE);
                button.setVisibility(view.VISIBLE);
            } else {
                button.setVisibility(view.GONE);
                Toast.makeText(MenuXORtext.this, "HARAP MASUKAN PLAIN TEXT YANG INGIN DI-ENCRYPT!", Toast.LENGTH_SHORT).show();
            }
        } else {
            button.setVisibility(view.GONE);
            Toast.makeText(MenuXORtext.this, "HARAP MASUKAN KEY!", Toast.LENGTH_SHORT).show();
        }
    }

    public void xor2(View view) {
        button = (Button) findViewById(R.id.penjx);
        edittext=(EditText) findViewById(R.id.etxor3);
        key = edittext.getText().toString();
        if(!TextUtils.isEmpty(edittext.getText().toString())) {
            edittext = (EditText) findViewById(R.id.etxor2);
            if (!TextUtils.isEmpty(edittext.getText().toString())) {
                input = edittext.getText().toString();
                AlgoritmaXOR pro = new AlgoritmaXOR(input, key, false);
                output = pro.getResult();
                penjelasan = pro.getPenj();
                edittext = (EditText) findViewById(R.id.etxor1);
                edittext.setText(output, TextView.BufferType.EDITABLE);
                button.setVisibility(view.VISIBLE);
            } else {
                button.setVisibility(view.GONE);
                Toast.makeText(MenuXORtext.this, "HARAP MASUKAN CIPHER TEXT YANG INGIN DI-DECRYPT!", Toast.LENGTH_SHORT).show();
            }
        } else {
            button.setVisibility(view.GONE);
            Toast.makeText(MenuXORtext.this, "HARAP MASUKAN KEY!", Toast.LENGTH_SHORT).show();
        }
    }

    public void penjx(View view) {
        Intent kirimdt = new Intent(MenuXORtext.this,Penjelasan.class);
        kirimdt.putExtra("pJ",penjelasan);
        startActivity(kirimdt);
    }
}
