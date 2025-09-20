package com.practice;

import com.practice.ticket.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ParkingLot parkingLot = ParkingLot.getInstance();

        List<Vehicle> vehicles = new ArrayList<>();

        for(int i=0;i<120;i++){
            Vehicle vehicle = new Vehicle(UUID.randomUUID().toString(), VehicleType.TWO_WHEELER);
            if(parkingLot.parkVehicle(vehicle)){
                vehicles.add(vehicle);
                // Print ticket info after parking
                Ticket ticket = parkingLot.getTicket(vehicle);
                if (ticket != null) {
                    System.out.println("Ticket issued: " + ticket.TicketId + " for vehicle " + ticket.vehicle.getVehicleId());
                }
            }
        }
        for(Vehicle vehicle : vehicles){
            parkingLot.unparkVehicle(vehicle); // Ticket info will be printed automatically
        }

    }
}