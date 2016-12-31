package com.example.anglica.dado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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

        reiniciarBT.setVisibility(View.INVISIBLE);
       // instruTX.setText("Hola");
        //imagenTX.setText("Carambola");



    }
    public void tirar(View v){

        reiniciarBT.setVisibility(View.VISIBLE);
       // inicioBT.setVisibility(View.INVISIBLE);
        Random random = new Random();
        int val = random.nextInt(reglas.getTamano());

        instruTX.setText(reglas.devolverRegla(val));

        imagenIV.setImageResource(reglas.devolverImagen(val));

       // Toast.makeText(this,"Ha salido el mensahjes "+reglas.devolverRegla(val)+" Salio el valor"+String.valueOf(val),Toast.LENGTH_SHORT).show();
    }
    public void volver(View v){
        inicioBT.setVisibility(View.VISIBLE);
        reiniciarBT.setVisibility(View.INVISIBLE);
        instruTX.setText("");
        imagenTX.setText("");
        imagenIV.setImageResource(0);
    }
}
