package com.example.formulaone.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Driver {

    private SimpleStringProperty name;
    private SimpleStringProperty country;
    private int raceEntries;
    private int raceStarts;
    private int polePositions;
    private int raceWins;
    private int podiums;
    private int fastestLaps;
    private double points;

    public Driver() {
    }
    public Driver(String name, String country, int raceEntries, int raceStarts, int polePositions, int raceWins, int podiums, int fastestLaps, double points) {
        this.name = new SimpleStringProperty(name);
        this.country = new SimpleStringProperty(country);
        this.raceEntries = raceEntries;
        this.raceStarts = raceStarts;
        this.polePositions = polePositions;
        this.raceWins = raceWins;
        this.podiums = podiums;
        this.fastestLaps = fastestLaps;
        this.points = points;
    }

    public String getName() {
        return name.get();
    }
    public void setName(String name) {
        this.name.set(name);
    }
    public StringProperty nameProperty() {
        return name;
    }
    public String getCountry() {
        return country.get();
    }
    public void setCountry(String country) {
        this.country.set(country);
    }
    public StringProperty countryProperty() {
        return country;
    }
    public int getRaceEntries() {
        return raceEntries;
    }
    public void setRaceEntries(int raceEntries) {
        this.raceEntries = raceEntries;
    }
    public int getRaceStarts() {
        return raceStarts;
    }
    public void setRaceStarts(int raceStarts) {
        this.raceStarts = raceStarts;
    }
    public int getPolePositions() {
        return polePositions;
    }
    public void setPolePositions(int polePositions) {
        this.polePositions = polePositions;
    }
    public int getRaceWins() {
        return raceWins;
    }
    public void setRaceWins(int raceWins) {
        this.raceWins = raceWins;
    }
    public int getPodiums() {
        return podiums;
    }
    public void setPodiums(int podiums) {
        this.podiums = podiums;
    }
    public int getFastestLaps() {
        return fastestLaps;
    }
    public void setFastestLaps(int fastestLaps) {
        this.fastestLaps = fastestLaps;
    }
    public double getPoints() {
        return points;
    }
    public void setPoints(double points) {
        this.points = points;
    }
}

