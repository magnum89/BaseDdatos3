package com.ejemplo.creadorpostales.ui.fragments;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.ejemplo.creadorpostales.R;
import com.ejemplo.creadorpostales.adapters.GridViewAdapter;
import com.ejemplo.creadorpostales.models.ElementoMallaImagen;
import com.ejemplo.creadorpostales.ui.activities.ActividadCreadorDePostales;
import com.ejemplo.creadorpostales.ui.activities.ActividadConfiguracionPostales;

import java.io.File;
import java.util.ArrayList;


public class MallaImagenFragment extends Fragment {

    private GridView mGridView;
    private GridViewAdapter mGridAdapter;
    public static int RESULT_LOAD_IMAGE = 1000;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.malla_imagen_fragment, container, false);
        mGridView = (GridView) rootView.findViewById(R.id.gridView);
        mGridAdapter = new GridViewAdapter(this.getActivity(), R.layout.vista_malla, extractFiles());
        mGridView.setAdapter(mGridAdapter);
        mGridView.setOnItemClickListener(mOnItemClickListener);
        mGridView.setOnItemLongClickListener(mOnItemLongClickListener);
        this.setHasOptionsMenu(true);
        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.lista_imagenes, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.import_action) {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, RESULT_LOAD_IMAGE);
        } else {
            if (item.getItemId() == R.id.settings_action) {
                Intent intent = new Intent(this.getActivity(), ActividadConfiguracionPostales.class);
                startActivity(intent);
            }
        }

        return super.onOptionsItemSelected(item);
    }

    private ArrayList extractFiles() {
        final ArrayList imageItems = new ArrayList();
        return imageItems;
    }

    private void resetGridAdapter() {
        mGridAdapter = new GridViewAdapter(this.getActivity(), R.layout.vista_malla, extractFiles());
        mGridView.setAdapter(mGridAdapter);
    }

    protected AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            ElementoMallaImagen elementoMallaImagen = (ElementoMallaImagen) adapterView.getAdapter().getItem(i);
            Intent intent = new Intent(MallaImagenFragment.this.getActivity(), ActividadCreadorDePostales.class);
            intent.putExtra(ActividadCreadorDePostales.EXTRA_IMAGE_FILE_PATH, elementoMallaImagen.getFullPath());
            Log.d("FILE:", elementoMallaImagen.getFullPath());
            MallaImagenFragment.this.getActivity().startActivity(intent);
        }
    };

    protected AdapterView.OnItemLongClickListener mOnItemLongClickListener = new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
            final ElementoMallaImagen elementoMallaImagen = (ElementoMallaImagen) adapterView.getAdapter().getItem(i);

            AlertDialog.Builder builder = new AlertDialog.Builder(MallaImagenFragment.this.getActivity());
            builder.setTitle(R.string.dialog_confirm)
                    .setMessage(R.string.dialog_message_delete_file)
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            File fileToDelete = new File(elementoMallaImagen.getFullPath());
                            boolean deleted = fileToDelete.delete();
                            if (deleted) {
                                MallaImagenFragment.this.resetGridAdapter();
                            }
                        }
                    })
                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
            builder.create().show();
            return true;
        }
    };
}
