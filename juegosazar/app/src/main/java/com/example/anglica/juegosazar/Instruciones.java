package com.example.anglica.juegosazar;

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

        reglas[0] ="Ha salido un 1. Coge regalo del centro";
        reglas[1] ="Ha salido un 2. Coge regalo del centro";
        reglas[2] ="Ha salido un 3. Devuelve un regalo";
        reglas[3] ="Ha salido un 4. Dona uno de tus regalos";
        reglas[4] ="Ha salido un 5. Intercambia un regalo con alguien";
        reglas[5] ="Ha salido un 6. Robas un regalo a alguien";

        reglasK[0] ="Ambos son iguales, mandas beber a alguien";
        reglasK[1] ="Beben los señores del tres";
        reglasK[2] ="Pasa turno.";
        reglasK[3] ="Pasa turno.";
        reglasK[4] ="Pasa turno.";
        reglasK[5] ="Pasa turno.";
        reglasK[9] ="Pasa turno.";
        reglasK[6] ="Bebe el de tu izquierda y vuelve a tirar";
        reglasK[7] ="Todos beben y el lento otro de propina. Vuelve a tirar";
        reglasK[8] ="Bebe el de tu dererecha y vuelve a tirar";
        reglasK[10] ="Pasa turno.";
        reglasK[11] ="Pasa turno.";
        //reglasK[12] ="Pasa turno.";

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
        int sol = 1;
        /**********Aquí como determinamos que responde*****************/
        sol=val1+val2+1;
        if(val1==val2){
            sol=0;
            //return reglasK[sol];
        }
        if(val1==2 || val2==2){

            return reglasK[1]+reglasK[sol];
        }
      /*if((val1+val2)==7){
            sol = 7;
        }
        if((val1+val2)==9){
            sol = 9;
        }
        if((val1+val2)==8){
            sol = 8;
        }*/

        return reglasK[sol];
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