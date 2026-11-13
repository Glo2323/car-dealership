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
        ArrayList<Vehicle> vehiclesByPrice = new ArrayList<>();
        for (Vehicle vehicle : this.inventory) {
            if (vehicle.getPrice().compareTo(min) >= 0 && vehicle.getPrice().compareTo(max) <= 0) {
                vehiclesByPrice.add(vehicle);
            }

        }
        return vehiclesByPrice;

    }


    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {
        ArrayList<Vehicle> vehiclesByMakeModel = new ArrayList<>();
        for (Vehicle vehicle : this.inventory) {
            if (vehicle.getMake().equals(make) && vehicle.getModel().equals(model)) {
                vehiclesByMakeModel.add(vehicle);
            }
        }
        return vehiclesByMakeModel;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int min, int max) {
        ArrayList<Vehicle> vehiclesByYear = new ArrayList<>();
        for (Vehicle vehicle : this.inventory) {
            if (min <= vehicle.getYear() && max >= vehicle.getYear()) {
                vehiclesByYear.add(vehicle);
            }
        }
        return vehiclesByYear;
    }

    public ArrayList<Vehicle> getVehiclesByColor(String color) {
        ArrayList<Vehicle> colorVehicles = new ArrayList<>();
        for (Vehicle vehicle : this.inventory) {
            if (vehicle.getColor().equals(color)) {
                colorVehicles.add(vehicle);
            }
        }
        return colorVehicles;
    }

    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max) {
        ArrayList<Vehicle> mileageVehicles = new ArrayList<>();
        for (Vehicle vehicle : this.inventory) {
            if (min <= vehicle.getOdometer() && max >= vehicle.getOdometer()) {
                mileageVehicles.add(vehicle);
            }

        }
        return  mileageVehicles;
    }

    public ArrayList<Vehicle> getVehiclesByVehicleType(String type) {
        ArrayList<Vehicle> typeVehicles = new ArrayList<>();
        for (Vehicle vehicle : this.inventory) {
            if (vehicle.getVehicleType().equals(type)) {
                typeVehicles.add(vehicle);
            }
        }
        return typeVehicles;
    }
}
