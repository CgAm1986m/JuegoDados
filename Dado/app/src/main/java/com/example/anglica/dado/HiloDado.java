package com.example.anglica.dado;

import android.os.AsyncTask;

/**
 * Created by Angélica on 30/12/2016.
 */


public class HiloDado extends AsyncTask<Object, Object, Void> {
    @Override
    protected Void doInBackground(Object... params) {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }



}