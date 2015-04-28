package com.ejemplo.creadorpostales.database;

import android.content.Context;

/**
 * Created by Evan Anger on 8/17/14.
 */
public class PostalDatasource {

    private Context mContext;
    private PostalSQLiteHelper mMemeSqlLiteHelper;

    public PostalDatasource(Context context) {
        mContext = context;
    }
}
