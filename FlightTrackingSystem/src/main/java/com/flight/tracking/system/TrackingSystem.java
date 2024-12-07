package com.flight.tracking.system;

import com.flight.tracking.system.enums.SearchCriteria;

import java.util.List;

// This class fulfills 3 API contract
public interface TrackingSystem {

    public List<Flight> search(SearchCriteria searchCretiera);

    public SearchCriteria searchAttribute();
}
