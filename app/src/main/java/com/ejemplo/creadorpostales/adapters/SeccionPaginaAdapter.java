package com.ejemplo.creadorpostales.adapters;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.support.v13.app.FragmentPagerAdapter;


import com.ejemplo.creadorpostales.R;
import com.ejemplo.creadorpostales.ui.fragments.MallaImagenFragment;
import com.ejemplo.creadorpostales.ui.fragments.ElementoPostalFragment;

/**
 * Created by Evan Anger on 8/10/14.
 */
//fragmentPager Adapter
public class SeccionPaginaAdapter extends FragmentPagerAdapter {
    Context mContext;

    public SeccionPaginaAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }


    public Fragment getItem(int position) {
        Fragment fragment;
        if(position == 0) {
            fragment = new MallaImagenFragment();
        } else {
            fragment = new ElementoPostalFragment();
        }
        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0) {
            return mContext.getString(R.string.images_fragment_title);
        } else {
            return mContext.getString(R.string.postal_fragment_title);
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
