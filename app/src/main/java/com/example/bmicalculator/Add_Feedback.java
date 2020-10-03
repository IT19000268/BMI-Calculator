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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Add_Feedback extends AppCompatActivity {

    EditText USERNAME, FEEDBACK;
    Button insert, search ,delete, update;
    DatabaseReference dbRef;
    Feedback fed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        USERNAME = findViewById(R.id.username);
        FEEDBACK = findViewById(R.id.feedback);


        insert = (Button)findViewById(R.id.insert);
        search = (Button)findViewById(R.id.search);
        update = (Button)findViewById(R.id.update);
        delete = (Button)findViewById(R.id.delete);

        //fed = new Feedback();

      /*  insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("Feedback");
                try{

                    if(TextUtils.isEmpty(USERNAME.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Empty username",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(FEEDBACK.getText().toString()))
                        Toast.makeText(getApplicationContext(),"feedback is empty",Toast.LENGTH_SHORT).show();

                    else{
                        fed.setUsername(USERNAME.getText().toString().trim());
                        fed.setFeedback(FEEDBACK.getText().toString().trim());

                        dbRef.child("Fed1").setValue(fed);
                        Toast.makeText(getApplicationContext(),"successfully inserted", Toast.LENGTH_SHORT).show();
                        clearControls();
                    }

                }catch(Exception e){
                    Toast.makeText(getApplicationContext(), "invalid feedback", Toast.LENGTH_SHORT).show();

                }
            }
        });*/

       /* search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dbRef=FirebaseDatabase.getInstance().getReference().child("Feedback/Fed1");
                dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChildren()){
                            USERNAME.setText(dataSnapshot.child("username").getValue().toString());
                            FEEDBACK.setText(dataSnapshot.child("feedback").getValue().toString());
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"cannot find Fed1", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });*/


       /* update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbRef = FirebaseDatabase.getInstance().getReference();
                dbRef.child("Feedback").child("Fed1").setValue(USERNAME.getText().toString().trim());
                dbRef.child("Feedback/Fed1/feedback").setValue(FEEDBACK.getText().toString().trim());
                Toast.makeText(getApplicationContext(),"successfully updated the feedback", Toast.LENGTH_SHORT).show();
                clearControls();
            }
        });*/


        /*delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference delRef = FirebaseDatabase.getInstance().getReference().child("Feedback");
                delRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild("Fed1")){
                            dbRef = FirebaseDatabase.getInstance().getReference().child("Feedback").child("Feedback1");
                            dbRef.removeValue();
                            clearControls();
                            Toast.makeText(getApplicationContext(), "feedback deleted successfully",Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getApplicationContext(), "no data to display",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                //dbRef = FirebaseDatabase.getInstance().getReference().child("Feedback").child("Fed1");
                //dbRef.removeValue();
                Toast.makeText(getApplicationContext(), "successfully deleted", Toast.LENGTH_SHORT).show();

            }
        });
*/






    }

  //  private void clearControls(){
  //      USERNAME.setText("");
  //      FEEDBACK.setText("");
  //  }

}