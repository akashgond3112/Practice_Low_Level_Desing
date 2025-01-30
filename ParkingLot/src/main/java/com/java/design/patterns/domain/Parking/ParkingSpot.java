package com.java.design.patterns.domain.Parking;


import com.java.design.patterns.domain.Vehicle.Vehicle;

import static com.java.design.patterns.domain.Parking.ParkingStatus.FREE;

public class ParkingSpot {
    ParkingSize parkingSize;
    ParkingType parkingType;
    int spotNumber;
    ParkingStatus parkingStatus = FREE;
    Vehicle vehicle;

    public ParkingSpot(ParkingSize parkingSize, ParkingType parkingType, int spotNumber) {
        this.parkingSize = parkingSize;
        this.parkingType = parkingType;
        this.spotNumber = spotNumber;
    }
}
