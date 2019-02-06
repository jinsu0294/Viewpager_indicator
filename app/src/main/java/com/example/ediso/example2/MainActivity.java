package com.example.ediso.example2;


import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.MotionEvent;
import android.view.View;

import android.widget.Button;

import com.pm10.library.LineIndicator;


public class MainActivity extends AppCompatActivity {

    ViewPager pager;
    float start_x;
    float end_x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager)findViewById(R.id.pager);
        init();

        Button prev_b = (Button)findViewById(R.id.prev);
        Button next_b = (Button)findViewById(R.id.next);
        next_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myOnClick(v);
            }
        });
        prev_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myOnClick(v);
            }
        });
        final View view = findViewById(R.id.pager);
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action =event.getAction();

                if(action == MotionEvent.ACTION_DOWN){
                    start_x = event.getX();
                }else if(action==MotionEvent.ACTION_UP){
                    end_x = event.getX();
                }
                if(Math.abs(start_x-end_x)>100){
                    myOnClick(view);
                }
                return false;
            }
        });
    }

    public void myOnClick(View v){
        int position;
        switch (v.getId()){
            case R.id.prev:
                position=pager.getCurrentItem();
                pager.setCurrentItem(position-1,true);
                break;
            case R.id.next:
                position=pager.getCurrentItem();
                pager.setCurrentItem(position+1,true);
                break;
        }
    }

    private void init() {
        pager = findViewById(R.id.pager);


        LineIndicator lineindicator = (LineIndicator) findViewById(R.id.line_indicator);
        lineindicator.setupWithViewPager(pager);

        pager.setAdapter(new CustomAdapter(getSupportFragmentManager()));
    }
}
