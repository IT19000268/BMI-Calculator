package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class underweightExercises extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_underweight_exercises);
    }
    public void changeUnderweightExercisesFragment(View view) {
        Fragment fragment;
        if (view == findViewById(R.id.buttonWeek1)) {
            fragment = new underweightExercise1();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.underweightfragmentdefault, fragment);
            ft.commit();
        }
        if (view == findViewById(R.id.buttonWeek2)) {
            fragment = new underweightExercise2();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.underweightfragmentdefault, fragment);
            ft.commit();
        }
        if (view == findViewById(R.id.buttonWeek3)) {
            fragment = new underweightExercise3();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.underweightfragmentdefault, fragment);
            ft.commit();
        }
        if (view == findViewById(R.id.buttonWeek4)) {
            fragment = new underweightExercise4();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.underweightfragmentdefault, fragment);
            ft.commit();
        }
    }
}