package com.example.miniproject1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity {
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        mp = MediaPlayer.create(this,R.raw.om);
        mp.start();
        Thread thread = new Thread(){
            @Override
            public void run() {
                try{
                    sleep(3000);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    startActivity(new Intent(SplashActivity.this,LoginActivity.class));

                }
            }
        };
        thread.start();

    }

    @Override
    protected void onPause() {
        super.onPause();
        mp.release();
        finish();

    }
}
