package com.dam.mynicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


/**
 * @author Carlos
 * MainActivity2
 *
 * Clase a la que llegamos una vez nos logeamos,
 * Configurada appBar con barra de retroceso
 * Tanto si se pulsa la flecha de la barra superior
 * como el botón de retroceso, volverá a la pantalla anterior
 *
 *  @see MainActivity2
 */
public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
}