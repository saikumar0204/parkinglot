package com.practice;

import com.practice.ticket.Ticket;
import java.util.UUID;
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
    Map<Vehicle, Ticket> vehicleTicketMap;
    SlotAllocationStrategy slotAllocationStrategy;

    /**
     * Private constructor for Singleton pattern.
     */
    private ParkingLot() {
        parkingSlotsMap = new HashMap<>();
        vehicleTicketMap = new HashMap<>();
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
     * Parks a vehicle using the slot allocation strategy and creates a ticket.
     * @param vehicle Vehicle to park
     * @return true if parked, false otherwise
     */
    public boolean parkVehicle(Vehicle vehicle) {
        List<ParkingSlot> slots = parkingSlotsMap.get(vehicle.getVehicleType());
        ParkingSlot slot = slotAllocationStrategy.allocateSlot(slots);
        if (slot != null && slot.isAvailable) {
            boolean isParked = slot.parkVehicle(vehicle);
            if (isParked) {
                Ticket ticket = new Ticket(UUID.randomUUID().toString(), vehicle, slot, System.currentTimeMillis());
                vehicleTicketMap.put(vehicle, ticket);
                return true;
            }
        }
        System.out.println(String.format("No more slots available for %s", vehicle.getVehicleType()));
        return false;
    }

    /**
     * Unparks a vehicle and closes the ticket.
     * @param vehicle Vehicle to unpark
     * @return true if unparked, false otherwise
     */
    public boolean unparkVehicle(Vehicle vehicle) {
        Ticket ticket = vehicleTicketMap.get(vehicle);
        if (ticket == null) {
            System.out.println(String.format("This vehicle is not yet parked: %s", vehicle.getVehicleType()));
            return false;
        }
        ParkingSlot slot = ticket.slot;
        slot.unParkVehicle();
        ticket.printTicket();
        vehicleTicketMap.remove(vehicle);
        return true;
    }

    /**
     * Gets the ticket for a parked vehicle.
     */
    public Ticket getTicket(Vehicle vehicle) {
        return vehicleTicketMap.get(vehicle);
    }

    /**
     * Sets a custom slot allocation strategy.
     */
    public void setSlotAllocationStrategy(SlotAllocationStrategy strategy) {
        this.slotAllocationStrategy = strategy;
    }
}
