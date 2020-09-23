package com.example.bmicalculator;

public class ExerciseJournal {
    private Integer weekNumber;
    private Integer workoutTime;
    private Float initialWeight;
    private Float newWeight;
    private Float weightLoss;

    public ExerciseJournal() {
    }

    public Integer getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(Integer weekNumber) {
        this.weekNumber = weekNumber;
    }

    public Integer getWorkoutTime() {
        return workoutTime;
    }

    public void setWorkoutTime(Integer workoutTime) {
        this.workoutTime = workoutTime;
    }

    public Float getInitialWeight() {
        return initialWeight;
    }

    public void setInitialWeight(Float initialWeight) {
        this.initialWeight = initialWeight;
    }

    public Float getNewWeight() {
        return newWeight;
    }

    public void setNewWeight(Float newWeight) {
        this.newWeight = newWeight;
    }

    public float getWeightLoss() {
        return weightLoss;
    }

    public void setWeightLoss(float weightLoss) {
        this.weightLoss = weightLoss;
    }
}
