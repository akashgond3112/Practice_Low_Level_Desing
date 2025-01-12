package com.elevator.service;


import com.elevator.model.Elevator;

public interface CallElevatorStrategy {
    public Elevator getElevator(Elevator[] elevators, Integer currentFloor, Integer direction);
}
