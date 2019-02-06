package com.example.ediso.example2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pm10.library.LineIndicator;

public class SampleFragment extends Fragment {
    private int position;

    public static SampleFragment getInstance(int position) {
        SampleFragment sampleFragment = new SampleFragment();
        sampleFragment.position = position;
        return sampleFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_pager2, null);

        ((TextView) view.findViewById(R.id.Child_page)).setText(String.valueOf(position +"번째"));
                return view;
    }
}
