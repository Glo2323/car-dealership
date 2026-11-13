package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;

public class DealershipFileManager {

    private String csvFile = "inventory.csv";

    public Dealership getDealership(){

        //?Creating the dealership variable
        Dealership dealership = null;

        //?Creating my try to catch any errors
        //*Creating a reader to read the files
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile));){
            //*Creating a reader to read the files

            //*Read the first line
            String dealerShipInfo = reader.readLine();
            //*instantiate the dealership if  the dealerShipInfo was nt null
            if(dealerShipInfo != null){
                //*Splitting the dealership info into their own part
                String[] dealerShipParts = dealerShipInfo.split("\\|");
                String name = dealerShipParts[0];
                String address = dealerShipParts[1];
                String phone = dealerShipParts[2];

                dealership = new Dealership(name, address, phone);
            }

            String vehicleLine;
            //?Looping over the file to get the vehicle info
            while ((vehicleLine = reader.readLine()) != null) {
                //*Splitting the vehicle info into there own part
                String[] vehicleParts = vehicleLine.split("\\|");
                int vin = Integer.parseInt(vehicleParts[0]);
                int year = Integer.parseInt(vehicleParts[1]);
                String make = vehicleParts[2];
                String model = vehicleParts[3];
                String type = vehicleParts[4];
                String color = vehicleParts[5];
                int odometer = Integer.parseInt(vehicleParts[6]);
                BigDecimal price = new BigDecimal(vehicleParts[7]);

                //*Creating the vehicle with the  parts
                Vehicle newVehicle = new Vehicle(vin , year,make, model, type, color, odometer, price);
                //*adding the vehicle to the inventory
                dealership.addVehicle(newVehicle);

            }




        }
        catch (Exception e){

            System.out.println("Error " + e.getMessage());

        }






    return dealership;

    }
}
