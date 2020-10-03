package com.example.bmicalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ExercisePlanJournal extends AppCompatActivity {

EditText EtWeek,EtHours;
Button insertWeek,updateWeek,searchWeek,deleteWeek;
DatabaseReference dbref;
ExerciseJournal exercise;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_plan_journal);
        EtWeek=findViewById(R.id.EtWeek);
        EtHours=findViewById(R.id.EtHours);
        insertWeek=findViewById(R.id.insertWeek);
        updateWeek=findViewById(R.id.updateWeek);
        searchWeek=findViewById(R.id.searchWeek);
        deleteWeek=findViewById(R.id.deleteWeek);
        exercise=new ExerciseJournal();
        insertWeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbref=FirebaseDatabase.getInstance().getReference().child("Exercises");
                try{
                    if(TextUtils.isEmpty(EtWeek.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Please eneter a week",Toast.LENGTH_SHORT).show();
                    else{
                        exercise.setWeek(EtWeek.getText().toString().trim());
                        exercise.setHours(EtHours.getText().toString().trim());
                        dbref.child("exercise1").setValue(exercise);
                        Toast.makeText(getApplicationContext(),"Successfully Inserted",Toast.LENGTH_SHORT).show();
                        clearControls();

                    }

                }catch(NumberFormatException nfe){
                    Toast.makeText(getApplicationContext(),"Invalid Hours",Toast.LENGTH_SHORT).show();
                }
            }
        });
        searchWeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference readref=FirebaseDatabase.getInstance().getReference().child("Exercises").child("exercise1");
                readref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChildren()){
                            EtWeek.setText(dataSnapshot.child("week").getValue().toString());
                            EtHours.setText(dataSnapshot.child("hours").getValue().toString());
                        }else{
                            Toast.makeText(getApplicationContext(),"No source to display",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
        updateWeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference upref=FirebaseDatabase.getInstance().getReference().child("Exercises");
                upref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild("exercise1")){
                            try{
                                exercise.setWeek(EtWeek.getText().toString().trim());
                                exercise.setHours(EtHours.getText().toString().trim());
                                dbref=FirebaseDatabase.getInstance().getReference().child("Exercises").child("exercise1");
                                dbref.setValue(exercise);
                                clearControls();
                                Toast.makeText(getApplicationContext(),"Data Updated Successfully",Toast.LENGTH_SHORT).show();

                            }
                            catch (NumberFormatException nfe){
                                Toast.makeText(getApplicationContext(),"Invalid Hours",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                            Toast.makeText(getApplicationContext(),"No Source to display",Toast.LENGTH_SHORT).show();


                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
        deleteWeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference delref=FirebaseDatabase.getInstance().getReference().child("Exercises");
                delref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild("exercise1")){
                            dbref=FirebaseDatabase.getInstance().getReference().child("Exercises").child("exercise1");
                            dbref.removeValue();
                            clearControls();
                            Toast.makeText(getApplicationContext(),"Data Deleted Successfully",Toast.LENGTH_SHORT).show();
                        }else
                            Toast.makeText(getApplicationContext(),"No Source To Delete",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });




    }
    public void clearControls(){
        EtWeek.setText("");
        EtHours.setText("");
    }
}