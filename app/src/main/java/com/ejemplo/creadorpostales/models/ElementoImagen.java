package com.ejemplo.creadorpostales.models;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by Evan Anger on 7/28/14.
 */
public class ElementoImagen {
    private Bitmap mBitmap;
    private String mText;

    public ElementoImagen(String filePath, String text) {
        mBitmap = BitmapFactory.decodeFile(filePath);
        mText = text;
    }

    public Bitmap getBitmap() {
        return mBitmap;
    }

    public String getText() {
        return mText;
    }
}
