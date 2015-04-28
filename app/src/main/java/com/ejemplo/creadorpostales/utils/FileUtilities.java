package com.ejemplo.creadorpostales.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class FileUtilities {

    public static void saveAssetImage(Context context, String assetName) {

        //manejador de archivos
        File directorioArchivos = context.getFilesDir();
        File archivoAEscribir = new File(directorioArchivos, assetName);//nos va a dar un archivo dentro de la ruta directoriArchivos
        //y el nombre de este archivo se encuentra en la variable de assetName, tambien se escribe informacion en el almacenamiento interno

        //tener acceso a los archivos asserts para poder leerlos
        AssetManager manejadorDeAssets = context.getAssets();
        //crear una corriente de archivos o fileStreem para las entradas
        //son una manera simplificada para leer o escribir archivos en el sistema de archivo
        InputStream is = manejadorDeAssets.open(assetName);
        //para indicar donde queremos copiar este archivo que acabamos de leer


    }

    public static Uri saveImageForSharing(Context context, Bitmap bitmap,  String assetName) {
        File fileToWrite = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), assetName);

        try {
            FileOutputStream outputStream = new FileOutputStream(fileToWrite);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return Uri.fromFile(fileToWrite);
        }
    }


    public static void saveImage(Context context, Bitmap bitmap, String name) {
        File fileDirectory = context.getFilesDir();
        File fileToWrite = new File(fileDirectory, name);

        try {
            FileOutputStream outputStream = new FileOutputStream(fileToWrite);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
