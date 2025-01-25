package com.flight.tracking.system;

import java.util.List;

// This class fulfills 3 API contract
public interface TrackingSystem {

    public List<Flight> search(SearchCriteria searchCriteria);

    public SearchCriteria searchAttribute();
}
