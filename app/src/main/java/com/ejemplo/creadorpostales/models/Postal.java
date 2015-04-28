package com.ejemplo.creadorpostales.models;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Evan Anger on 8/17/14.
 */
public class Postal implements Serializable {
    private int mId;
    private String mAssetLocation;
    private ArrayList<AnotacionPostal> mAnnotations;
    private String mName;

    public Postal(int id, String assetLocation, String name, ArrayList<AnotacionPostal> annotations) {
        mId = id;
        mAssetLocation = assetLocation;
        mAnnotations = annotations;
        mName = name;
    }

    public int getId() { return mId; }
    public String getAssetLocation() {
        return mAssetLocation;
    }

    public void setAssetLocation(String assetLocation) {
        mAssetLocation = assetLocation;
    }

    public ArrayList<AnotacionPostal> getAnnotations() {
        return mAnnotations;
    }

    public void setAnnotations(ArrayList<AnotacionPostal> annotations) {
        mAnnotations = annotations;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) { mName = name; }

    public Bitmap getBitmap() {
        File file = new File(mAssetLocation);
        if(!file.exists()) {
            Log.e("FILE IS MISSING", mAssetLocation);
        }
        return BitmapFactory.decodeFile(mAssetLocation);
    }
}
