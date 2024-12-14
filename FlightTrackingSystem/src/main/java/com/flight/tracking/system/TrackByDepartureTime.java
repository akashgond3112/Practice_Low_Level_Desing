package com.flight.tracking.system;

import java.util.List;

import static com.flight.tracking.system.SearchCriteria.DEPARTURE_TIME;

public class TrackByDepartureTime implements TrackingSystem{

    @Override
    public List<Flight> search(SearchCriteria searchCriteria) {
        return null;
    }

    @Override
    public SearchCriteria searchAttribute() {
        return DEPARTURE_TIME;
    }
}
