package com.example.easyocr123;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    int SPLASH_TIME= 1000;//this is in milliseconds
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


                Intent login = new Intent(MainActivity.this,ChooseLogin.class);
                startActivity(login);
                finish();

    }
}