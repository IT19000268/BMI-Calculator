package com.example.bmicalculator;

public class DietNew {
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

    public DietNew(String initialCalories, String finalCalories, String gainedCalories) {
        InitialCalories = initialCalories;
        FinalCalories = finalCalories;
        GainedCalories = gainedCalories;

    }

    public DietNew() {

    }
}
