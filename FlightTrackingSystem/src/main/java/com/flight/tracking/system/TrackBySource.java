package com.flight.tracking.system;

import java.util.List;

import static com.flight.tracking.system.SearchCriteria.SOURCE;

public class TrackBySource implements TrackingSystem{

    @Override
    public List<Flight> search(SearchCriteria searchCriteria) {
        return null;
    }

    @Override
    public SearchCriteria searchAttribute() {
        return SOURCE;
    }
}
