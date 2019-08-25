package com.example.aditya.ai4kisaan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class MainActivity extends AppCompatActivity {
    private int RESULT_LOAD_IMG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View lay = (View) findViewById(R.id.rellay);
        lay.setBackgroundResource(R.drawable.back2);
    }


    public void AddPlantImage(View view) {
        getPhotoFromGallery();
    }

    private void getPhotoFromGallery(){
        Intent photoPicketIntent = new Intent(Intent.ACTION_PICK);
        photoPicketIntent.setType("image/*");
        startActivityForResult(photoPicketIntent, RESULT_LOAD_IMG);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            try{
                final Uri imageUri = data.getData();
                final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                File cachePath = new File(getApplicationContext().getCacheDir(), "images");
                cachePath.mkdirs(); // don't forget to make the directory
                FileOutputStream stream = new FileOutputStream(cachePath + "/image.jpg"); // overwrites this image every time
                selectedImage.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                stream.close();
                File imagePath = new File(this.getCacheDir(), "images");
                File newFile = new File(imagePath, "image.jpg");
                Uri contentUri = FileProvider.getUriForFile(this, "com.example.aditya.FileProvider", newFile);
                changeScreen(contentUri);
//                plantImage.setImageBitmap(selectedImage);
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private void changeScreen(Uri imageUri) {
        Intent i = new Intent(this, Main2Activity.class);
        i.putExtra("ImageUri", imageUri);
        startActivity(i);
//        finish();
    }

}
