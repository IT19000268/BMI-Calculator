package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculation extends AppCompatActivity {

    Button cal;
    EditText wt , ht;
    TextView edit1 , edit2;

    float weight , height , result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation);

        cal = findViewById(R.id.calculate);
        wt = findViewById(R.id.weight);
        ht = findViewById(R.id.height);
        edit1 = findViewById(R.id.result);


        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                weight = Float.parseFloat(wt.getText().toString());
                height = Float.parseFloat(ht.getText().toString());
                result = weight/(height*height);

                edit1.setText(String.valueOf(result));

                //if(result>=25){
                   // edit2.setText("overweight");
                //}
                //else if(result < 18){
                 //   edit2.setText("underweight");
                //}
                //else{
                 //   edit2.setText("normal");
                //}
            }
        });
    }
}