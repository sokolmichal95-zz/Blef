package Utilities;

import Utilities.Card.Color;
import Utilities.Card.Value;

public class Deck {

	private static Color[] color = { Card.Color.HEARTS, Card.Color.DIAMONDS, Card.Color.SPADES, Card.Color.CLUBS };
	private static Value[] value = { Card.Value.TWO, Card.Value.THREE, Card.Value.FOUR, Card.Value.FIVE, Card.Value.SIX,
			Card.Value.SEVEN, Card.Value.EIGHT, Card.Value.NINE, Card.Value.TEN, Card.Value.JACK, Card.Value.QUEEN,
			Card.Value.KING, Card.Value.ACE };

	public static Card[] getDeck() {
		Card[] deck = new Card[52];
		int index = 0;
		for (int i = 0; i < 52; i += 13) {
			for (int j = 0; j < value.length; j++) {
				deck[i + j] = new Card(color[i/13], value[j]);
			}
		}
		return deck;
	}
}
