package com.example.bmicalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.bmicalculator.Models.Weight;
import com.example.bmicalculator.ViewHolder.WeightViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ViewWeightData extends AppCompatActivity {

    private DatabaseReference ProductsRef;
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_weight_data);
        ProductsRef = FirebaseDatabase.getInstance().getReference().child("Weight");
        recyclerView = findViewById(R.id.recycler_menu);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        FirebaseRecyclerOptions<Weight> options =
                new FirebaseRecyclerOptions.Builder<Weight>()
                        .setQuery(ProductsRef, Weight.class)
                        .build();


        FirebaseRecyclerAdapter<Weight, WeightViewHolder> adapter =
                new FirebaseRecyclerAdapter<Weight, WeightViewHolder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull WeightViewHolder holder, int position, @NonNull Weight model)
                    {
                        holder.Weightid.setText(model.getWeightID());
                        holder.initialweight.setText(model.getInititalWeight());
                        holder.newweight.setText(model.getFinalweight());
                        holder.Weightloss.setText(model.getLossWeight());
                        final String weigghtID=model.getWeightID();
                        holder.Delete.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                DeleteWeight(weigghtID);
                            }
                        });
                        holder.Update.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                UpdateDetails(weigghtID);
                            }
                        });
                    }
                    @NonNull
                    @Override
                    public WeightViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
                    {
                        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.avtivity_weight_items_layout, parent, false);
                        WeightViewHolder holder = new WeightViewHolder(view);
                        return holder;
                    }
                };
        recyclerView.setAdapter(adapter);
        adapter.startListening();
    }

    public void DeleteWeight(String ID){
        DatabaseReference deleteref=FirebaseDatabase.getInstance().getReference().child("Weight").child(ID);
        deleteref.removeValue();
        Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();

    }
    public void UpdateDetails(String ID){
        Intent i1= new Intent(this,UpdateWeight.class);
        i1.putExtra("ID",ID);
        startActivity(i1);

    }
}