package com.example.formulaone.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Season {

    private String season;
    private double points;

    public Season() {
    }
    public Season(String season, double points) {
        this.season = season;
        this.points = points;
    }

    public String getSeason() {
        return season;
    }
    public void setSeason(String season) {
        this.season = season;
    }
    public double getPoints() {
        return points;
    }
    public void setPoints(double points) {
        this.points = points;
    }
}

