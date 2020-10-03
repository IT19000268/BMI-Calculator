package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button Buttondiet;
    Button Buttondietj;
    Button Buttonex;
    Button Buttonexj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainunderw);
        OnClickListener();}

    private void OnClickListener() {
        Buttondiet=(Button)findViewById((R.id.Buttondiet));
        Buttondietj=(Button)findViewById((R.id.Buttondietj));
        Buttonex=(Button)findViewById((R.id.Buttonex));
        Buttonexj=(Button)findViewById((R.id.Buttonexj));

        Buttondiet.setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(".DIET");
                        startActivity(intent);
                    }
                }
        );
        Buttondietj.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(".DIET PLAN JOURNAL");
                        startActivity(intent);
                    }
                }
        );
        Buttonex.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(".EXERCISES");
                        startActivity(intent);
                    }
                }
        );
        Buttonexj.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(".EXERCISE PLAN JOURNAL");
                        startActivity(intent);
                    }
                }
        );
    }
}

