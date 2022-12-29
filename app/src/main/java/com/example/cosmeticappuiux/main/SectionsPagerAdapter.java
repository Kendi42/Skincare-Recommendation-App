package com.example.cosmeticappuiux.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private final Context mContext;
    private final ArrayList<Fragment> FragmentArrayList = new ArrayList<>();
    private final ArrayList<String> FragmentTitle = new ArrayList<>();


    public SectionsPagerAdapter(Context context, FragmentManager fm, int behaviour) {
        super(fm, behaviour);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return FragmentArrayList.get(position);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return FragmentArrayList.size();
    }

    public void addFragment(Fragment fragment, String title){

        FragmentArrayList.add(fragment);
        FragmentTitle.add(title);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return FragmentTitle.get(position);
    }
}