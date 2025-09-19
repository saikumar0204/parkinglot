# Parking Lot System

## Overview
A modular and extensible Parking Lot system implemented in Java. It supports multiple vehicle types, slot allocation strategies, and tracks which vehicle is parked in which slot. The design follows best practices and several key design patterns.

## Features
- Park and unpark vehicles
- Multiple vehicle types (two-wheeler, four-wheeler, truck)
- Slot allocation strategies (Strategy pattern)
- Singleton ParkingLot manager
- Factory for slot creation
- Easy extensibility for new features

## Design Patterns Used
- **Singleton**: Ensures only one ParkingLot instance manages the system.
- **Factory**: Used for creating ParkingSlot objects (`ParkingSlotFactory`).
- **Strategy**: Slot allocation logic is pluggable (`SlotAllocationStrategy`).
- **Registry/Map**: Tracks which vehicle is parked in which slot.

## How to Run
1. Clone the repository.
2. Build the project using Maven:
   ```
   mvn clean install
   ```
3. Run the main class:
   ```
   java -cp target/classes com.practice.Main
   ```

## Example Usage
```java
ParkingLot lot = ParkingLot.getInstance();
Vehicle v1 = new Vehicle("KA01AB1234", VehicleType.FOUR_WHEELER);
lot.parkVehicle(v1);
lot.unparkVehicle(v1);
```

## Extending the System
- To add a new slot allocation strategy, implement `SlotAllocationStrategy` and set it using `setSlotAllocationStrategy()`.
- To add new vehicle types, update `VehicleType` enum and slot creation logic.

## License
MIT

