package com.ejemplo.creadorpostales.ui.activities;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

import com.ejemplo.creadorpostales.ui.fragments.ConfiguracionMemeFragment;

/**
 * Created by Evan Anger on 8/11/14.
 */
public class ActividadConfiguracionPostales extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new ConfiguracionMemeFragment())
                .commit();

        final ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
