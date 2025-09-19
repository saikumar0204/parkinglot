package com.practice;

public class ParkingSlot {
    String parkingSlotId;
    Vehicle vehicle = null;
    boolean isAvailable = true;
    long startTime;

    public ParkingSlot(String parkingSlotId) {
        this.parkingSlotId = parkingSlotId;
        this.vehicle = null;
        this.isAvailable = true;
    }
    public boolean parkVehicle(Vehicle vehicle){
        if(isAvailable) {
            this.vehicle = vehicle;
            this.startTime = System.currentTimeMillis();
            isAvailable = false;
            System.out.println(String.format("Parked Vehicle %s at ParkingSlot:%s ", vehicle.getVehicleId(),this.parkingSlotId));
            return true;
        }
        return false;
    }

    public  boolean unParkVehicle(){
        if(isAvailable){
            System.out.println(String.format("Parking Slot is available already"));
            return  true;
        }
        printTicket();
        isAvailable = true;
        this.vehicle =null;
        this.startTime = System.currentTimeMillis();
        return true;
    }

    public void printTicket(){
        System.out.println(String.format("Vehicle id: %s parked from %d to %d", vehicle.getVehicleId(),startTime,System.currentTimeMillis()));
    }

}
