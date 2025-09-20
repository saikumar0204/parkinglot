package com.practice.ticket;

import com.practice.ParkingSlot;
import com.practice.Vehicle;

public class Ticket {
    public String TicketId;
    public Vehicle vehicle;
    public ParkingSlot slot;
    public long startingTime;
    public long endTime;

    public Ticket(String ticketId, Vehicle vehicle, ParkingSlot slot, long startingTime) {
        TicketId = ticketId;
        this.vehicle = vehicle;
        this.slot = slot;
        this.startingTime = startingTime;
        System.out.println(String.format("Vehicle %s parked at slot: %s at time: %d",vehicle.getVehicleId(),this.slot.parkingSlotId,System.currentTimeMillis()));

    }

    public void printTicket(){
        this.endTime= System.currentTimeMillis();
        System.out.println(String.format("Vehicle %s parked from %d to %d",vehicle.getVehicleId(),this.startingTime,System.currentTimeMillis()));
    }

}
