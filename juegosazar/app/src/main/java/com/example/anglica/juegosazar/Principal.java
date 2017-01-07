package com.example.anglica.juegosazar;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Principal extends AppCompatActivity {

    private TextView instruTX;
    private TextView imagenTX;
    private TextView tituloTX;
    private Button inicioBT;
    private Button  reiniciarBT;
    private Instruciones reglas;
    private LinearLayout inicio;
    private LinearLayout fin;
    private LinearLayout imagen;
    private ImageView imagenIV;
    private ImageView imagenIV2;
    private Spinner listJU;
    private List<String> juegos = new ArrayList<String>();
    private int tipoJuego=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  Snackbar.make(view, "Aquí ver que se mueva el dado", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                tirar();
            }
        });

        reglas = new Instruciones();

        juegos = new Instruciones().getJuegos();
        ArrayAdapter<String> ing = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, juegos);

        imagenIV = (ImageView) findViewById(R.id.imagenIV);
        imagenIV2 = (ImageView) findViewById(R.id.imagenIV2);
        instruTX = (TextView) findViewById(R.id.instruccionTX);
        tituloTX = (TextView) findViewById(R.id.juegoTX);
        imagenTX= (TextView) findViewById(R.id.imagenTX);
        imagenTX.setText(reglas.getJuegos().get(0));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        int i=0;
        for (String com : new Instruciones().getJuegos()){
            menu.add(Menu.NONE, i, Menu.NONE, com).setIcon(android.R.drawable.ic_menu_preferences);
            i=i+1;

        }
       // menu.add(Menu.NONE, 1, Menu.NONE, juegos.get(0)).setIcon(android.R.drawable.ic_menu_preferences);
        //menu.add(Menu.NONE, 2, Menu.NONE, juegos.get(1)).setIcon(android.R.drawable.ic_menu_preferences);
        //getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        tipoJuego = id;
        imagenTX.setText(reglas.getJuegos().get(tipoJuego));
        instruTX.setText("");
        imagenIV.setImageResource(0);
        imagenIV2.setImageResource(0);

        return true;

        //noinspection SimplifiableIfStatement
     /*   if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);*/
    }

    public void tirar(){

        switch(tipoJuego){
            case 0: enemigo();
                break;
            case 1: kinito();
                break;
            default: enemigo();

        }
    }

    public void tirar(View v){

        reiniciarBT.setVisibility(View.VISIBLE);
        // inicioBT.setVisibility(View.INVISIBLE);

        String jue = (String)listJU.getSelectedItem();
        int i=0;
        for (String com : new Instruciones().getJuegos()){
            if (jue.equals(com)){
                tipoJuego=i;
            }
            i=i+1;

        }

        switch(tipoJuego){
            case 0: enemigo();
                break;
            case 1: kinito();
                break;
            default: enemigo();

        }
    }

    public void moverDado(){
        int a =0;
        for (int i=0;i<5;i++){

            imagenIV2.setImageResource(reglas.devolverImagen(i));
            // tareaSincrona = new HiloDado();
            //tareaSincrona.execute();
            for (int ii=0;ii<1000;ii++){
                a++;
            }
        }

    }
    public void volver(View v){
        inicioBT.setVisibility(View.VISIBLE);
        reiniciarBT.setVisibility(View.INVISIBLE);
        instruTX.setText("");
        imagenTX.setText("");
        imagenIV.setImageResource(0);
        imagenIV2.setImageResource(0);
    }
    public void enemigo(){
        // moverDado();
        Random random = new Random();
        int val = random.nextInt(reglas.getTamano());

        instruTX.setText(reglas.devolverRegla(val));

        imagenIV.setImageResource(reglas.devolverImagen(val));
        imagenIV2.setImageResource(0);

    }
    public void kinito(){
        Random random = new Random();
        int val = random.nextInt(reglas.getTamano());
        int val2 = random.nextInt(reglas.getTamano());
        instruTX.setText(reglas.devolverReglaK(val,val2));

        imagenIV.setImageResource(reglas.devolverImagen(val));
        imagenIV2.setImageResource(reglas.devolverImagen(val2));

    }

}
