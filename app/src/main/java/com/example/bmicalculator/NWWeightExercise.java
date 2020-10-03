package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NWWeightExercise extends AppCompatActivity {

    Button exe1;
    Button exe2;
    Button exe3;
    Button nextExe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n_w_weight_exercise);

        exe1 = findViewById(R.id.NWexebtn2);
        exe1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentExe1 = new Intent(NWWeightExercise.this, NWExe1.class);
                startActivity(intentExe1);
            }
        });

        exe2 = findViewById(R.id.NWexebtn);
        exe2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentExe2 = new Intent(NWWeightExercise.this, NWExe2.class);
                startActivity(intentExe2);
            }
        });

        exe3 = findViewById(R.id.NWexebtn3);
        exe3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentExe3 = new Intent(NWWeightExercise.this, NWExe3.class);
                startActivity(intentExe3);
            }
        });

        nextExe = findViewById(R.id.NWexebtnNext);
        nextExe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentExeNext = new Intent(NWWeightExercise.this, NWeightExercise2.class);
                startActivity(intentExeNext);
            }
        });
    }
}