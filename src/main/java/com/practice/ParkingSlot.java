package com.practice;

public class ParkingSlot {
    String parkingSlotId;
    Vehicle vehicle = null;
    boolean isAvaiable = true;
    long startTime;

    public ParkingSlot(String parkingSlotId) {
        this.parkingSlotId = parkingSlotId;
        this.vehicle = null;
        this.isAvaiable = true;
    }
    public boolean parkVehicle(Vehicle vehicle){
        if(isAvaiable) {
            this.vehicle = vehicle;
            this.startTime = System.currentTimeMillis();
            isAvaiable = false;
            return true;
        }
        return false;
    }

    public  boolean unParkVehicle(Vehicle vehicle){
        if(isAvaiable){
            System.out.println(String.format("Parking Slot is avialble already"));
            return  true;
        }
        printTicket();
        isAvaiable = true;
        this.vehicle =null;
        this.startTime = System.currentTimeMillis();
        return true;
    }

    public void printTicket(){
        System.out.println(String.format("Vehicle id: %s parked from %d to %d", vehicle.getVehicleId(),startTime,System.currentTimeMillis()));
    }

}

