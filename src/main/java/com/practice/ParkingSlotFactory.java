package com.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Factory for creating ParkingSlot objects.
 */
public class ParkingSlotFactory {
    public static List<ParkingSlot> createSlots(VehicleType type, int count) {
        List<ParkingSlot> slots = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            slots.add(new ParkingSlot(type.name() + (i + 1)));
        }
        return slots;
    }
}

