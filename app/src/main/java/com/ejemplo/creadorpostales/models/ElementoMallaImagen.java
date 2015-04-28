package com.ejemplo.creadorpostales.models;

/**
 * Created by MightyMac on 7/5/14.
 */
import android.graphics.Bitmap;

public class ElementoMallaImagen {
    private Bitmap image;
    private String filename;
    private String fullPath;

    public ElementoMallaImagen(Bitmap image, String filename, String fullpath) {
        super();
        this.image = image;
        this.filename = filename;
        this.fullPath = fullpath;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFullPath() { return this.fullPath; }

    public void setFullPath(String fullPath) { this.fullPath = fullPath; }
}