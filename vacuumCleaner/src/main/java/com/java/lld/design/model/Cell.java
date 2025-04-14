package com.java.lld.design.model;

import com.java.lld.design.enums.DirectionEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Cell {

	// x coordinate
	private int x;

	// y coordinate
	private int y;

	// direction at (x,y)
	private DirectionEnum direction;

	public Cell() {
	}

	public Cell(int x, int y, DirectionEnum direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}
}