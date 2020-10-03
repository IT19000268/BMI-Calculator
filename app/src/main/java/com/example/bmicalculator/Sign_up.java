package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sign_up extends AppCompatActivity {
Button button , button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        OnClickButtonListner();

        button1 = (Button)findViewById(R.id.button);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openOptions();
            }
        });

    }

    private void openOptions() {
        Intent intent = new Intent(this, Options.class);
        startActivity(intent);
    }



    public void OnClickButtonListner(){
        button=(Button)findViewById(R.id.button3);

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