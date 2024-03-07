package org.unlogged.demo.models;

public class Vehicle {
    private long vehicleId;
    private String VIN;
    private String make;
    private String model;

    public Vehicle(long vehicleId, String VIN, String make, String model) {
        this.vehicleId = vehicleId;
        this.VIN = VIN;
        this.make = make;
        this.model = model;
    }

    public long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public static String getE()
    {
        return "e";
    }
}