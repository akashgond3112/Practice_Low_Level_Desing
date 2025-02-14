package com.java.design.patterns.service;


import com.java.design.patterns.RideAlgorithm.RideManager;
import com.java.design.patterns.dao.IUserDAO;
import com.java.design.patterns.dao.IVehicleDAO;
import com.java.design.patterns.model.Ride;
import com.java.design.patterns.model.RideStatus;

public class RideService implements IRideService {
    private RideManager rideManager;
    private IUserDAO userDAO;
    private IVehicleDAO vehicleDAO;

    public RideService(){
        rideManager= new RideManager();
    }

    @Override
    public Ride offer_ride(String user, String source, String destination, int availableseats, String vehicle, String vehicleNumber) {
        Ride ride= new Ride(userDAO.getUser(user),source,destination,availableseats,vehicleDAO.getVehicle(vehicle),vehicleNumber);
        rideManager.addRide(ride, RideStatus.NotStarted);
        return ride;
    }

    @Override
    public Ride select_ride(String user, String source, String destination, int seats, String strategy) {
        return rideManager.getRide(source,destination,seats, strategy);
    }

    @Override
    public void end_ride(Ride ride) {
        rideManager.completeRide(ride);
    }
}
