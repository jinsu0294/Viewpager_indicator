package com.example.ediso.example2;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class CustomAdapter extends FragmentPagerAdapter {

    private final int ITEM_COUNT = 3;

    public CustomAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return SampleFragment.getInstance(position);
    }

    @Override
    public int getCount() {
        return ITEM_COUNT;

    }
}
