package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Options extends AppCompatActivity {

    Button button1, button2, button3, button4, button5, button6, button7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        button1 = (Button)findViewById(R.id.calculate_bmi);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openButton1();
            }
        });

        button2 = (Button)findViewById(R.id.bmi_classification);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openButton2();
            }
        });

        button3 = (Button)findViewById(R.id.underweight);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openButton3();
            }
        });



        button5 = (Button)findViewById(R.id.overweight);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opnButton5();
            }
        });

        button7 = (Button)findViewById(R.id.add_feedback);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openButton7();
            }
        });
    }

    private void openButton7() {

        Intent intent = new Intent(this, Add_Feedback.class);
        startActivity(intent);

    }

    private void openButton3() {
        Intent intent = new Intent(this, underweight.class);
        startActivity(intent);

    }

    private void opnButton7() {

    Intent intent = new Intent(this, Add_Feedback.class);
    startActivity(intent);
    }



    private void opnButton5() {
        Intent intent = new Intent(this, OverWeight.class);
        startActivity(intent);
    }

    private void openButton2() {
        Intent intent = new Intent(this, BMI_Classification.class);
        startActivity(intent);
    }

    private void openButton1() {

        Intent intent = new Intent(this, Calculation.class);
        startActivity(intent);

    }
}