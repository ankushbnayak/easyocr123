package com.example.easyocr123;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ClickImage extends AppCompatActivity {

    public static int cameraID = 0;
    public static boolean isBlack = true;
    public static ImageView image;
    FirebaseAuth firebaseAuth;
    FirebaseUser user;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_image);
        image = (ImageView) findViewById(R.id.imgView);
    }


    Handler h =new Handler();

    public void onBackClick(View v){
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                isBlack = true;
                cameraID = 0;
                Intent i = new Intent(ClickImage.this,CameraView.class);
                startActivityForResult(i, 999);
                h.postDelayed(this,4000);

            }
        },4000);

    }
    public void onEndClick(View v)
    {
        isBlack=false;
        h.removeCallbacksAndMessages(null);
        Toast.makeText(this, "Detection stopped", Toast.LENGTH_SHORT).show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.commanmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.log_out_button) {
            new AlertDialog.Builder(this)
                    .setTitle("Sign out!")
                    .setMessage("Are you sure you want to sign out?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            firebaseAuth = FirebaseAuth.getInstance();
                            firebaseAuth.signOut();
                            Intent signout = new Intent(ClickImage.this,ChooseLogin.class);
                            startActivity(signout);
                            finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create().show();
        }
        return super.onOptionsItemSelected(item);
    }

}