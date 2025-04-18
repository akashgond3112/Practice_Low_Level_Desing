package com.java.lld.design.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
public abstract class Entity {
	private final String entityId;
	private String name;

	protected Entity(String name) {
		this.entityId = UUID.randomUUID().toString();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Entity{" + "entityId='" + entityId + '\'' + ", name='" + name + '\'' + '}';
	}
}
