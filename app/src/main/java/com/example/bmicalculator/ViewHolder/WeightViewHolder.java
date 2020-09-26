package com.example.bmicalculator.ViewHolder;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.bmicalculator.Interface.ItemClickListner;
import com.example.bmicalculator.R;

public class WeightViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    public TextView Weightid,initialweight,newweight,Weightloss;
    public Button Update,Delete;
    private ItemClickListner listner;

    public WeightViewHolder(View itemView)
    {
        super(itemView);
        Weightid=itemView.findViewById(R.id.WeightID);
        initialweight=itemView.findViewById(R.id.Intitalweight);
        newweight=itemView.findViewById(R.id.Newwieght);
        Weightloss=itemView.findViewById(R.id.Weightloss);
        Update=itemView.findViewById(R.id.UpdateButton);
        Delete=itemView.findViewById(R.id.DeleteButton);
    }

    public void setItemClickListner(ItemClickListner listner)
    {
        this.listner = listner;
    }

    @Override
    public void onClick(View view)
    {
        listner.onClick(view, getAdapterPosition(), false);
    }
}