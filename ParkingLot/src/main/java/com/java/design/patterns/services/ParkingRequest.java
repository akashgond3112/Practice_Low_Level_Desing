package com.java.design.patterns.services;

import com.java.design.patterns.domain.Parking.ParkingType;
import com.java.design.patterns.domain.Vehicle.Vehicle;
import java.time.Instant;

public class ParkingRequest {
    Vehicle vehicle;
    Instant time;
    ParkingType parkingNeeds;
    RequestType requestType;
}
