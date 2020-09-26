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
    Button buttonInsert;
    DatabaseReference db;
    ListView listviewExercises;
    List<ExerciseJournal> exercisesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_plan_journal);
        db= FirebaseDatabase.getInstance().getReference().child("Exercises");
        listviewExercises=findViewById(R.id.exercisesList);
        exercisesList=new ArrayList<>();
        EtWeek=findViewById(R.id.EtWeek);
        EtHours=findViewById(R.id.EtHours);
        buttonInsert=findViewById(R.id.buttonInsert);
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addExercise();
            }
        });


    }
    @Override
    protected void onStart() {
        super.onStart();
        db.addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                exercisesList.clear();
                for(DataSnapshot exerciseSnapshot:dataSnapshot.getChildren()){
                    ExerciseJournal exercises=exerciseSnapshot.getValue(ExerciseJournal.class);
                    exercisesList.add(exercises);
                    assert exercises != null;
                    //Log.d("EXERCISE:",exercises.week);
                }
                ExerciseJournalList adapter=new ExerciseJournalList(ExercisePlanJournal.this,exercisesList);
                listviewExercises.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    private void addExercise(){
        String week=EtWeek.getText().toString().trim();
        String hours=EtHours.getText().toString().trim();
        if(!TextUtils.isEmpty(week)){
            String id=db.push().getKey();
            ExerciseJournal exercises=new ExerciseJournal(id,week,hours);
            db.child(id).setValue(exercises);
            Toast.makeText(this,"Exercise Added",Toast.LENGTH_SHORT).show();

        }else
            Toast.makeText(this,"You should enter a week",Toast.LENGTH_SHORT).show();
    }
}