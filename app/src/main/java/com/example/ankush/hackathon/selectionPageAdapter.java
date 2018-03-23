package com.example.ankush.hackathon;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ankush on 3/22/2018.
 */

public class selectionPageAdapter extends FragmentPagerAdapter {

    private final List<Fragment> mFragmentManager= new ArrayList<>();
    private final List<String> myFragmenttitle= new ArrayList<>();
    public selectionPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return myFragmenttitle.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentManager.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentManager.size();
    }

    public void addFreagment(Fragment fragment,String title){
        mFragmentManager.add(fragment);
        myFragmenttitle.add(title);

    }
}
