package com.ejemplo.creadorpostales;

import com.ejemplo.creadorpostales.utils.FileUtilities;


public class AplicacionCreadorDePostales extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();

        FileUtilities.saveAssetImage(this, "perro.jpg");//este es el contexto con  el cual estamos copiando
        FileUtilities.saveAssetImage(this, "gato.jpg");//estas imagenes assets
        FileUtilities.saveAssetImage(this, "cachorro.jpg");
    }
}
