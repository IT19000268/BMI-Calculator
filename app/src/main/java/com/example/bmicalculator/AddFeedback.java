package com.example.bmicalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
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

public class AddFeedback extends AppCompatActivity {

    EditText USERNAME, FEEDBACK;
    Button insert, search ,delete, update;
    DatabaseReference dbRef;
    Feedback fed1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_feedback);

        USERNAME = findViewById(R.id.username);
        FEEDBACK = findViewById(R.id.feedback);


        insert = (Button)findViewById(R.id.insert);
        search = (Button)findViewById(R.id.search);
        update = (Button)findViewById(R.id.update);
        delete = (Button)findViewById(R.id.delete);

        fed1 = new Feedback();

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("Feedback");
                try{

                    if(TextUtils.isEmpty(USERNAME.getText().toString()))
                        Toast.makeText(getApplicationContext(),"Empty username",Toast.LENGTH_SHORT).show();
                    else if(TextUtils.isEmpty(FEEDBACK.getText().toString()))
                        Toast.makeText(getApplicationContext(),"feedback is empty",Toast.LENGTH_SHORT).show();

                    else{
                        fed1.setUsername(USERNAME.getText().toString().trim());
                        fed1.setFeedback(FEEDBACK.getText().toString().trim());

                        dbRef.child("Fed2").setValue(fed1);
                        Toast.makeText(getApplicationContext(),"successfully inserted", Toast.LENGTH_SHORT).show();
                        clearControls();
                    }

                }catch(Exception e){
                    Toast.makeText(getApplicationContext(), "invalid feedback", Toast.LENGTH_SHORT).show();

                }
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseReference upRef = FirebaseDatabase.getInstance().getReference().child("Feedback");
                upRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        if (dataSnapshot.hasChild("Fed2")) {
                            try {
                                fed1.setUsername(USERNAME.getText().toString().trim());
                                fed1.setFeedback(FEEDBACK.getText().toString().trim());

                                dbRef = FirebaseDatabase.getInstance().getReference().child("Feedback").child("Fed2");
                                dbRef.setValue(fed1);
                                clearControls();
                                Toast.makeText(getApplicationContext(), "Feedback Updated Successfully", Toast.LENGTH_SHORT).show();

                            } catch (NumberFormatException e) {
                                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                            }
                        } else
                            Toast.makeText(getApplicationContext(), "No Source to Update", Toast.LENGTH_SHORT).show();
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

                        DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("Feedback").child("Fed2");
                        readRef.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {

                                if (dataSnapshot.hasChildren()) {
                                    USERNAME.setText(dataSnapshot.child("username").getValue().toString());
                                    FEEDBACK.setText(dataSnapshot.child("feedback").getValue().toString());
                                } else {
                                    Toast.makeText(getApplicationContext(), "cannot find Fed1", Toast.LENGTH_SHORT).show();
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
                DatabaseReference delRef = FirebaseDatabase.getInstance().getReference().child("Feedback");
                delRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild("Fed2")){
                            dbRef = FirebaseDatabase.getInstance().getReference().child("Feedback").child("Fed2");
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

            }


            private void clearControls() {

                USERNAME.setText("");
                FEEDBACK.setText("");
            }
        }