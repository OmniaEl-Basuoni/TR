package com.example.omnia.taskrabit.Activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.omnia.taskrabit.Classes.Language.LanguageType;
import com.example.omnia.taskrabit.R;

import java.util.Locale;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        new CountDownTimer(3000, 1000) {

            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {

                LanguageType languageType=new LanguageType();
                languageType.languageType = "arabic";
                Configuration config = new Configuration();
                config.locale = new Locale("ar");
                getResources().updateConfiguration(config, getResources().getDisplayMetrics());


                Intent mainActivity = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(mainActivity);
                finish();
            }
        }.start();
    }
}
