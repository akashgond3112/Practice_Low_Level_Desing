package com.elevator.service;


import com.elevator.model.SwitchDirection;

public interface IFloorSwitchService {
    void pressSwitch(SwitchDirection switchDirection);
}
