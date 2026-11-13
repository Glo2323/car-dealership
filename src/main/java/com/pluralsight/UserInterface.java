package com.pluralsight;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    Dealership dealership;

    public UserInterface() {

    }

    public void display(){
        init();

        boolean menuApp = true;
        while(menuApp){
            Scanner input = new Scanner(System.in);

            System.out.println("\n=== Car Dealership Menu ===");
            System.out.println("1 - Find vehicles by price");
            System.out.println("2 - Find vehicles by make/model");
            System.out.println("3 - Find vehicles by year range");
            System.out.println("4 - Find vehicles by color");
            System.out.println("5 - Find all vehicles by mileage");
            System.out.println("6 - Find vehicles by type");
            System.out.println("7 - List all vehicles");
            System.out.println("8 - Add a vehicle");
            System.out.println("9 - Remove a vehicle");
            System.out.println("10 - Sell/Lease a Vehicle");
            System.out.println("99 - Quit");
            System.out.print("Enter option: ");

            int option = input.nextInt();
            switch (option){
                case 1 -> processGetByPriceRequest();
                case 2 -> processGetByMakeAndModelRequest();
                case 3 -> processGetByYearRequest();
                case 4 -> processGetByColorRequest();
                case 5 -> processGetByMileageRequest();
                case 6 -> processGetByTypeRequest();
                case 7 -> processGetAllVehiclesRequest();
                case 99 -> menuApp = false;

            }






        }
    }


    private void init() {
        DealershipFileManager dealership = new DealershipFileManager();

        this.dealership = dealership.getDealership();

    }

    private void displayVehicles(ArrayList<Vehicle> vehicles) {
        //*Loop over the list and print it to the screen
        for (Vehicle vehicle : vehicles) {
            System.out.printf(vehicle.toString());
        }


    }
    //!Creating a method for the user to be able to search by price
    public void processGetByPriceRequest(){
        Scanner input = new Scanner(System.in);

        //*Asking the user the min price
        System.out.println("Enter the minimum price for a vehicle:");
        //*Catching the answer
       BigDecimal minPrice = input.nextBigDecimal();
        //*Asking the user the max price
        System.out.println("Enter the maximum price for a vehicle:");
        //*Catching the answer
        BigDecimal maxPrice = input.nextBigDecimal();

        displayVehicles(dealership.getVehiclesByPrice(minPrice, maxPrice));
    }
    //!Creating a method for the user to be able to search by make and model
    public void processGetByMakeAndModelRequest(){
        Scanner input = new Scanner(System.in);
        //*eating the line
        input.nextLine();

        //*Asking the user for the make
        System.out.println("Enter the make:");
        //*Catching the answer
        String make = input.next();
        //*Asking the user for the model
        System.out.println("Enter the model:");
        //*Catching the answer
        String model = input.next();

        displayVehicles(dealership.getVehiclesByMakeModel(make, model));
    }

    //!Creating a method for the user to be able to search by year
    public void processGetByYearRequest(){
        Scanner input = new Scanner(System.in);

        //*Asking the user for a starting year
        System.out.println("Enter the start date:");
        //*Catching the answer
        int startDate = input.nextInt();

        //*Asking the user for the end year
        System.out.println("Enter the end date:");
        //*Catching the answer
        int endDate = input.nextInt();

        displayVehicles(dealership.getVehiclesByYear(startDate, endDate));
    }

    //!Creating a method for the user to be able to search by Color
    public void processGetByColorRequest(){
       Scanner input = new Scanner(System.in);
       //*eating the line
       input.nextLine();

        //*ask the user the color
        System.out.println(" Enter the color of the vehicle you are searching for:");
        //*Catching the answer
        String color = input.nextLine();

        displayVehicles(dealership.getVehiclesByColor(color));

    }

    //!Creating a method for the user to be able to search by mileage
    public void processGetByMileageRequest(){
        Scanner input = new Scanner(System.in);
        //*Asking the user for the min mileage
        System.out.println("Enter the minimum mileage for a vehicle:");
         //*Catching the answer
        int minMileage = input.nextInt();
        //*Asking the user for the max mileage
        System.out.println("Enter the maximum mileage for a vehicle:");
        //*Catching the answer
        int maxiMileage = input.nextInt();

        displayVehicles(dealership.getVehiclesByMileage(minMileage, maxiMileage));
    }

    //!Creating a method for the user to be able to search by type
    public void processGetByTypeRequest(){
        Scanner input = new Scanner(System.in);
        //*eating the line
        input.nextLine();

        //*Asking the user for the type
        System.out.println("Enter the vehicle type:");
        //*Catching the answer
        String vehicleType = input.nextLine();

        displayVehicles(dealership.getVehiclesByVehicleType(vehicleType));
    }

    public void processGetAllVehiclesRequest(){

        displayVehicles(dealership.getAllVehicles());

    }



}
