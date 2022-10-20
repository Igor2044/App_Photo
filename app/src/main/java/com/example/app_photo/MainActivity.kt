package com.example.app_photo

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.util.jar.Manifest


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Obrazek: ImageView =findViewById(R.id.imgPhoto)
        val BtnCamera: Button =findViewById(R.id.btnPhoto)

        BtnCamera.isEnabled=false
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA )!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA),111)
        }else{
            BtnCamera.isEnabled=true
        }
        BtnCamera.setOnClickListener(){
            var x = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(x,101)
        }
    }
}