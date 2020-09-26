package com.example.waterintakejournal;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bmicalculator.R;
import com.example.bmicalculator.WaterIntake;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class WaterIntakeJ extends AppCompatActivity {

    EditText date, time, glassNum;
    Button btnInsert, btnUpdate, btnDelete, btnView;
    DatabaseReference myref;
    WaterIntake wi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        date = findViewById(R.id.editTextDate2);
        time = findViewById(R.id.editTextTime2);
        glassNum = findViewById(R.id.editTextNumberSigned);

        btnInsert = findViewById(R.id.buttonInsert);
        btnDelete = findViewById(R.id.buttonDelete);
        btnUpdate = findViewById(R.id.buttonUpdate);
        btnView = findViewById(R.id.buttonView);

        wi = new WaterIntake();

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myref = FirebaseDatabase.getInstance().getReference().child("WaterIntake").child("wi1");
                myref.removeValue();
                Toast.makeText(getApplicationContext(), "Successfully Deleted",Toast.LENGTH_SHORT).show();
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myref = FirebaseDatabase.getInstance().getReference().child("WaterIntake/wi1");
                myref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.hasChildren()){
                            date.setText(dataSnapshot.child("date").getValue().toString());
                            time.setText(dataSnapshot.child("time").getValue().toString());
                            glassNum.setText(dataSnapshot.child("glassNum").getValue().toString());
                        }
                        else
                            Toast.makeText(getApplicationContext(),"cannot find wi1",Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(getApplicationContext(),"EmptyDate", Toast.LENGTH_LONG).show();
                    else if (TextUtils.isEmpty(glassNum.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Empty Data",Toast.LENGTH_SHORT).show();
                    else {
                        wi.setDate(date.getText().toString().trim());
                        wi.setTime(time.getText().toString().trim());
                        wi.setNumGlass(glassNum.getText().toString().trim());
                        myref.child("wi1").setValue(wi);
                        Toast.makeText(getApplicationContext(),"Successfully Inserted", Toast.LENGTH_SHORT).show();
                        clearControls();
                    }
                }catch (NumberFormatException nfe){
                    Toast.makeText(getApplicationContext(),"Invalid no",Toast.LENGTH_SHORT).show();
                }


            }


        });


    }

    private void clearControls(){
        date.setText("");
        time.setText("");
        glassNum.setText("");
    }
}