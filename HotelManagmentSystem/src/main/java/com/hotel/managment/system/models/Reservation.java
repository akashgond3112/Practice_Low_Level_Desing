package com.hotel.managment.system.models;

import com.hotel.managment.system.enums.ReservationStatus;

import java.time.Instant;

public class Reservation {
    Instant fromDate;
    Instant toDate;
    int numberOfPerson;
    ReservationStatus reservationStatus;
}
