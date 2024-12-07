package com.flight.tracking.system;

import com.flight.tracking.system.enums.SearchCriteria;

import java.util.List;

import static com.flight.tracking.system.enums.SearchCriteria.DEPARTURE_TIME;


public class TrackByDepartureTime implements TrackingSystem{

    @Override
    public List<Flight> search(SearchCriteria searchCretiera) {
        return null;
    }

    @Override
    public SearchCriteria searchAttribute() {
        return DEPARTURE_TIME;
    }
}
