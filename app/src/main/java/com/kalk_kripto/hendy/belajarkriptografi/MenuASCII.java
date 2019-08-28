package com.kalk_kripto.hendy.belajarkriptografi;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
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

public class MenuASCII extends AppCompatActivity {
    EditText edittext;
    String input,output;
    String penjelasan;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layar_menu1);
        setTitle("Konverter ASCII");
        AirBanner airBanner = new AirBanner(this);
        airBanner.setAdListener(new AirBannerListener() {
            @Override
            public void onAdLoaded(View view) {
                ((FrameLayout) findViewById(R.id.bannerm1)).removeAllViews();
                ((FrameLayout) findViewById(R.id.bannerm1)).addView(view);
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
                Intent intent = new Intent(MenuASCII.this, BantuanFiturAplikasi.class);
                intent.putExtra("key",1);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void ascii1(View view) {
        button = (Button) findViewById(R.id.penj);
        edittext=(EditText) findViewById(R.id.et1);
        if(!TextUtils.isEmpty(edittext.getText().toString())) {
            input = edittext.getText().toString();
            AlgoritmaASCII pro = new AlgoritmaASCII(input, true);
            output = pro.getResult();
            penjelasan = pro.getPenj();
            edittext = (EditText) findViewById(R.id.et2);
            edittext.setText(output, TextView.BufferType.EDITABLE);
            button.setVisibility(view.VISIBLE);
        }else{
            button.setVisibility(view.GONE);
            Toast.makeText(MenuASCII.this, "HARAP MASUKAN KARAKTER YANG INGIN DIKONVERSI!", Toast.LENGTH_SHORT).show();
        }
    }

    public void penj(View view) {
        Intent kirimdt = new Intent(MenuASCII.this,Penjelasan.class);
        kirimdt.putExtra("pJ",penjelasan);
        startActivity(kirimdt);
    }

    public void ascii2(View view) {
        button = (Button) findViewById(R.id.penj);
        edittext=(EditText) findViewById(R.id.et2);
        if(!TextUtils.isEmpty(edittext.getText().toString())) {
            input = edittext.getText().toString();
            AlgoritmaASCII pro = new AlgoritmaASCII(input, false);
            output = pro.getResult();
            penjelasan = pro.getPenj();
            edittext = (EditText) findViewById(R.id.et1);
            edittext.setText(output, TextView.BufferType.EDITABLE);
            if (TextUtils.isEmpty(edittext.getText().toString())) {
                button.setVisibility(view.GONE);
                Toast.makeText(MenuASCII.this, "HARAP MASUKAN FORMAT INPUT DENGAN BENAR!", Toast.LENGTH_SHORT).show();
                return;
            }
            button.setVisibility(view.VISIBLE);
        }else{
            button.setVisibility(view.GONE);
            Toast.makeText(MenuASCII.this, "HARAP MASUKAN KODE ASCII YANG INGIN DIKONVERSI!", Toast.LENGTH_SHORT).show();
        }
    }
}
