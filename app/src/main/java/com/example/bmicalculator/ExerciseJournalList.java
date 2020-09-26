package com.example.bmicalculator;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ExerciseJournalList extends ArrayAdapter<ExerciseJournal> {
    private Activity context;
    private List<ExerciseJournal> exerciseJournalList;
    public ExerciseJournalList(Activity context,List<ExerciseJournal> exerciseJournalList){
        super(context,R.layout.list_layout);
        this.context=context;
        this.exerciseJournalList=exerciseJournalList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_layout,null,true);
        TextView textviewWeek=(TextView)listViewItem.findViewById(R.id.textviewWeek);
        TextView textviewHours=(TextView)listViewItem.findViewById(R.id.textviewHours);
        ExerciseJournal exercises=exerciseJournalList.get(position);
        textviewWeek.setText(exercises.getWeek());
        textviewHours.setText(exercises.getHours());
        return listViewItem;
    }
}
