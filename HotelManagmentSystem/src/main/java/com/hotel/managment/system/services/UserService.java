package com.hotel.managment.system.services;

import com.hotel.managment.system.models.Employee;
import com.hotel.managment.system.models.User;
import com.hotel.managment.system.enums.UserStatus;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    Map<String, User> customerDatabase = new HashMap<>();

    Map<String, Employee> employeeDatabase = new HashMap<>();

    public UserStatus validateUserDetails(String userId){
        return UserStatus.NEW_USER;
    }
}
