package com.example.formulaone.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Constructor {

    private SimpleStringProperty name;
    private SimpleStringProperty country;
    private int racesEntered;
    private int racesStarted;
    private int drivers;
    private int totalEntries;
    private int wins;
    private int points;
    private int poles;
    private int fastestLaps;
    private int podiums;
    private int wcc;
    private int wdc;

    public Constructor() {
    }
    public Constructor(String name, String country, int racesEntered, int racesStarted, int drivers, int totalEntries, int wins, int points, int poles, int fastestLaps, int podiums, int wcc, int wdc) {
        this.name = new SimpleStringProperty(name);
        this.country = new SimpleStringProperty(country);
        this.racesEntered = racesEntered;
        this.racesStarted = racesStarted;
        this.drivers = drivers;
        this.totalEntries = totalEntries;
        this.wins = wins;
        this.points = points;
        this.poles = poles;
        this.fastestLaps = fastestLaps;
        this.podiums = podiums;
        this.wcc = wcc;
        this.wdc = wdc;
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
    public int getRacesEntered() {
        return racesEntered;
    }
    public void setRacesEntered(int racesEntered) {
        this.racesEntered = racesEntered;
    }
    public int getRacesStarted() {
        return racesStarted;
    }
    public void setRacesStarted(int racesStarted) {
        this.racesStarted = racesStarted;
    }
    public int getDrivers() {
        return drivers;
    }
    public void setDrivers(int drivers) {
        this.drivers = drivers;
    }
    public int getTotalEntries() {
        return totalEntries;
    }
    public void setTotalEntries(int totalEntries) {
        this.totalEntries = totalEntries;
    }
    public int getWins() {
        return wins;
    }
    public void setWins(int wins) {
        this.wins = wins;
    }
    public int getPoints() {
        return points;
    }
    public void setPoints(int points) {
        this.points = points;
    }
    public int getPoles() {
        return poles;
    }
    public void setPoles(int poles) {
        this.poles = poles;
    }
    public int getFastestLaps() {
        return fastestLaps;
    }
    public void setFastestLaps(int fastestLaps) {
        this.fastestLaps = fastestLaps;
    }
    public int getPodiums() {
        return podiums;
    }
    public void setPodiums(int podiums) {
        this.podiums = podiums;
    }
    public int getWcc() {
        return wcc;
    }
    public void setWcc(int wcc) {
        this.wcc = wcc;
    }
    public int getWdc() {
        return wdc;
    }
    public void setWdc(int wdc) {
        this.wdc = wdc;
    }
}
