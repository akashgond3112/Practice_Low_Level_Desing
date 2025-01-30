package com.java.design.patterns.domain.Vehicle;


import static com.java.design.patterns.domain.Vehicle.VehicleSize.FOUR_VEHICLER_MEDIUM;

public class Car extends Vehicle {

    public Car(String plateNumber, VehicleType vehicleType) {
        super(FOUR_VEHICLER_MEDIUM, plateNumber, vehicleType);
    }
}
