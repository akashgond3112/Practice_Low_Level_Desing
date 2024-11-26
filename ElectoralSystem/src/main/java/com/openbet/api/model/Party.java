package com.openbet.api.model;


import com.openbet.api.strategy.HighestVotePercentageWins;
import com.openbet.api.strategy.PMSelectionStrategy;

import java.util.HashSet;
import java.util.Set;

public class Party implements Comparable<Party> {
    private String partyName;
    private Integer votes;
    private PMSelectionStrategy pmSelectionStrategy;

    public Party(String partyName) {
        this.partyName = partyName;
        this.votes = 0;
        this.pmSelectionStrategy = new HighestVotePercentageWins();
    }
    public String getPartyName() {
        return this.partyName;
    }
    public void addVotes(Integer votes){
        this.votes += votes;
    }
    public Integer getVotes() {
        return this.votes;
    }

    @Override
    public int compareTo(Party o) {
        return this.partyName.compareTo(o.getPartyName());
    }
}
