package com.java.lld.design;

import java.util.Random;

public class DiceService {

	private DiceService() {
	}

	public static int roll() {
      return new Random().nextInt(6) + 1; // The game will have a six sided dice numbered from 1 to 6 and will always give a random number on rolling it.
  }

	public static DiceService createDiceService() {
		return new DiceService();
	}
}
