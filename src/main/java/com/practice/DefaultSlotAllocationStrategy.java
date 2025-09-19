package com.practice;

import java.util.List;

/**
 * Default slot allocation strategy: picks the first available slot.
 */
public class DefaultSlotAllocationStrategy implements SlotAllocationStrategy {
    @Override
    public ParkingSlot allocateSlot(List<ParkingSlot> slots) {
        for (ParkingSlot slot : slots) {
            if (slot.isAvailable) {
                return slot;
            }
        }
        return null;
    }
}

