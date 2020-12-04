package com.dam.mynicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

/**
 * Clase para introducir los datos de registro,
 * Se solicitara en EditText nombre, correo, contraseña y
 * confirmación de contraseña. Y cargara mediante un Inten
 * la siguiente ventana al logearse (MainActivity)
 *
 * @see MainActivity
 */


public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
    }
}