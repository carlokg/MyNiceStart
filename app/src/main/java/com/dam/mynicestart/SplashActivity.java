package com.dam.mynicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author Carlos
 * Clase para el spalash de la aplicación, carga imagen y el fondo
 * de forma progresiva, dará paso a la pantalla de login
 * @see LoginActivity
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        openApp(true);

        ImageView mySubtitle = (ImageView) findViewById(R.id.imgElegance);
        Animation elegance = AnimationUtils.loadAnimation(this, R.anim.fadeln);
        mySubtitle.startAnimation(elegance);

        View myfondo = (View) findViewById(R.id.fondo);
        Animation fondo_splash = AnimationUtils.loadAnimation(this, R.anim.view_splash);
        myfondo.startAnimation(fondo_splash);

        openApp(true);
    }

    private void openApp(boolean locationPermission) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity
                        .this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 5000);
    }
}