package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.Scanner;

public class DealershipFileManager {

    private String csvFile = "inventory.csv";

    public Dealership getDealership(){

        //?Creating the dealership variable
        Dealership dealerShip = null;

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

                dealerShip = new Dealership(name, address, phone);
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
                dealerShip.addVehicle(newVehicle);

            }




        }
        catch (Exception e){

            System.out.println("Error " + e.getMessage());

        }






    return dealerShip;

    }

    public Dealership saveDealership(Dealership dealerShip){

        //?Creating a Scanner
       Scanner input = new Scanner(System.in);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))){

            //*Asking question to save the vehicle info

            //*Asking for a vin
            System.out.println("What's your Vehicle Vin:");
            //*Catching users answer
            int vin = input.nextInt();

            //*Asking for the year
            System.out.println("What's your Vehicle Year:");
            //*Catching the users answer
            int year = input.nextInt();

            //*Asking for the make
            System.out.println("What's your Vehicle Make:");
            //*Catching the users answer
            String make = input.next();

            //*asking for the model
            System.out.println("What's your Vehicle Model:");
            //*Catching the  users answer
            String model = input.next();

            //*Asking the type of vehicle
            System.out.println("What's your Vehicle Type:");
            //*Catching the users answer
            String type = input.next();

            //*Asking for the color
            System.out.println("What's your Vehicle Color:");
            //*Catching the  users answer
            String color = input.next();

            //*Asking for the odometer
            System.out.println("What's your Vehicle Odometer:");
            //*Catching the users answer
            int odometer = input.nextInt();

            //*Asking for the price
            System.out.println("What's your Vehicle Price:");
            //*Catching the answer
            BigDecimal price = new BigDecimal(input.next());

            //?Formatting the info to display on the csv
            String formattedLine = String.format("%d|%d|%s|%s|%s|%s|%d|%f", vin, year, make, model, type, color, odometer, price);

            //*Writing the info onto the csv in the formatted way
            writer.write(formattedLine);


            //?Closing the writer
            writer.close();


        } catch (Exception e) {

            System.out.println("Error " + e.getMessage());
        }

        return dealerShip;
    }
}
