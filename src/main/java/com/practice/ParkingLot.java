package com.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {

    Map<VehicleType, List<ParkingSlot>> parkingSlotsMap;
    Map<Vehicle, ParkingSlot> vehicleSlotMap;

    public  ParkingLot(){
        parkingSlotsMap = new HashMap<>();
        vehicleSlotMap = new HashMap<>();
        List<ParkingSlot> slots= new ArrayList<>();
        for(int i=0;i<100;i++){
            slots.add(new ParkingSlot(VehicleType.TWO_WHEELER.name()+(i+1)));
        }
        parkingSlotsMap.put(VehicleType.TWO_WHEELER,slots);
        List<ParkingSlot> fourWheelerSlots= new ArrayList<>();
        for(int i=0;i<100;i++){
            fourWheelerSlots.add(new ParkingSlot(VehicleType.FOUR_WHEELER.name()+(i+1)));
        }
        parkingSlotsMap.put(VehicleType.FOUR_WHEELER,fourWheelerSlots);
        List<ParkingSlot> truckSlots= new ArrayList<>();
        for(int i=0;i<100;i++){
            truckSlots.add(new ParkingSlot(VehicleType.TRUCK.name()+(i+1)));
        }
        parkingSlotsMap.put(VehicleType.TRUCK,truckSlots);
    }

    public boolean parkVehicle(Vehicle vehicle){
        List<ParkingSlot> slots = parkingSlotsMap.get(vehicle.getVehicleType());
        for(ParkingSlot slot: slots){
            if(slot.isAvailable){
                boolean isParked = slot.parkVehicle(vehicle);
                if(isParked){
                    vehicleSlotMap.put(vehicle,slot);
                }
                return true;
            }
        }
        System.out.println(String.format("No more slots available for %s",vehicle.getVehicleType()));
        return  false;
    }

    public  boolean unParkVehicle(Vehicle vehicle){
        ParkingSlot slot = vehicleSlotMap.get(vehicle);
        if(slot == null){
            System.out.println(String.format("this vehicle is not yet parked: %s", vehicle.getVehicleType()));
            return true;
        }
        slot.unParkVehicle();
        vehicleSlotMap.remove(vehicle);
        return true;
    }



}
