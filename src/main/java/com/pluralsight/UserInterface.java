package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    Dealership dealership;

    public UserInterface() {

    }

    public void display(){
        init();

        boolean appRunning = true;
        while(appRunning){
            Scanner input = new Scanner(System.in);






        }
    }


    private void init() {
        DealershipFileManager dealership = new DealershipFileManager();

        this.dealership = dealership.getDealership();

    }

    public void processGetAllVehiclesRequest(){

        displayVehicles(dealership.getAllVehicles());

    }

    public void processGetByColorRequest(){
       Scanner input = new Scanner(System.in);

        //*ask the user the color
        System.out.println(" Enter the color of the vehicle you are searching for :");
        String color = input.nextLine();

        displayVehicles(dealership.getVehiclesByColor(color));

    }



    private void displayVehicles(ArrayList<Vehicle> vehicles) {
        //*Loop over the list and print it to the screen
        for (Vehicle vehicle : vehicles) {
            System.out.println();
        }


    }

}
