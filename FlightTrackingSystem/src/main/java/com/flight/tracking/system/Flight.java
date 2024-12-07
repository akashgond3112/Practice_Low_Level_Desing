package com.flight.tracking.system;

import com.flight.tracking.system.enums.FlightStatus;

public class Flight {
    int id;
    FlightStatus flightStatus;
    Source source;
    Destination destination;
    Time takeOffTime;
    Time landingTime;
}
