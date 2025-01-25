package com.flight.tracking.system;

import java.util.List;

import static com.flight.tracking.system.SearchCriteria.ARRIVAL_TIME;


public class TrackByArrivalTime implements TrackingSystem{

    @Override
    public List<Flight> search(SearchCriteria searchCriteria) {
        return null;
    }

    @Override
    public SearchCriteria searchAttribute() {
        return ARRIVAL_TIME;
    }
}
