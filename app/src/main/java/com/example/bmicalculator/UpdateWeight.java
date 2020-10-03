package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bmicalculator.Models.Weight;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UpdateWeight extends AppCompatActivity {

    EditText FinalWeight,InitialWeight,lossweight;
    Button Update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        Intent I1= getIntent();
        final String ID = I1.getStringExtra("ID");

        Update=findViewById(R.id.update12);
        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateData(ID);
            }
        });

    }
    public void UpdateData(String ID){
        DatabaseReference UpdateRef= FirebaseDatabase.getInstance().getReference().child("Weight").child(ID);
        FinalWeight=findViewById(R.id.inputInitial);
        InitialWeight=findViewById(R.id.inputFinal);
        lossweight=findViewById(R.id.inputCalories);
        Weight w1= new Weight();
        w1.setWeightID(ID);
        w1.setInititalWeight(InitialWeight.getText().toString());
        w1.setLossWeight(lossweight.getText().toString());
        w1.setFinalweight(FinalWeight.getText().toString());
        UpdateRef.setValue(w1);
        Toast.makeText(this, "Weight Updated", Toast.LENGTH_SHORT).show();
        Intent i1= new Intent(this,ViewWeightData.class);
        startActivity(i1);

    }
}