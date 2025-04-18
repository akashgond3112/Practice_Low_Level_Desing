package com.java.lld.design.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Getter
public class BoardList extends Entity {
    private List<Card> cardList;

    public BoardList(String name) {
        super(name);
        this.cardList = new ArrayList<>();
    }

    public void addCard(Card card) {
        this.cardList.add(card);
    }

	public void removeCard(String cardId) {
        this.cardList = cardList.stream().filter(card -> !card.getEntityId().equals(cardId)).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return super.toString() +" BoardList{" +
                "cardList=" + cardList +
                '}';
    }
}
