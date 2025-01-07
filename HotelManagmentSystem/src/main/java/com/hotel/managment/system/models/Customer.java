package com.hotel.managment.system.models;

import com.hotel.managment.system.enums.Channel;

public class Customer extends User {
    public Customer() {
        channel = Channel.ONLINE;
    }
}
