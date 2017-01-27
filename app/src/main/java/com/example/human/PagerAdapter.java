package com.example.human;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.human.view.HomelessFragment;
import com.example.human.view.MilaFragment;
import com.example.human.view.NesadaFragment;

/**
 * Created by Millochka on 1/27/17.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {


    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);

        this.mNumOfTabs = NumOfTabs;
    }


    @Override
    public Fragment getItem(int position) {
//        Fragment fragment = new NesadaFragment();
//        Bundle args = new Bundle();
//        // Our object is just an integer :-P
//        args.putInt(NesadaFragment.ARG_OBJECT, i + 1);
//        fragment.setArguments(args);

        switch (position) {
            case 0:
                HomelessFragment tab1 = new HomelessFragment();
                return tab1;
            case 1:
                NesadaFragment tab2 = new NesadaFragment();
                return tab2;
            case 2:
                MilaFragment tab3 = new MilaFragment();
                return tab3;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }

}

