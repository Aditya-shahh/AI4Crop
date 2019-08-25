package com.example.aditya.ai4kisaan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.loopj.android.http.RequestParams;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import com.loopj.android.http.*;

import org.json.JSONArray;

import cz.msebera.android.httpclient.Header;


public class Main2Activity extends AppCompatActivity {

    ImageView plantImageView;
    Button cancelButton;
    Button confirmButton;
    Uri imageUri;
    File newFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        plantImageView = findViewById(R.id.plantImageView);
        setImage();
//        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
//        actionBar.setHomeButtonEnabled(true);
//        actionBar.setDisplayHomeAsUpEnabled(true);
        cancelButton = findViewById(R.id.cancelButton);
        confirmButton = findViewById(R.id.confirmButton);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent i = new Intent(getApplicationContext(), ResultActivity.class);
//                startActivity(i);

//                MyRunnable myRunnable = new MyRunnable(10);
//                Thread t = new Thread(myRunnable);
//                t.start();
            }
        });
    }


    private  void  setImage(){
        Bundle ex = getIntent().getExtras();
        imageUri = ex.getParcelable("ImageUri");
        plantImageView.setImageURI(imageUri);
    }




}
