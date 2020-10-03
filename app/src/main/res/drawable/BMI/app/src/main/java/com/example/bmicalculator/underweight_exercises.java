package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class underweight_exercises extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_underweight_exercises);
    }

    public void changeUnderweightExercisesFragment(View view) {
        Fragment fragment;
        if (view == findViewById(R.id.buttonWeek1)) {
            fragment = new unserweight_exercise1();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.underweightfragmentdefault, fragment);
            ft.commit();
        }
        if (view == findViewById(R.id.buttonWeek2)) {
            fragment = new underweight_exercise2();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.underweightfragmentdefault, fragment);
            ft.commit();
        }
        if (view == findViewById(R.id.buttonWeek3)) {
            fragment = new underweight_exercise3();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.underweightfragmentdefault, fragment);
            ft.commit();
        }
        if (view == findViewById(R.id.buttonWeek4)) {
            fragment = new underweight_exercise4();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.underweightfragmentdefault, fragment);
            ft.commit();
        }
    }
}