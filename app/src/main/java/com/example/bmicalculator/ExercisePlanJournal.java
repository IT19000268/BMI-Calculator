package com.example.bmicalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ExercisePlanJournal extends AppCompatActivity {
EditText EtInputWeek,EtInputTime,EtInputInitialWeight,EtInputNewWeight,EtInputLoss;
Button btnInsert,btnUpdate,btnDelete,btnSearch;
DatabaseReference dbref;
ExerciseJournal ej;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_plan_journal);

        EtInputWeek=findViewById(R.id.EtInputWeek);
        EtInputTime=findViewById(R.id.EtInputInitialWeight);
        EtInputInitialWeight=findViewById(R.id.EtInputInitialWeight);
        EtInputNewWeight=findViewById(R.id.EtInputNewWeight);
        EtInputLoss=findViewById(R.id.EtInputLoss);

        btnInsert=findViewById(R.id.btnInsert);
        btnUpdate=findViewById(R.id.btnUpdate);
        btnDelete=findViewById(R.id.btnDelete);
        btnSearch=findViewById(R.id.btnSearch);

        ej=new ExerciseJournal();
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbref= FirebaseDatabase.getInstance().getReference().child("ExerciseJournal");
                dbref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild("EJ2")){
                            dbref=FirebaseDatabase.getInstance().getReference().child("ExerciseJournal").child("EJ2").child(EtInputWeek.getText().toString());
                            dbref.removeValue();
                            clearControls();
                            Toast.makeText(getApplicationContext(),"Data Deleted Successfully",Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(getApplicationContext(),"No Source to delete",Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbref= FirebaseDatabase.getInstance().getReference().child("ExerciseJournal");
                try{
                    if(TextUtils.isEmpty(EtInputWeek.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Empty week number",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(EtInputTime.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Empty Input Time",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(EtInputInitialWeight.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Empty Initial Weight",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(EtInputNewWeight.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Empty New Weight",Toast.LENGTH_SHORT).show();
                    else{
                        ej.setWeekNumber(Integer.parseInt(EtInputWeek.getText().toString().trim()));
                        ej.setWorkoutTime(Integer.parseInt(EtInputTime.getText().toString().trim()));
                        ej.setInitialWeight(Float.parseFloat(EtInputInitialWeight.getText().toString().trim()));
                        ej.setNewWeight(Float.parseFloat(EtInputNewWeight.getText().toString().trim()));
                        ej.setWeightLoss(Float.parseFloat(EtInputLoss.getText().toString().trim()));
                        //dbref.child("EJ1").setValue(ej);
                        dbref.child("EJ2").push().setValue(ej);
                        Toast.makeText(getApplicationContext(),"Successfully inserted",Toast.LENGTH_SHORT).show();
                        clearControls();
                    }

                }catch(NumberFormatException nfe){
                    Toast.makeText(getApplicationContext(),"Invalid weight loss",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void clearControls(){
        EtInputWeek.setText("");
        EtInputTime.setText("");
        EtInputInitialWeight.setText("");
        EtInputNewWeight.setText("");
        EtInputLoss.setText("");
    }
}