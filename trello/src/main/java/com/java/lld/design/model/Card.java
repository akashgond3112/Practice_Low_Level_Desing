package com.java.lld.design.model;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Card extends Entity {
    private String description;
    private String assignedTo;

    public Card(String name) {
        super(name);
    }

    public Card(String name, String assignedTo) {
        super(name);
        this.assignedTo = assignedTo;
    }

	@Override
    public String toString() {
        return super.toString() + " Card{" +
                "description='" + description + '\'' +
                ", assignedTo='" + assignedTo + '\'' +
                '}';
    }
}
