package com.example.bmicalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bmicalculator.Models.Diet;
import com.example.bmicalculator.Models.Weight;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DietPlanner extends AppCompatActivity {
    private EditText InitialD,FinalD,GainedCal;
    private Button insert,Update,search,delete;
    DatabaseReference dbRef;
    DietNew d2;

    private void clearControls(){
        InitialD.setText("");
        FinalD.setText("");
        GainedCal.setText("");

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_planner);


        InitialD=findViewById(R.id.inputInitial);
        FinalD=findViewById(R.id.inputFinal);
        GainedCal=findViewById(R.id.inputCalories);

        insert=findViewById(R.id.InserButton);
        search=findViewById(R.id.searchButton);
        //search=findViewById(R.id.searchButton);
        Update=findViewById(R.id.updatbutton);
        delete=findViewById(R.id.DELETEbUTTON);

        d2=new DietNew();

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("DietNew");
                try {
                    if (TextUtils.isEmpty(InitialD.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Initial Calories", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(GainedCal.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Gained Calories", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(FinalD.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Final Calories", Toast.LENGTH_SHORT).show();
                    else {
                        d2.setInitialCalories(InitialD.getText().toString().trim());
                        d2.setGainedCalories(GainedCal.getText().toString().trim());
                        d2.setGainedCalories(FinalD.getText().toString().trim());

                        //dbRef.push().setValue(d1);
                        dbRef.child("Diet2").setValue(d2);

                        Toast.makeText(getApplicationContext(), "Data inserted successfully", Toast.LENGTH_SHORT).show();
                        clearControls();
                    }
                }
                catch(NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"Invalid ",Toast.LENGTH_SHORT).show();
                }

            }
        });

        /*search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference readRef=FirebaseDatabase.getInstance().getReference().child("Diet").child("Diet1");
                readRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChildren()){
                            InitalD.setText(dataSnapshot.child("InititalCalories").getValue().toString());
                            GainedCal.setText(dataSnapshot.child("GainedCalories").getValue().toString());
                            FinalD.setText(dataSnapshot.child("FinalCalories").getValue().toString());
                        }
                        else
                            Toast.makeText(getApplicationContext(),"No Source is Display",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });*/

        search.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("DietNew").child("Diet2");
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

        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference upRef=FirebaseDatabase.getInstance().getReference().child("DietNew");
                upRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild("Diet2")){
                            try{
                                d2.setInitialCalories(InitialD.getText().toString().trim());
                                d2.setGainedCalories(GainedCal.getText().toString().trim());
                                d2.setFinalCalories(FinalD.getText().toString().trim());

                                dbRef=FirebaseDatabase.getInstance().getReference().child("DietNew").child("Diet2");
                                dbRef.setValue(d2);
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

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference delRef = FirebaseDatabase.getInstance().getReference().child("DietNew");
                delRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChild("Diet2")) {
                            dbRef = FirebaseDatabase.getInstance().getReference().child("DietNew").child("Diet2");
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
    /*public void InsertDiet(){
        InitalD=findViewById(R.id.EX_intialweight1);
        FinalD=findViewById(R.id.Ex_newweight2);
        GainedCal=findViewById(R.id.Ex_weightLoss3);
        final DatabaseReference InsertRef= FirebaseDatabase.getInstance().getReference().child("Diet");
        try{
            DatabaseReference Readref=FirebaseDatabase.getInstance().getReference().child("Diet").child("InitialDietID");
            Readref.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    String DietID=dataSnapshot.child("DietID").getValue().toString();
                    int DietIDx=Integer.parseInt(DietID);
                    DietIDx++;
                    DietID=Integer.toString(DietIDx);
                    Diet d1= new Diet();
                    d1.setInititalCalories(InitalD.getText().toString());
                    d1.setFinalCalories(FinalD.getText().toString());
                    d1.setGainedCalories(GainedCal.getText().toString());
                    d1.setDietID(DietID);
                    InsertRef.child(DietID).setValue(d1);

                    DatabaseReference NewDietID=FirebaseDatabase.getInstance().getReference().child("Diet").child("InitialDietID");
                    NewDietID.child("DietID").setValue(DietID);

                    Toast.makeText(DietPlanner.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });



        }catch ( Exception e){
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();


        }

    }*/


}