package com.example.bmicalculator.Models;

public class Weight {

    private  String InititalWeight,Finalweight,LossWeight,WeightID;


    public Weight() {

    }

    public Weight(String inititalWeight, String finalweight, String lossWeight, String weightID) {
        InititalWeight = inititalWeight;
        Finalweight = finalweight;
        LossWeight = lossWeight;
        WeightID = weightID;
    }

    public String getInititalWeight() {
        return InititalWeight;
    }

    public void setInititalWeight(String inititalWeight) {
        InititalWeight = inititalWeight;
    }

    public String getFinalweight() {
        return Finalweight;
    }

    public void setFinalweight(String finalweight) {
        Finalweight = finalweight;
    }

    public String getLossWeight() {
        return LossWeight;
    }

    public void setLossWeight(String lossWeight) {
        LossWeight = lossWeight;
    }

    public String getWeightID() {
        return WeightID;
    }

    public void setWeightID(String weightID) {
        WeightID = weightID;
    }
}
