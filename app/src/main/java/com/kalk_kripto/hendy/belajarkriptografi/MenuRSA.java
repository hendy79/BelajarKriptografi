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

public class MenuRSA extends AppCompatActivity {
    EditText edittext;
    String input;
    int p1,p2,N,pk;
    String penjelasan;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layar_menu5);
        setTitle("Enkripsi Asinkron - RSA");
        AirBanner airBanner = new AirBanner(this);
        airBanner.setAdListener(new AirBannerListener() {
            @Override
            public void onAdLoaded(View view) {
                ((FrameLayout) findViewById(R.id.bannerm5)).removeAllViews();
                ((FrameLayout) findViewById(R.id.bannerm5)).addView(view);
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
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.bantuan, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.bantuan1:
                Intent intent = new Intent(MenuRSA.this, BantuanFiturAplikasi.class);
                intent.putExtra("key",5);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void rsa1(View view){
        button = (Button) findViewById(R.id.penjrsa);
        try{
            edittext= (EditText) findViewById(R.id.etrsa1);
            if(!TextUtils.isEmpty(edittext.getText().toString())) {
            edittext= (EditText) findViewById(R.id.etrsap1);
            if(!TextUtils.isEmpty(edittext.getText().toString())) {
            this.p1= Integer.parseInt(edittext.getText().toString());
            edittext= (EditText) findViewById(R.id.etrsap2);
            if(!TextUtils.isEmpty(edittext.getText().toString())) {
            this.p2= Integer.parseInt(edittext.getText().toString());
            AlgoritmaRSA rsa1=new AlgoritmaRSA();
            if(!rsa1.CheckBesar(this.p1) || !rsa1.CheckBesar(this.p2)){
                Toast.makeText(MenuRSA.this, "MASUKAN HARUS LEBIH DARI 10 DAN KURANG DARI 100!", Toast.LENGTH_SHORT).show();
                return;
            }
            if(!rsa1.CheckPrima(this.p1) || !rsa1.CheckPrima(this.p2)){
                Toast.makeText(MenuRSA.this, "MASUKAN HARUS BILANGAN PRIMA!", Toast.LENGTH_SHORT).show();
                return;
            }
            edittext= (EditText) findViewById(R.id.etrsa1);
            this.input= edittext.getText().toString();
            AlgoritmaRSA rsa=new AlgoritmaRSA(this.input,this.p1,this.p2);
            edittext= (EditText) findViewById(R.id.etrsapk);
            edittext.setText(rsa.getD(), TextView.BufferType.EDITABLE);
            edittext= (EditText) findViewById(R.id.etrsan);
            edittext.setText(rsa.getN(), TextView.BufferType.EDITABLE);
            edittext= (EditText) findViewById(R.id.etrsa2);
            edittext.setText(rsa.getResult(), TextView.BufferType.EDITABLE);
            penjelasan=rsa.getPenj();
            button.setVisibility(view.VISIBLE);
            } else {
                button.setVisibility(view.GONE);
                Toast.makeText(MenuRSA.this, "HARAP MASUKAN BILANGAN PRIMA KEDUA!", Toast.LENGTH_SHORT).show();
            }
            } else {
                button.setVisibility(view.GONE);
                Toast.makeText(MenuRSA.this, "HARAP MASUKAN BILANGAN PRIMA PERTAMA!", Toast.LENGTH_SHORT).show();
            }
            } else {
                button.setVisibility(view.GONE);
                Toast.makeText(MenuRSA.this, "HARAP MASUKAN PLAIN TEXT YANG INGIN DI-DECRYPT!", Toast.LENGTH_SHORT).show();
            }
        }catch(NumberFormatException exc){
            button.setVisibility(view.GONE);
            Toast.makeText(MenuRSA.this, "FORMAT MASUKAN SALAH!", Toast.LENGTH_SHORT).show();
        }
    }
    public void rsa2(View view){
        button = (Button) findViewById(R.id.penjrsa);
        try{
            edittext= (EditText) findViewById(R.id.etrsa2);
            if(!TextUtils.isEmpty(edittext.getText().toString())) {
            edittext= (EditText) findViewById(R.id.etrsan);
            if(!TextUtils.isEmpty(edittext.getText().toString())) {
            this.N= Integer.parseInt(edittext.getText().toString());
            edittext= (EditText) findViewById(R.id.etrsapk);
            if(!TextUtils.isEmpty(edittext.getText().toString())) {
            this.pk= Integer.parseInt(edittext.getText().toString());
            AlgoritmaRSA rsa1=new AlgoritmaRSA();
            edittext= (EditText) findViewById(R.id.etrsa2);
            this.input= edittext.getText().toString();
            AlgoritmaRSA rsa=new AlgoritmaRSA(this.N,this.pk,this.input);
            edittext= (EditText) findViewById(R.id.etrsa1);
            edittext.setText(rsa.getResult(), TextView.BufferType.EDITABLE);
            penjelasan=rsa.getPenj();
            button.setVisibility(view.VISIBLE);
            } else {
                button.setVisibility(view.GONE);
                Toast.makeText(MenuRSA.this, "HARAP MASUKAN PRIVATE KEY!", Toast.LENGTH_SHORT).show();
            }
            } else {
                button.setVisibility(view.GONE);
                Toast.makeText(MenuRSA.this, "HARAP MASUKAN BILANGAN N!", Toast.LENGTH_SHORT).show();
            }
            } else {
                button.setVisibility(view.GONE);
                Toast.makeText(MenuRSA.this, "HARAP MASUKAN CIPHER TEXT YANG INGIN DI-DECRYPT!", Toast.LENGTH_SHORT).show();
            }
        }catch(NumberFormatException exc){
            button.setVisibility(view.GONE);
            Toast.makeText(MenuRSA.this, "FORMAT MASUKAN SALAH!", Toast.LENGTH_SHORT).show();
        }
    }
    public void penjrsa(View view){
        Intent kirimdt = new Intent(MenuRSA.this,Penjelasan.class);
        kirimdt.putExtra("pJ",penjelasan);
        startActivity(kirimdt);
    }
}
