package com.openbet.api.service;

import com.openbet.api.exceptions.CandidateDuplicateEntryException;
import com.openbet.api.exceptions.ConstituencyExistsException;
import com.openbet.api.exceptions.NotExistsException;
import com.openbet.api.exceptions.PartyAlreadyExistsException;
import com.openbet.api.model.Candidate;
import com.openbet.api.model.Constituency;
import com.openbet.api.model.Country;
import com.openbet.api.model.Party;

public class CountryElectionSystemImpl implements CountryElectionSystem{
    Country country;
    public CountryElectionSystemImpl(Country country){
        this.country = country;
    }

    @Override
    public void addCandidate(Candidate candidate, Party party, Constituency constituency) throws
            CandidateDuplicateEntryException, NotExistsException {
        if(country.isExists(party , constituency)){
            this.country.addCandidate(candidate ,party , constituency);
        }
        else{
            throw new NotExistsException("party and constituency : "+ party.getPartyName() +" "+ constituency.getName());
        }
    }
    @Override
    public void addConstituency(Constituency constituency) throws ConstituencyExistsException {
        this.country.addConstituency(constituency);
    }

    @Override
    public void addParty(Party party)  throws PartyAlreadyExistsException {
        this.country.addParty(party);
    }

    @Override
    public void addPartyGivenConstituency(Party party, Constituency constituency) throws PartyAlreadyExistsException, NotExistsException {
        this.country.addParty(party, constituency);
    }

    @Override
    public void displayPartyWiseVoteShare(Constituency constituency) {
        this.country.displayPartyWiseShare(constituency);
    }

    @Override
    public void displayPartyWiseVoteShare(Country country) {
        this.country.displayPartyWiseVoteShare();
    }

    @Override
    public Double displayVoteShareInConstituency(Candidate candidate) {
        return this.country.getVotesShare(candidate);
    }

    @Override
    public Candidate findPM() {
        return country.findPM();
    }

    @Override
    public Party getWinnerParty(Constituency constituency) {
        return this.country.getWinner(constituency);
    }

    @Override
    public Candidate getMaxVotesInConstituency(Constituency constituency) {
        return null;
    }
}
