package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NWMainPage extends AppCompatActivity {

    Button btn;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n_w_main_page);

        btn = findViewById(R.id.NWbtnDiet);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NWMainPage.this, NWeightDiet.class);
                startActivity(intent);
            }
        });

        btn2 = findViewById(R.id.NWbtnExercise);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NWMainPage.this, NWWeightExercise.class);
                startActivity(intent);
            }
        });


    }
}