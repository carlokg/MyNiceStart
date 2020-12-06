package com.dam.mynicestart;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

/**
 * @author Carlos
 * MainActivity
 *
 * Clase que carga imagen de usuario utilizando Gilde
 *  Si se pulsa aceptar, llevará al MainActivity 2,
 *  Siguiente pantaya de la aplicación
 *  Si se pulsa el boton del teléfono volver,
 *  saldrá de la app, al no pasar por login o splash
 *
 *  @see MainActivity2
 */

public class MainActivity extends AppCompatActivity {
    ImageView imgLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgLogin = findViewById(R.id.imgLogin);

        Glide.with(this)
                .load(R.drawable.fotolog)
                .circleCrop()
                .into(imgLogin)
        ;
    }


    public void ok(View view) {
        Intent i = new Intent(this, MainActivity2.class);
        startActivity(i);
    }
}