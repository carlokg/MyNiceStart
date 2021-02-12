package com.dam.mynicestart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

/**
 * @author Carlos
 * Clase para el login de la aplicación, en el que introducir credenciales,
 * si pulsa el boton "login", pasara al primer activity (activity_main)
 * Si se pulsa el link de registro, pasará al activity de registro
 * @see MainActivity
 * @see Registro
 *

 */
//a

public class LoginActivity extends AppCompatActivity {
    ImageView mForest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mForest= findViewById(R.id.imageView);

        Glide.with(this)
                .load(R.drawable.chica)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade(500))
                .into(mForest);

    }
    public void register(View view) {
        Intent i = new Intent(this, Registro.class);
        startActivity(i);
    }
    public void btnLogin(View view) {
        Intent i = new Intent(this, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
        startActivity(i);
    }
}