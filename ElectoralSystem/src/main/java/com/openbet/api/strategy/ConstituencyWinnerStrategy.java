package com.openbet.api.strategy;

import com.openbet.api.model.Party;

import java.util.List;

public interface ConstituencyWinnerStrategy {
    public Party getWinner(List<Party> parties);
}
