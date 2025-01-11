package com.hotel.managment.system.services;

import com.hotel.managment.system.models.AvailabilityRequest;
import com.hotel.managment.system.models.Reservation;
import com.hotel.managment.system.models.Room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AvailabilityService {

	Map<Integer, Reservation> roomToReservation = new HashMap<>();


	// for checking availability
	public List<Room> availableRooms(AvailabilityRequest availabilityRequest) {

		return new ArrayList<>();
	}
}
