package com.jufan.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WelcomeActivity extends AppCompatActivity {

    private SharedPreferences sp;
    private boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        sp = getSharedPreferences("1", MODE_PRIVATE);
        flag = sp.getBoolean("flag", true);
        if(flag){
            new Thread(){
                @Override
                public void run() {
                    SystemClock.sleep(3000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent=new Intent(WelcomeActivity.this,GuiDeActivity.class);
                            startActivity(intent);
                        }
                    });
                }
            }.start();
        }else{
            new Thread(){
                @Override
                public void run() {
                    SystemClock.sleep(3000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent=new Intent(WelcomeActivity.this,GuiDeActivity.class);
                            startActivity(intent);
                        }
                    });
                }
            }.start();
        }

    }
}
