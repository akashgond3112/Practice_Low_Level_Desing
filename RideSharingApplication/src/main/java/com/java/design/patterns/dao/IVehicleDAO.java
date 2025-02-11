package com.java.design.patterns.dao;


import com.java.design.patterns.model.Vehicle;

public interface IVehicleDAO {
    Vehicle addVehicle(String name, String vehicleNumber);
    Vehicle getVehicle(String vehicleNumber);
}
