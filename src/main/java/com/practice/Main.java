package com.practice;

import java.util.Random;
import java.util.UUID;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ParkingLot parkingLot = ParkingLot.getInstance();


        for(int i=0;i<120;i++){
            Vehicle vehicle = new Vehicle(UUID.randomUUID().toString(), VehicleType.TWO_WHEELER);
            parkingLot.parkVehicle(vehicle);
        }

    }
}