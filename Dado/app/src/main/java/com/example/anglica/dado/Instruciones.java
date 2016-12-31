package com.example.anglica.dado;

import android.graphics.drawable.Drawable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Angélica on 26/12/2016.
 */


public class Instruciones implements Serializable {
    private String[] reglas;
    private String[] reglasK;
    private int[] imagenes;
    private int tamano = 6;
    // TODO: EN la declaracion de variables usar siempre el tipo generico, no la implementacion
    private List<String> juegos = new ArrayList<String>();

    public Instruciones() {
        reglas = new String[tamano];
        reglasK = new String[2*tamano];
        imagenes = new int[tamano];

        reglas[0] ="Ha slido un 1. Coge reglo del centro";
        reglas[1] ="Ha slido un 2. Coge reglo del centro";
        reglas[2] ="Ha slido un 3. Devuelve un regalo";
        reglas[3] ="Ha slido un 4. Dona uno de tus regalos";
        reglas[4] ="Ha slido un 5. Intercambia un regalo con alguien";
        reglas[5] ="Ha slido un 6. Robas un regalo a alguien";

        reglasK[0] ="Ha slido un 1. Que sean ambos igual";
        reglasK[1] ="Ha slido un 2. Otra fácil de comprobar";
        reglasK[2] ="Ha slido un 3.";
        reglasK[3] ="Ha slido un 4.";
        reglasK[4] ="Ha slido un 5. ";
        reglasK[5] ="Ha slido un 6.";
        reglasK[6] ="Ha slido un 7.";
        reglasK[7] ="Ha slido un 8.";
        reglasK[8] ="Ha slido un 9.";
        reglasK[9] ="Ha slido un 10";
        reglasK[10] ="Ha slido un 11";
        reglasK[11] ="Ha slido un 12.";

        imagenes[0] =R.drawable.uno;
        imagenes[1] =R.drawable.dos;
        imagenes[2] =R.drawable.tres;
        imagenes[3] =R.drawable.cuatro;
        imagenes[4] =R.drawable.cinco;
        imagenes[5] =R.drawable.seis;
       // tamano = reglas.length;

        juegos.add("Enemigo invisible");
        juegos.add("Kinito");
    }

    public String devolverRegla(int valor){

        return reglas[valor];
    }
    public String devolverReglaK(int val1,int val2){
        int sol = 0;
        /**********Aquí como determinamos que responde*****************/

        return reglas[sol];
    }
    public int devolverImagen(int valor){

        return imagenes[valor];
    }
    public int getTamano(){

        return  tamano;

    }
    public List<String> getJuegos(){
        return juegos;
    }

}