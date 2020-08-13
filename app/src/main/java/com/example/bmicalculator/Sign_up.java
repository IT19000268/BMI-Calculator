package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sign_up extends AppCompatActivity {
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        OnClickButtonListner();

    }
    public void OnClickButtonListner(){
        button=(Button)findViewById(R.id.button16);
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