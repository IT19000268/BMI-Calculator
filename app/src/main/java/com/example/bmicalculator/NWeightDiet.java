package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NWeightDiet extends AppCompatActivity {

    Button diet1;
    Button diet2;
    Button diet3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n_weight_diet);

        diet1 = findViewById(R.id.NWDietbtn);
        diet1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentDiet1 = new Intent(NWeightDiet.this, NWDiet1.class);
                startActivity(intentDiet1);
            }
        });

        diet2 = findViewById(R.id.NWDietbtn2);
        diet2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentDiet2 = new Intent(NWeightDiet.this, NWDiet2.class);
                startActivity(intentDiet2);
            }
        });

        diet3 = findViewById(R.id.NWDietbtn3);
        diet3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentDiet3 = new Intent(NWeightDiet.this, NWDiet3.class);
                startActivity(intentDiet3);
            }
        });
    }
}