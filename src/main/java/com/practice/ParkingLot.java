package com.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {

    Map<VehicleType, List<ParkingSlot>> parkingSlotsMap;

    public  ParkingLot(){
        parkingSlotsMap = new HashMap<>();
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
            truckSlots.add(new ParkingSlot(VehicleType.FOUR_WHEELER.name()+(i+1)));
        }
        parkingSlotsMap.put(VehicleType.TRUCK,truckSlots);
    }



}
