package com.practice;

public class ParkingSlot {
    public String parkingSlotId;
    Vehicle vehicle = null;
    boolean isAvailable = true;

    public ParkingSlot(String parkingSlotId) {
        this.parkingSlotId = parkingSlotId;
        this.vehicle = null;
        this.isAvailable = true;
    }
    public boolean parkVehicle(Vehicle vehicle){
        if(isAvailable) {
            this.vehicle = vehicle;
            isAvailable = false;
            return true;
        }
        return false;
    }

    public boolean unParkVehicle(){
        if(isAvailable){
            System.out.println("Parking Slot is available already");
            return true;
        }
        isAvailable = true;
        this.vehicle = null;
        return true;
    }

}
