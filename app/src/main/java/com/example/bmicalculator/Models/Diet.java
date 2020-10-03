package com.example.bmicalculator.Models;

public class Diet {

    private  String InitialCalories,FinalCalories,GainedCalories;


    public String getInitialCalories() {
        return InitialCalories;
    }

    public void setInitialCalories(String initialCalories) {
        InitialCalories = initialCalories;
    }

    public String getFinalCalories() {
        return FinalCalories;
    }

    public void setFinalCalories(String finalCalories) {
        FinalCalories = finalCalories;
    }

    public String getGainedCalories() {
        return GainedCalories;
    }

    public void setGainedCalories(String gainedCalories) {
        GainedCalories = gainedCalories;
    }

    public Diet(String initialCalories, String finalCalories, String gainedCalories) {
        InitialCalories = initialCalories;
        FinalCalories = finalCalories;
        GainedCalories = gainedCalories;

    }

    public Diet() {

    }





}

