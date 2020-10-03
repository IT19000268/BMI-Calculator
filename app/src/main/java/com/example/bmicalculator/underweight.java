package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class underweight extends AppCompatActivity {
    Button Buttondiet;
    Button Buttondietj;
    Button Buttonex;
    Button Buttonexj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_underweight);
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
                        openButton1();
                    }
                }
        );
        Buttondietj.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        openButton2();
                    }
                }
        );
        Buttonex.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        openButton3();
                    }
                }
        );
        Buttonexj.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        openButton4();
                    }
                }
        );
    }

    private void openButton4() {
        Intent intent=new Intent(this,ExerciseJournal.class);
        startActivity(intent);
    }

    private void openButton3() {
        Intent intent=new Intent(this,underweightExercises.class);
        startActivity(intent);
    }

    private void openButton2() {
        Intent intent=new Intent(this,Diet_planJ.class);
        startActivity(intent);
    }

    private void openButton1() {
        Intent intent=new Intent(this,underWeightDiet.class);
        startActivity(intent);
    }
}