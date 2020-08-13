package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BMI_Classification extends AppCompatActivity {
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_m_i__classification);
        OnClickButtonListner();

    }
    public void OnClickButtonListner(){
        button=(Button)findViewById(R.id.button15);
        button.setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(".OverWeight");
                        startActivity(intent);
                    }
                }

        );
    }
}