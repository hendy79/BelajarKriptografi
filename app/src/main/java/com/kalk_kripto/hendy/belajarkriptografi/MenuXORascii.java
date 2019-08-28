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

public class MenuXORascii extends AppCompatActivity {
    EditText edittext;
    String input,key,output;
    String penjelasan;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layar_menu4);
        setTitle("Konverter XOR - ASCII");
        AirBanner airBanner = new AirBanner(this);
        airBanner.setAdListener(new AirBannerListener() {
            @Override
            public void onAdLoaded(View view) {
                ((FrameLayout) findViewById(R.id.bannerm4)).removeAllViews();
                ((FrameLayout) findViewById(R.id.bannerm4)).addView(view);
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
                Intent intent = new Intent(MenuXORascii.this, BantuanFiturAplikasi.class);
                intent.putExtra("key",4);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void xa1(View view){
        button = (Button) findViewById(R.id.penjxa);
        edittext=(EditText) findViewById(R.id.etxa3);
        key = edittext.getText().toString();
        if(!TextUtils.isEmpty(edittext.getText().toString())) {
            edittext = (EditText) findViewById(R.id.etxa1);
            if(!TextUtils.isEmpty(edittext.getText().toString())){
                input = edittext.getText().toString();
                AlgoritmaXORascii pro = new AlgoritmaXORascii(input, key, true);
                output = pro.getResult();
                penjelasan = pro.getPenj();
                edittext = (EditText) findViewById(R.id.etxa2);
                edittext.setText(output, TextView.BufferType.EDITABLE);
                if (!TextUtils.isEmpty(edittext.getText().toString())){
                    button.setVisibility(view.VISIBLE);
                } else {
                    button.setVisibility(view.GONE);
                    Toast.makeText(MenuXORascii.this,"FORMAT MASUKAN ANDA SALAH, HARAP MASUKAN DENGAN BENAR!", Toast.LENGTH_SHORT).show();
                }
            } else {
                button.setVisibility(view.GONE);
                Toast.makeText(MenuXORascii.this, "HARAP MASUKAN PLAIN TEXT (ASCII) YANG INGIN DI-ENCRYPT!", Toast.LENGTH_SHORT).show();
            }
        } else {
            button.setVisibility(view.GONE);
            Toast.makeText(MenuXORascii.this, "HARAP MASUKAN KEY DALAM BENTUK ASCII!", Toast.LENGTH_SHORT).show();
        }
    }

    public void xa2(View view){
        button = (Button) findViewById(R.id.penjxa);
        edittext=(EditText) findViewById(R.id.etxa3);
        key = edittext.getText().toString();
        if(!TextUtils.isEmpty(edittext.getText().toString())) {
            edittext = (EditText) findViewById(R.id.etxa2);
            if(!TextUtils.isEmpty(edittext.getText().toString())){
                input = edittext.getText().toString();
                AlgoritmaXORascii pro = new AlgoritmaXORascii(input, key, false);
                output = pro.getResult();
                penjelasan = pro.getPenj();
                edittext = (EditText) findViewById(R.id.etxa1);
                edittext.setText(output, TextView.BufferType.EDITABLE);
                if (!TextUtils.isEmpty(edittext.getText().toString())){
                    button.setVisibility(view.VISIBLE);
                } else {
                    button.setVisibility(view.GONE);
                    Toast.makeText(MenuXORascii.this,"FORMAT MASUKAN ANDA SALAH, HARAP MASUKAN DENGAN BENAR!", Toast.LENGTH_SHORT).show();
                }
            } else {
                button.setVisibility(view.GONE);
                Toast.makeText(MenuXORascii.this, "HARAP MASUKAN PLAIN TEXT (ASCII) YANG INGIN DI-ENCRYPT!", Toast.LENGTH_SHORT).show();
            }
        } else {
            button.setVisibility(view.GONE);
            Toast.makeText(MenuXORascii.this, "HARAP MASUKAN KEY DALAM BENTUK ASCII!", Toast.LENGTH_SHORT).show();
        }
    }

    public void penjxa(View view) {
        Intent kirimdt = new Intent(MenuXORascii.this,Penjelasan.class);
        kirimdt.putExtra("pJ",penjelasan);
        startActivity(kirimdt);
    }
}
