package com.example.anglica.dado;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private TextView instruTX;
    private TextView imagenTX;
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
    HiloDado tareaSincrona;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reglas = new Instruciones();

        instruTX = (TextView) findViewById(R.id.instruccionTX);
        imagenTX= (TextView) findViewById(R.id.imagenTX);
        inicioBT = (Button) findViewById(R.id.tirarBT);
        reiniciarBT = (Button) findViewById(R.id.reiniciarBT);

         inicio= (LinearLayout) findViewById(R.id.inicio);
         fin = (LinearLayout)findViewById(R.id.fin);
        imagen = (LinearLayout)findViewById(R.id.imagen);
        imagenIV = (ImageView) findViewById(R.id.imagenIV);
        imagenIV2 = (ImageView) findViewById(R.id.imagenIV2);
        listJU = (Spinner) findViewById(R.id.listaJuego) ;

        juegos = new Instruciones().getJuegos();
        ArrayAdapter<String> ing = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, juegos);

        listJU.setAdapter(ing);
        /*listJU.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //parent, contiene el adaptardor que estamos usando
            //view, el componente que lanza el eventa ListView
            //position, la posicion dentro del Listview que hemos pulsado
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String sPais = (String)parent.getItemAtPosition(position);

                int i=0;
                for (String com : new Instruciones().getJuegos()){
                    if (sPais.equals(com)){
                        tipoJuego=i;
                    }
                    i=i+1;

                }

            }
        });*/
        reiniciarBT.setVisibility(View.INVISIBLE);
       // instruTX.setText("Hola");
        //imagenTX.setText("Carambola");

    }

    public void spi(View v){}


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

     /*
        Random random = new Random();
        int val = random.nextInt(reglas.getTamano());

        instruTX.setText(reglas.devolverRegla(val));

        imagenIV.setImageResource(reglas.devolverImagen(val));
        */
       // Toast.makeText(this,"Ha salido el mensahjes "+reglas.devolverRegla(val)+" Salio el valor"+String.valueOf(val),Toast.LENGTH_SHORT).show();
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


