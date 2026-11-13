package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        //?create the dealership with no inventory
        this.inventory = new ArrayList<>();
    }
    //!Creating a method to add vehicles to the inventory
    public void addVehicle(Vehicle vehicle) {
        this.inventory.add(vehicle);
    }
    //
    public ArrayList<Vehicle> getAllVehicles() {
        return this.inventory;
    }

    public void removeVehicle(Vehicle vehicle) {
        this.inventory.remove(vehicle);
    }

    public ArrayList<Vehicle> getVehiclesByPrice(BigDecimal min, BigDecimal max) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle vehicle : this.inventory) {

        }
        return vehicles;

    }


    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle vehicle : this.inventory) {
            if (vehicle.getMake().equals(make) && vehicle.getModel().equals(model)) {
                ;
            }
        }
        return vehicles;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int min, int max) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle vehicle : this.inventory) {
            if (min <= vehicle.getYear() && max >= vehicle.getYear()) {

            }
        }
        return vehicles;
    }

    public ArrayList<Vehicle> getVehiclesByColor(String color) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle vehicle : this.inventory) {
            if (vehicle.getColor().equals(color)) {

            }
        }
        return vehicles;
    }

    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle vehicle : this.inventory) {


        }
        return vehicles;
    }

    public ArrayList<Vehicle> getVehiclesByVehicle(String type) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for (Vehicle vehicle : this.inventory) {
            if (vehicle.getVehicleType().equals(type)) {

            }
        }
        return vehicles;
    }
}
