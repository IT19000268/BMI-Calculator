package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OverWeight extends AppCompatActivity {
    Button button4;
    Button button;
    Button button3;
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_over_weight);
        OnClickButtonListner();}
        public void OnClickButtonListner(){
            button4=(Button)findViewById(R.id.button4);
            button=(Button)findViewById(R.id.button);
            button3=(Button)findViewById(R.id.button3);
            button2=(Button)findViewById(R.id.button2) ;
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(".WeightTracker");
                    startActivity(intent);
                }
            });
            button4.setOnClickListener(
                    new View.OnClickListener(){

                        @Override
                        public void onClick(View view) {
                            Intent intent=new Intent(".ExercisePlanJournal");
                            startActivity(intent);
                        }
                    }

            );
            button.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent=new Intent(".OverWeightDiet");
                            startActivity(intent);
                        }
                    }
            );
            button3.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent=new Intent(".OverweightExercises");
                            startActivity(intent);
                        }
                    }
            );

        }


}