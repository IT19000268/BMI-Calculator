package com.example.bmicalculator;

public class ExerciseJournal {
    String week;
    String hours;

    public ExerciseJournal() {
    }

    public ExerciseJournal(String week, String hours) {
        this.week = week;
        this.hours = hours;
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