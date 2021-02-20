package com.dam.mynicestart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;


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

        BottomAppBar bottomAppBar = findViewById(R.id.bottom_app_bar);

        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity2.this, "FAB Clicked.", Toast.LENGTH_SHORT).show();
            }
        });

        bottomAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity2.this, "Menu clicked!", Toast.LENGTH_SHORT).show();
//                sheetBehavior = BottomSheetBehavior.from(sheet);
            }


        });



        bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.share:
                        Toast.makeText(MainActivity2.this, "share clicked.", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.bookmark:
                        Toast.makeText(MainActivity2.this, "bookmark clicked.", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.search:
                        Toast.makeText(MainActivity2.this, "Search clicked.", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });

    }
}