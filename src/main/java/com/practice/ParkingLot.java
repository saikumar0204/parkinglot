package com.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Singleton class representing the Parking Lot.
 * Manages parking slots and vehicle-slot mapping.
 */
public class ParkingLot {
    private static ParkingLot instance;
    Map<VehicleType, List<ParkingSlot>> parkingSlotsMap;
    Map<Vehicle, ParkingSlot> vehicleSlotMap;
    SlotAllocationStrategy slotAllocationStrategy;

    /**
     * Private constructor for Singleton pattern.
     */
    private ParkingLot() {
        parkingSlotsMap = new HashMap<>();
        vehicleSlotMap = new HashMap<>();
        slotAllocationStrategy = new DefaultSlotAllocationStrategy();
        List<ParkingSlot> slots = ParkingSlotFactory.createSlots(VehicleType.TWO_WHEELER, 100);
        parkingSlotsMap.put(VehicleType.TWO_WHEELER, slots);
        List<ParkingSlot> fourWheelerSlots = ParkingSlotFactory.createSlots(VehicleType.FOUR_WHEELER, 100);
        parkingSlotsMap.put(VehicleType.FOUR_WHEELER, fourWheelerSlots);
        List<ParkingSlot> truckSlots = ParkingSlotFactory.createSlots(VehicleType.TRUCK, 100);
        parkingSlotsMap.put(VehicleType.TRUCK, truckSlots);
    }

    /**
     * Returns the singleton instance of ParkingLot.
     */
    public static ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }

    /**
     * Parks a vehicle using the slot allocation strategy.
     * @param vehicle Vehicle to park
     * @return true if parked, false otherwise
     */
    public boolean parkVehicle(Vehicle vehicle) {
        List<ParkingSlot> slots = parkingSlotsMap.get(vehicle.getVehicleType());
        ParkingSlot slot = slotAllocationStrategy.allocateSlot(slots);
        if (slot != null && slot.isAvailable) {
            boolean isParked = slot.parkVehicle(vehicle);
            if (isParked) {
                vehicleSlotMap.put(vehicle, slot);
                return true;
            }
        }
        System.out.println(String.format("No more slots available for %s", vehicle.getVehicleType()));
        return false;
    }

    /**
     * Unparks a vehicle.
     * @param vehicle Vehicle to unpark
     * @return true if unparked, false otherwise
     */
    public boolean unparkVehicle(Vehicle vehicle) {
        ParkingSlot slot = vehicleSlotMap.get(vehicle);
        if (slot == null) {
            System.out.println(String.format("This vehicle is not yet parked: %s", vehicle.getVehicleType()));
            return false;
        }
        slot.unParkVehicle();
        vehicleSlotMap.remove(vehicle);
        return true;
    }

    /**
     * Sets a custom slot allocation strategy.
     */
    public void setSlotAllocationStrategy(SlotAllocationStrategy strategy) {
        this.slotAllocationStrategy = strategy;
    }
}
