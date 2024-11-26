package com.openbet.api.service;

import com.openbet.api.exceptions.CandidateDuplicateEntryException;
import com.openbet.api.exceptions.ConstituencyExistsException;
import com.openbet.api.exceptions.NotExistsException;
import com.openbet.api.exceptions.PartyAlreadyExistsException;
import com.openbet.api.model.Candidate;
import com.openbet.api.model.Constituency;
import com.openbet.api.model.Country;
import com.openbet.api.model.Party;

import java.util.*;

public interface CountryElectionSystem {
    void addCandidate(Candidate candidate , Party party , Constituency constituency) throws
            CandidateDuplicateEntryException, NotExistsException;
    void addConstituency(Constituency constituency) throws ConstituencyExistsException;
    void addParty(Party party) throws PartyAlreadyExistsException;
    void addPartyGivenConstituency(Party party , Constituency constituency) throws PartyAlreadyExistsException, NotExistsException;
    void displayPartyWiseVoteShare(Constituency constituency);
    void displayPartyWiseVoteShare(Country country);
    Double displayVoteShareInConstituency(Candidate candidate);


    Candidate findPM();
    Party getWinnerParty(Constituency constituency);

    //Utility functions
    Candidate getMaxVotesInConstituency(Constituency constituency);
}
