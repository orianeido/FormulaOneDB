package com.example.formulaone.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GrandPrix {

    private SimpleStringProperty name;
    private SimpleStringProperty circuit;
    private SimpleStringProperty type;
    private SimpleStringProperty direction;
    private double length;
    private int eventAmount;
    private String url;


    public GrandPrix() {
    }
    public GrandPrix(String name, String circuit, String type, String direction, double length, int eventAmount) {
        this.name = new SimpleStringProperty(name);
        this.circuit = new SimpleStringProperty(circuit);
        this.type = new SimpleStringProperty(type);
        this.direction = new SimpleStringProperty(direction);
        this.length = length;
        this.eventAmount = eventAmount;
    }
    public GrandPrix(String name, String circuit, String type, String direction, double length, int eventAmount, String url) {
        this.name = new SimpleStringProperty(name);
        this.circuit = new SimpleStringProperty(circuit);
        this.type = new SimpleStringProperty(type);
        this.direction = new SimpleStringProperty(direction);
        this.length = length;
        this.eventAmount = eventAmount;
        this.url = url;
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
    public String getCircuit() {
        return circuit.get();
    }
    public void setCircuit(String circuit) {
        this.circuit.set(circuit);
    }
    public StringProperty circuitProperty() {
        return circuit;
    }
    public String getType() {
        return type.get();
    }
    public void setType(String type) {
        this.type.set(type);
    }
    public StringProperty typeProperty() {
        return type;
    }
    public String getDirection() {
        return direction.get();
    }
    public void setDirection(String direction) {
        this.direction.set(direction);
    }
    public StringProperty directionProperty() {
        return direction;
    }
    public double getLength() {
        return length;
    }
    public void setLength(double length) {
        this.length = length;
    }
    public int getEventAmount() {
        return eventAmount;
    }
    public void setEventAmount(int eventAmount) {
        this.eventAmount = eventAmount;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
}
