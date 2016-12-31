package com.example.anglica.dado;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * Created by Angélica on 26/12/2016.
 */


public class Instruciones implements Serializable {
    private String[] reglas;
    private int[] imagenes;
    private int tamano = 6;
    public Instruciones() {
        reglas = new String[tamano];
        imagenes = new int[tamano];

        reglas[0] ="Ha slido un 1. Coge reglo del centro";
        reglas[1] ="Ha slido un 2. Coge reglo del centro";
        reglas[2] ="Ha slido un 3. Devuelve un regalo";
        reglas[3] ="Ha slido un 4. Dona uno de tus regalos";
        reglas[4] ="Ha slido un 5. Intercambia un regalo con alguien";
        reglas[5] ="Ha slido un 6. Robas un regalo a alguien";

        imagenes[0] =R.drawable.uno;
        imagenes[1] =R.drawable.dos;
        imagenes[2] =R.drawable.tres;
        imagenes[3] =R.drawable.cuatro;
        imagenes[4] =R.drawable.cinco;
        imagenes[5] =R.drawable.seis;
       // tamano = reglas.length;
    }

    public String devolverRegla(int valor){

        return reglas[valor];
    }
    public int devolverImagen(int valor){

        return imagenes[valor];
    }
    public int getTamano(){

        return  tamano;

    }
}