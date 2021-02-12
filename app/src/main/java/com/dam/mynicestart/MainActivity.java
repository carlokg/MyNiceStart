package com.dam.mynicestart;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;

import com.alespero.expandablecardview.ExpandableCardView;
import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;

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
    private SwipeRefreshLayout swipeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgLogin = findViewById(R.id.imgLogin);
        registerForContextMenu(imgLogin);

        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.myswipe);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);

        ExpandableCardView card = findViewById(R.id.profile);
        card.setOnExpandedListener(new
                                           ExpandableCardView.OnExpandedListener() {
                                               @Override
                                               public void onExpandChanged(View v, boolean isExpanded) {
                                                   Toast.makeText(MainActivity.this, isExpanded ? "Expanded!" :
                                                           "Collapsed!", Toast.LENGTH_SHORT).show();
                                               }
                                           });


        Glide.with(this)
                .load(R.drawable.fotolog)
                .circleCrop()                                           //Para que sea redondo
                .into(imgLogin)
        ;

    }
    protected SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {

            //    opción TOAST
            //
            //          Toast toast0 = Toast.makeText(MainContextActivity.this, "going swipeREFRESH", Toast.LENGTH_LONG);
            //          toast0.show();


            //   opción SNACKBAR

//           SUSTITUIR POR CONSTRAINT EN SU CASO
            final ConstraintLayout mLayout = (ConstraintLayout) findViewById(R.id.activity_main_context);
            //final RelativeLayout mLayout = (RelativeLayout) findViewById(R.id.activity_main_context);

            Snackbar snackbar = Snackbar
                    .make(mLayout, "fancy a Snack while you refresh?", Snackbar.LENGTH_LONG)
                    .setAction("UNDO", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Snackbar snackbar1 = Snackbar.make(mLayout, "Action is restored!", Snackbar.LENGTH_SHORT);
                            snackbar1.show();
                        }
                    });

            snackbar.show();
            swipeLayout.setRefreshing(false);

        }
    };

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);

    }



    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.edit:
                Toast toast = Toast.makeText(this, "Editing Avatar", Toast.LENGTH_LONG);
                toast.show();
                break;
            case R.id.delete:
                Toast toast2 = Toast.makeText(this, "Deleting Avatar", Toast.LENGTH_LONG);
                toast2.show();
                break;

        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.search) {
            Toast toast = Toast.makeText(this,"going APPBAR SEARCH",Toast.LENGTH_LONG );
            toast.show();
        }
        if (id == R.id.action_settings2) {
            showAlertDialogButtonClicked(MainActivity.this);
        }
        return super.onOptionsItemSelected(item);
    }

    public void ok(View view) {
        Intent i = new Intent(this, MainActivity2.class);
        startActivity(i);
    }

    public void showAlertDialogButtonClicked(MainActivity view) {
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //el dialogo estandar tiene título/icono pero podemos sustituirlo
        //por un XML a medida
        // builder.setTitle("Achtung!");
        // builder.setMessage("Where do you go?");
        // builder.setIcon(R.drawable.ic_action_name_dark);
        // un XML a medida para el diálogo:

        builder.setView(getLayoutInflater().inflate(R.layout.alertdialog_view,
                null));

        // add the buttons
        builder.setPositiveButton(R.string.cerrar_dialogo, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // do something like...
                        dialog.dismiss();
                    }
                });
        builder.setNegativeButton(R.string.cerrar_dialogo, new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // do something like...
                        dialog.dismiss();
                    }
                });

        builder.setNeutralButton(R.string.cerrar_dialogo, new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // do something like...
                        dialog.dismiss();
                    }
                });
        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }


}