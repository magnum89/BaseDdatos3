package com.ejemplo.creadorpostales;

import com.ejemplo.creadorpostales.utils.FileUtilities;


public class AplicacionCreadorDePostales extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();

        FileUtilities.saveAssetImage(this, "perro.jpg");
        FileUtilities.saveAssetImage(this, "gato.jpg");
        FileUtilities.saveAssetImage(this, "cachorro.jpg");
    }
}
