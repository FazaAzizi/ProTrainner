package com.example.protrainner.model;

public class FTL {
    String noSesi;
    String goalTraining;
    String muscleGroup;
    String notes;

    public FTL() {
    }

    public FTL(String noSesi, String goalTraining, String muscleGroup, String notes) {
        this.noSesi = noSesi;
        this.goalTraining = goalTraining;
        this.muscleGroup = muscleGroup;
        this.notes = notes;
    }

    public String getNoSesi() {
        return noSesi;
    }

    public void setNoSesi(String noSesi) {
        this.noSesi = noSesi;
    }

    public String getGoalTraining() {
        return goalTraining;
    }

    public void setGoalTraining(String goalTraining) {
        this.goalTraining = goalTraining;
    }

    public String getMuscleGroup() {
        return muscleGroup;
    }

    public void setMuscleGroup(String muscleGroup) {
        this.muscleGroup = muscleGroup;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
