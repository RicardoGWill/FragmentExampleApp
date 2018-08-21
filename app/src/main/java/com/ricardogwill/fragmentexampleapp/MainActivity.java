package com.ricardogwill.fragmentexampleapp;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentOneButtonOnClick();
        fragmentTwoButtonOnClick();

    }

    public void changeFragment(View view){
        Fragment fragment;

        if(view.getId() == R.id.fragment_1_button){
            FragmentOne fragmentOne = new FragmentOne();
            fragment = fragmentOne;
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place,fragment);
            ft.commit();
        }
        if(view.getId() == R.id.fragment_2_button){
            FragmentTwo fragmentTwo = new FragmentTwo();
            fragment = fragmentTwo;
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place,fragment);
            ft.commit();
        }
    }

    // Note that instead of writing these two functions below and calling them in the onCreate() method,
    // it is possible to just set the "onClick" XML for both buttons to call "changeFragment" (without parentheses).
    public void fragmentOneButtonOnClick() {
        Button fragmentOneButton =  findViewById(R.id.fragment_1_button);

        fragmentOneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(v);
            }
        });

    }

    public void fragmentTwoButtonOnClick() {
        Button fragmentTwoButton =  findViewById(R.id.fragment_2_button);

        fragmentTwoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(v);
            }
        });

    }

}
