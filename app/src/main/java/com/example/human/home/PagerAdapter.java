package com.example.human.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.human.disabled.DisabledFragment;
import com.example.human.donate.DonateFragment;
import com.example.human.homless.HomelessFragment;

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

        switch (position) {
            case 0:
                HomelessFragment tab1 = new HomelessFragment();
                return tab1;
            case 1:
                DisabledFragment tab2 = new DisabledFragment();
                return tab2;
            case 2:
                DonateFragment tab3 = new DonateFragment();
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

