package com.java.design.patterns.domain.Vehicle;


import static com.java.design.patterns.domain.Vehicle.VehicleSize.TWO_VEHICLER;

public class Scooter extends Vehicle {
    public Scooter(String plateNumber, VehicleType vehicleType) {
        super(TWO_VEHICLER, plateNumber, vehicleType);
    }
}
