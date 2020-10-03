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

public class WaterIntakeMain extends AppCompatActivity {

    EditText date, time, glassNum;
    Button btnInsert, btnUpdate, btnDelete, btnView;
    DatabaseReference myref;
    WaterIntake wi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_intake_main);

        date = findViewById(R.id.editTextDate);
        time = findViewById(R.id.editTextTime);
        glassNum = findViewById(R.id.editTextNumberSigned2);

        btnInsert = findViewById(R.id.buttonInsert2);
        btnDelete = findViewById(R.id.buttonDelete);
        btnUpdate = findViewById(R.id.buttonUpdate);
        btnView = findViewById(R.id.buttonView2);

        wi = new WaterIntake();

        /*btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference delRef = FirebaseDatabase.getInstance().getReference().child("WaterIntake");
                delRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChild("water1")) {
                            myref = FirebaseDatabase.getInstance().getReference().child("WaterIntake").child("water1");
                            myref.removeValue();
                            clearControls();
                            Toast.makeText(getApplicationContext(), "deleted successfully", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "no data to display", Toast.LENGTH_SHORT).show();
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
        });*/






        btnView.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View view){

        DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("WaterIntake").child("water1");
        //myref = FirebaseDatabase.getInstance().getReference().child("WaterIntake").child("water1");
        readRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChildren()) {
                    date.setText(dataSnapshot.child("date").getValue().toString());
                    time.setText(dataSnapshot.child("time").getValue().toString());
                    glassNum.setText(dataSnapshot.child("numGlass").getValue().toString());
                } else
                    Toast.makeText(getApplicationContext(), "cannot find", Toast.LENGTH_SHORT).show();
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

                myref = FirebaseDatabase.getInstance().getReference().child("WaterIntake");
                try {
                    if (TextUtils.isEmpty(date.getText().toString()))
                        Toast.makeText(getApplicationContext(), "EmptyDate", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(time.getText().toString()))
                        Toast.makeText(getApplicationContext(), "EmptyDate", Toast.LENGTH_LONG).show();
                    else if (TextUtils.isEmpty(glassNum.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Empty Data", Toast.LENGTH_SHORT).show();
                    else {
                        wi.setDate(date.getText().toString().trim());
                        wi.setTime(time.getText().toString().trim());
                        wi.setNumGlass(Integer.parseInt(glassNum.getText().toString().trim()));
                        //  myref.push().setValue(wi);
                        myref.child("water1").setValue(wi);
                        Toast.makeText(getApplicationContext(), "Successfully Inserted", Toast.LENGTH_SHORT).show();
                        clearControls();
                    }
                } catch (NumberFormatException nfe) {
                    Toast.makeText(getApplicationContext(), "Invalid no", Toast.LENGTH_SHORT).show();
                }


            }


        });


       /* btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseReference upRef = FirebaseDatabase.getInstance().getReference().child("WaterIntake");
                upRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        if (dataSnapshot.hasChild("water1")) {
                            try {
                                wi.setDate(date.getText().toString().trim());
                                wi.setTime(time.getText().toString().trim());
                                wi.setNumGlass(Integer.parseInt(glassNum.getText().toString().trim()));

                                myref = FirebaseDatabase.getInstance().getReference().child("WaterIntake").child("water1");
                                myref.setValue(wi);
                                clearControls();
                                Toast.makeText(getApplicationContext(), "Updated Successfully", Toast.LENGTH_SHORT).show();

                            } catch (NumberFormatException e) {
                                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                            }
                        } else
                            Toast.makeText(getApplicationContext(), "No Source to Update", Toast.LENGTH_SHORT).show();
                    }


                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });*/

        /*btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference upref=FirebaseDatabase.getInstance().getReference().child("WaterIntake");
                upref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild("water1")){
                            try{
                                wi.setDate(date.getText().toString().trim());
                                wi.setTime(time.getText().toString().trim());
                                wi.setNumGlass(Integer.parseInt(glassNum.getText().toString().trim()));
                                myref=FirebaseDatabase.getInstance().getReference().child("WaterIntake").child("water1");
                                myref.setValue(wi);
                                clearControls();
                                Toast.makeText(getApplicationContext(),"Updated Successfully",Toast.LENGTH_SHORT).show();

                            }
                            catch (NumberFormatException nfe){
                                Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
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
        });*/
        /*btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference delref=FirebaseDatabase.getInstance().getReference().child("WaterIntake");
                delref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.hasChild("water1")){
                            myref=FirebaseDatabase.getInstance().getReference().child("WaterIntake").child("water1");
                            myref.removeValue();
                            clearControls();
                            Toast.makeText(getApplicationContext(),"Data deleted successfully",Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(getApplicationContext(),"No source ti display",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });*/
            }

            private void clearControls() {
                date.setText("");
                time.setText("");
                glassNum.setText("");
            }

        }
