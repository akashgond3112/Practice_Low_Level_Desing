package com.java.design.patterns.services;


import com.java.design.patterns.domain.Parking.ParkingSpot;

import java.util.List;

public interface ParkingClient {

    // parking catalogue request
    public List<ParkingSpot> request(ParkingRequest parkingRequest);

    // Park request
    public ParkingSpot action(ParkingRequest parkingRequest);


}
