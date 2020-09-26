package com.example.bmicalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bmicalculator.Models.Weight;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class WeightTracker extends AppCompatActivity {

    private EditText Inital,FInalw,Lossweight;
    private Button insert,Udate,search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_tracker);
        insert=findViewById(R.id.InserButton1);
        search=findViewById(R.id.search1);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InsertWeight();
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SearhcData();
            }
        });
    }


    public void InsertWeight(){
        Inital=findViewById(R.id.EX_intialweight1);
        FInalw=findViewById(R.id.Ex_newweight2);
        Lossweight=findViewById(R.id.Ex_weightLoss3);
        final DatabaseReference InsertRef= FirebaseDatabase.getInstance().getReference().child("Weight");
        try{
            DatabaseReference Readref=FirebaseDatabase.getInstance().getReference().child("Weight").child("InitialWeightID");
            Readref.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    String Weightid=dataSnapshot.child("WeightID").getValue().toString();
                    int WeightIDx=Integer.parseInt(Weightid);
                    WeightIDx++;
                    Weightid=Integer.toString(WeightIDx);
                    Weight w1= new Weight();
                    w1.setInititalWeight(Inital.getText().toString());
                    w1.setFinalweight(FInalw.getText().toString());
                    w1.setLossWeight(Lossweight.getText().toString());
                    w1.setWeightID(Weightid);
                    InsertRef.child(Weightid).setValue(w1);

                    DatabaseReference NewWieghtID=FirebaseDatabase.getInstance().getReference().child("Weight").child("InitialWeightID");
                    NewWieghtID.child("WeightID").setValue(Weightid);

                    Toast.makeText(WeightTracker.this, "data Instered", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });



        }catch ( Exception e){
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
            

        }

    }

    public void SearhcData(){
        Intent i1= new Intent(this,ViewWeightData.class);
        startActivity(i1);

        
    }
}