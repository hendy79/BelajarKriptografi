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

public class MenuBiner extends AppCompatActivity {
    EditText edittext;
    String input,output;
    String penjelasan;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layar_menu2);
        setTitle("Konverter Biner");
        AirBanner airBanner = new AirBanner(this);
        airBanner.setAdListener(new AirBannerListener() {
            @Override
            public void onAdLoaded(View view) {
                ((FrameLayout) findViewById(R.id.bannerm2)).removeAllViews();
                ((FrameLayout) findViewById(R.id.bannerm2)).addView(view);
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
                Intent intent = new Intent(MenuBiner.this, BantuanFiturAplikasi.class);
                intent.putExtra("key",2);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void biner1(View view) {
        button = (Button) findViewById(R.id.penjb);
        edittext=(EditText) findViewById(R.id.etb1);
        if(!TextUtils.isEmpty(edittext.getText().toString())) {
            input = edittext.getText().toString();
            AlgoritmaBiner pro = new AlgoritmaBiner(input, true);
            output = pro.getResult();
            penjelasan = pro.getPenj();
            edittext = (EditText) findViewById(R.id.etb2);
            edittext.setText(output, TextView.BufferType.EDITABLE);
            if (TextUtils.isEmpty(edittext.getText().toString())) {
                button.setVisibility(view.GONE);
                Toast.makeText(MenuBiner.this, "HARAP MASUKAN FORMAT INPUT DENGAN BENAR!", Toast.LENGTH_SHORT).show();
                return;
            }
            button.setVisibility(view.VISIBLE);
        }else{
            button.setVisibility(view.GONE);
            Toast.makeText(MenuBiner.this, "HARAP MASUKAN ANGKA DESIMAL!", Toast.LENGTH_SHORT).show();
        }
    }
    public void penjb(View view) {
        Intent kirimdt = new Intent(MenuBiner.this,Penjelasan.class);
        kirimdt.putExtra("pJ",penjelasan);
        startActivity(kirimdt);
    }
    public void biner2(View view) {
        button = (Button) findViewById(R.id.penjb);
        edittext=(EditText) findViewById(R.id.etb2);
        if(!TextUtils.isEmpty(edittext.getText().toString())) {
            input = edittext.getText().toString();
            AlgoritmaBiner pro = new AlgoritmaBiner(input, false);
            output = pro.getResult();
            penjelasan = pro.getPenj();
            edittext = (EditText) findViewById(R.id.etb1);
            edittext.setText(output, TextView.BufferType.EDITABLE);
            if (TextUtils.isEmpty(edittext.getText().toString())) {
                button.setVisibility(view.GONE);
                Toast.makeText(MenuBiner.this, "HARAP MASUKAN FORMAT INPUT DENGAN BENAR!", Toast.LENGTH_SHORT).show();
                return;
            }
            button = (Button) findViewById(R.id.penjb);
            button.setVisibility(view.VISIBLE);
        }else{
            button.setVisibility(view.GONE);
            Toast.makeText(MenuBiner.this, "HARAP MASUKAN BILANGAN BINER!", Toast.LENGTH_SHORT).show();
        }
    }
}
