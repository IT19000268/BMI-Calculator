package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class OverWeightDiet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_over_weight_diet);
    }
    public void overweightDiet(View view){
        Fragment fragment;
        if(view==findViewById(R.id.buttonoverweightdiet1)){
            fragment=new overweightDietFragment1();
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft=fm.beginTransaction();
            ft.replace(R.id.overweightdietdefault,fragment);
            ft.commit();
        }
        if(view==findViewById(R.id.buttonoverweightdiet2)){
            fragment=new overweightDietFragment2();
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft=fm.beginTransaction();
            ft.replace(R.id.overweightdietdefault,fragment);
            ft.commit();
        }
        if(view==findViewById(R.id.buttonoverweightdiet3)){
            fragment=new overweightDietFragment3();
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft=fm.beginTransaction();
            ft.replace(R.id.overweightdietdefault,fragment);
            ft.commit();
        }
        if(view==findViewById(R.id.buttonoverweightdiet4)){
            fragment=new overweightDietFragment4();
            FragmentManager fm=getSupportFragmentManager();
            FragmentTransaction ft=fm.beginTransaction();
            ft.replace(R.id.overweightdietdefault,fragment);
            ft.commit();
        }

    }
}