package main;

import java.util.Random;

public enum Value {
	TWO, THREE, FOUR, FIVE, SIX, SEVEN,
	EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;
	
	public static Value random() {
		return Value.values()[new Random().nextInt(Value.values().length)];
	}
	
	public String toString() {
		String s = this.name();
		return s.substring(0, 1) + s.substring(1).toLowerCase();
	};
}
