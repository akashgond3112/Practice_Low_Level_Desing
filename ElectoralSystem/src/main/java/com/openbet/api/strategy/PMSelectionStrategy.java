package com.openbet.api.strategy;

import com.openbet.api.model.Candidate;
import com.openbet.api.model.Country;
import com.openbet.api.model.Party;

public interface PMSelectionStrategy {

    Candidate getPMCandidate(Country country , Party party);

    Candidate getPMCandidate(Country country);
}
