package com.practice;

import java.util.List;

/**
 * Strategy interface for slot allocation.
 */
public interface SlotAllocationStrategy {
    ParkingSlot allocateSlot(List<ParkingSlot> slots);
}

