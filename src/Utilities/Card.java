package Utilities;

/**
 * Created by msokol on 5/11/16.
 */
public class Card {

	public enum Value {
		TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), 
		SIX("6"), SEVEN("7"), EIGHT("8"), NINE("9"), 
		TEN("10"), JACK("W"), QUEEN("D"), KING("K"), 
		ACE("A");

		private String cardValue;

		private Value(String cardValue) {
			this.cardValue = cardValue;
		}

		public String getCardValue() {
			return this.cardValue;
		}
	}

	public enum Color {
		HEARTS("H"), DIAMONDS("D"), SPADES("S"), CLUBS("C");

		private String color;

		private Color(String color) {
			this.color = color;
		}

		public String getColor() {
			return this.color;
		}
	}

	private Color color;
	private Value value;

	public Card(Color color, Value value) {
		this.color = color;
		this.value = value;
	}

	public String toString() {
		String value = this.value.cardValue;
		String color = this.color.color;
		return value.concat(color);
	}
}
