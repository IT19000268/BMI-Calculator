package com.example.bmicalculator;

public class ExerciseJournal {
    String id;
    String week;
    String hours;

    public ExerciseJournal() {
    }

    public ExerciseJournal(String id, String week, String hours) {
        this.id = id;
        this.week = week;
        this.hours = hours;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }
}