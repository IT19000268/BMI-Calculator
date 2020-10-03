package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bmicalculator.Models.Diet;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Diet_planJ extends AppCompatActivity {

    private EditText InitialD,FinalD,GainedCal;
    private Button insert,Update,search,delete;
    DatabaseReference dbRef;
    Diet d1;

    private void clearControls(){
        InitialD.setText("");
        FinalD.setText("");
        //GainedCal.setText("");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_plan_j);

        InitialD=findViewById(R.id.inputInitial);
        FinalD=findViewById(R.id.inputFinal);
        GainedCal=findViewById(R.id.inputCalories);

        insert=findViewById(R.id.Insert);
        search=findViewById(R.id.Search);
        //search=findViewById(R.id.searchButton);
        Update=findViewById(R.id.Update);
        delete=findViewById(R.id.Delete);

        d1=new Diet();

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("Diet");
                try {
                    if (TextUtils.isEmpty(InitialD.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Initial Calories", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(GainedCal.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Gained Calories", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(FinalD.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Final Calories", Toast.LENGTH_SHORT).show();
                    else {
                        d1.setInitialCalories(InitialD.getText().toString().trim());
                        d1.setGainedCalories(GainedCal.getText().toString().trim());
                        d1.setFinalCalories(FinalD.getText().toString().trim());

                        //dbRef.push().setValue(d1);
                        dbRef.child("Diet1").setValue(d1);

                        Toast.makeText(getApplicationContext(), "Data inserted successfully", Toast.LENGTH_SHORT).show();
                        clearControls();
                    }
                }
                catch(NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"Invalid ",Toast.LENGTH_SHORT).show();
                }

            }
        });



        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference upRef=FirebaseDatabase.getInstance().getReference().child("Diet");
                upRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild("Diet1")){
                            try{
                                d1.setInitialCalories(InitialD.getText().toString().trim());
                                d1.setGainedCalories(GainedCal.getText().toString().trim());
                                d1.setFinalCalories(FinalD.getText().toString().trim());

                                dbRef=FirebaseDatabase.getInstance().getReference().child("Diet").child("Diet1");
                                dbRef.setValue(d1);
                                clearControls();
                                Toast.makeText(getApplicationContext(),"Data Updated Successfully",Toast.LENGTH_SHORT).show();

                            }
                            catch(NumberFormatException e){
                                Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                            Toast.makeText(getApplicationContext(),"No Source to Update",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });

        search.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("Diet").child("Diet1");
                readRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        if (dataSnapshot.hasChildren()) {
                            InitialD.setText(dataSnapshot.child("InitialCalories").getValue().toString());
                            GainedCal.setText(dataSnapshot.child("GainedCalories").getValue().toString());
                            FinalD.setText(dataSnapshot.child("FinalCalories").getValue().toString());
                        } else {
                            Toast.makeText(getApplicationContext(), "No Source to Display", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });


            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference delRef = FirebaseDatabase.getInstance().getReference().child("Diet");
                delRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChild("Diet1")) {
                            dbRef = FirebaseDatabase.getInstance().getReference().child("Diet").child("Diet1");
                            dbRef.removeValue();
                            clearControls();
                            Toast.makeText(getApplicationContext(), "Data Deleted Successfully", Toast.LENGTH_SHORT).show();
                        } else
                            Toast.makeText(getApplicationContext(), "No Source to Display", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });



    }
}