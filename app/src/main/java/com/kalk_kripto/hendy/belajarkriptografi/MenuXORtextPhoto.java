package com.kalk_kripto.hendy.belajarkriptografi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
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
import com.googlecode.tesseract.android.TessBaseAPI;
import com.theartofdev.edmodo.cropper.CropImage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MenuXORtextPhoto extends AppCompatActivity {
    public static final String TESS_DATA = "/tessdata";
    private static final String TAG = LayarUtama.class.getSimpleName();
    private EditText edittext;
    private Button button;
    private TessBaseAPI tessBaseAPI;
    private String mCurrentPhotoPath;
    private String input,key,output;
    private String penjelasan;
    private Uri photoURI;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layar_menu6);
        setTitle("Foto - XOR");
        AirBanner airBanner = new AirBanner(this);
        airBanner.setAdListener(new AirBannerListener() {
            @Override
            public void onAdLoaded(View view) {
                ((FrameLayout) findViewById(R.id.bannerm6)).removeAllViews();
                ((FrameLayout) findViewById(R.id.bannerm6)).addView(view);
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

    public void photo1(View view){
        edittext = findViewById(R.id.etp1);
        chkPerm();
        takePic();
    }

    public void photo2(View view){
        edittext = findViewById(R.id.etp2);
        chkPerm();
        takePic();
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
                Intent intent = new Intent(MenuXORtextPhoto.this, BantuanFiturAplikasi.class);
                intent.putExtra("key",6);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void bp1(View view) {
        button = findViewById(R.id.penjp);
        edittext= findViewById(R.id.etp2);
        key = edittext.getText().toString();
        if(!TextUtils.isEmpty(edittext.getText().toString())) {
            edittext = findViewById(R.id.etp1);
            if (!TextUtils.isEmpty(edittext.getText().toString())) {
                input = edittext.getText().toString();
                AlgoritmaXOR pro = new AlgoritmaXOR(input, key, true);
                output = pro.getResult();
                penjelasan = pro.getPenj();
                edittext = findViewById(R.id.etp3);
                edittext.setText(output, TextView.BufferType.EDITABLE);
                button.setVisibility(view.VISIBLE);
            } else {
                button.setVisibility(view.GONE);
                Toast.makeText(MenuXORtextPhoto.this, "HARAP FOTO/MASUKAN TEXT YANG INGIN DIENCRYPT!", Toast.LENGTH_SHORT).show();
            }
        } else {
            button.setVisibility(view.GONE);
            Toast.makeText(MenuXORtextPhoto.this, "HARAP MASUKAN KEY!", Toast.LENGTH_SHORT).show();
        }
    }

    public void bp2(View view) {
        button = findViewById(R.id.penjp);
        edittext= findViewById(R.id.etp2);
        key = edittext.getText().toString();
        if(!TextUtils.isEmpty(edittext.getText().toString())) {
            edittext = findViewById(R.id.etp1);
            if (!TextUtils.isEmpty(edittext.getText().toString())) {
                input = edittext.getText().toString();
                AlgoritmaXOR pro = new AlgoritmaXOR(input, key, false);
                output = pro.getResult();
                penjelasan = pro.getPenj();
                edittext = findViewById(R.id.etp3);
                edittext.setText(output, TextView.BufferType.EDITABLE);
                button.setVisibility(view.VISIBLE);
            } else {
                button.setVisibility(view.GONE);
                Toast.makeText(MenuXORtextPhoto.this, "HARAP FOTO/MASUKAN TEXT YANG INGIN DIDECRYPT!", Toast.LENGTH_SHORT).show();
            }
        } else {
            button.setVisibility(view.GONE);
            Toast.makeText(MenuXORtextPhoto.this, "HARAP FOTO/MASUKAN KEY!", Toast.LENGTH_SHORT).show();
        }
    }

    public void penjp(View view) {
        Intent kirimdt = new Intent(MenuXORtextPhoto.this,Penjelasan.class);
        kirimdt.putExtra("pJ",penjelasan);
        startActivity(kirimdt);
    }

    private void chkPerm() {
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 2);
        }
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 3);
        }
    }


    private void takePic() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                photoURI = FileProvider.getUriForFile(this,
                        BuildConfig.APPLICATION_ID + ".provider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, 1024);
            }
        }
    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1024) {
            if (resultCode == Activity.RESULT_OK) {
                CropImage.activity(photoURI).setMultiTouchEnabled(true).start(this);
                //should be here start ocr
            } else if (resultCode == Activity.RESULT_CANCELED) {
                File file = new File(mCurrentPhotoPath);
                file.delete();
            } else {
                File file = new File(mCurrentPhotoPath);
                file.delete();
            }
        }else if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE){
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK){
                photoURI = result.getUri();
                prepareTessData();
                startOCR(photoURI);
            } else {
                File file = new File(mCurrentPhotoPath);
                file.delete();
            }
        }
    }
    private void prepareTessData(){
        try{
            File dir = getExternalFilesDir(TESS_DATA);
            if(!dir.exists()){
                if (!dir.mkdir()) {
                    Toast.makeText(getApplicationContext(), "The folder " + dir.getPath() + "was not created", Toast.LENGTH_SHORT).show();
                }
            }
                String pathToDataFile = dir + "/ind.traineddata";
                if(!(new File(pathToDataFile)).exists()){
                    InputStream in = getAssets().open("ind.traineddata");
                    OutputStream out = new FileOutputStream(pathToDataFile);
                    byte [] buff = new byte[1024];
                    int len ;
                    while(( len = in.read(buff)) > 0){
                        out.write(buff,0,len);
                    }
                    in.close();
                    out.close();
                }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    private void startOCR(Uri imageUri){
        try{
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            options.inSampleSize = 6;
            Bitmap bitmap = BitmapFactory.decodeFile(imageUri.getPath(), options);
            String result = this.getText(bitmap);
            edittext.setText(result, TextView.BufferType.EDITABLE);
            File file = new File(mCurrentPhotoPath);
            file.delete();
            File dir = getExternalFilesDir(TESS_DATA);
            String pathToDataFile = dir + "/ind.traineddata";
            file = new File(pathToDataFile);
            file.delete();
        }catch (Exception e){
            Log.e(TAG, e.getMessage());
        }
    }

    private String getText(Bitmap bitmap){
        try{
            tessBaseAPI = new TessBaseAPI();
        }catch (Exception e){
            Log.e(TAG, e.getMessage());
        }
        String dataPath = getExternalFilesDir("/").getPath() + "/";
        tessBaseAPI.init(dataPath, "ind");
        tessBaseAPI.setImage(bitmap);
        String retStr = "No result";
        try{
            retStr = tessBaseAPI.getUTF8Text();
        }catch (Exception e){
            Log.e(TAG, e.getMessage());
        }
        tessBaseAPI.end();
        return retStr;
    }
}
