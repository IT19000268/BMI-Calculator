package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class OverweightExercises extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overweight_exercises);
    }
    public void changeOverweightExercisesFragment(View view){
        Fragment fragment;
        if(view==findViewById(R.id.buttonweek1)){
            fragment=new Overweight_ExerciseFragment1();
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft=fm.beginTransaction();
            ft.replace(R.id.overweightfragmentdefault,fragment);
            ft.commit();
        }
        if(view==findViewById(R.id.buttonweek2)){
            fragment=new Overweight_ExerciseFragment2();
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft=fm.beginTransaction();
            ft.replace(R.id.overweightfragmentdefault,fragment);
            ft.commit();
        }
        if(view==findViewById(R.id.buttonweek3)){
            fragment=new Overweight_ExerciseFragment3();
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft=fm.beginTransaction();
            ft.replace(R.id.overweightfragmentdefault,fragment);
            ft.commit();
        }
        if(view==findViewById(R.id.buttonweek4)){
            fragment=new Overweight_ExerciseFragment4();
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft=fm.beginTransaction();
            ft.replace(R.id.overweightfragmentdefault,fragment);
            ft.commit();
        }

    }
}