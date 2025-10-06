package me.pieralini.com.model;

public class Vehicle {
    private String plate;
    private String uf;

    public String getPlate() { return plate; }
    public void setPlate(String plate) { this.plate = plate; }
    public String getUf() { return uf; }
    public void setUf(String uf) { this.uf = uf; }

    @Override
    public String toString() { return plate + " - " + uf; }
}
