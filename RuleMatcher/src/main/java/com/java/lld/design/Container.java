package com.java.lld.design;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class Container {
	private List<Container> childContainers;
    @Setter
	private List<Item> items;

}