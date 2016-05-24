package Utilities;

import java.util.Random;

import Utilities.Card.Color;
import Utilities.Card.Value;

public class Utils {

	public static Card generateRandomCard() {
		Random randomNum = new Random();
		int cardNumber = randomNum.nextInt(13) + 1;
		Random randomColor = new Random();
		int color = randomColor.nextInt(4);
		switch (cardNumber) {
		case 1:
			if (color == 0)
				return new Card(Color.HEARTS, Value.TWO);
			else if (color == 1)
				return new Card(Color.DIAMONDS, Value.TWO);
			else if (color == 2)
				return new Card(Color.SPADES, Value.TWO);
			else if (color == 3)
				return new Card(Color.CLUBS, Value.TWO);
		case 2:
			if (color == 0)
				return new Card(Color.HEARTS, Value.THREE);
			else if (color == 1)
				return new Card(Color.DIAMONDS, Value.THREE);
			else if (color == 2)
				return new Card(Color.SPADES, Value.THREE);
			else if (color == 3)
				return new Card(Color.CLUBS, Value.THREE);
		case 3:
			if (color == 0)
				return new Card(Color.HEARTS, Value.FOUR);
			else if (color == 1)
				return new Card(Color.DIAMONDS, Value.FOUR);
			else if (color == 2)
				return new Card(Color.SPADES, Value.FOUR);
			else if (color == 3)
				return new Card(Color.CLUBS, Value.FOUR);
		case 4:
			if (color == 0)
				return new Card(Color.HEARTS, Value.FIVE);
			else if (color == 1)
				return new Card(Color.DIAMONDS, Value.FIVE);
			else if (color == 2)
				return new Card(Color.SPADES, Value.FIVE);
			else if (color == 3)
				return new Card(Color.CLUBS, Value.FIVE);
		case 5:
			if (color == 0)
				return new Card(Color.HEARTS, Value.SIX);
			else if (color == 1)
				return new Card(Color.DIAMONDS, Value.SIX);
			else if (color == 2)
				return new Card(Color.SPADES, Value.SIX);
			else if (color == 3)
				return new Card(Color.CLUBS, Value.SIX);
		case 6:
			if (color == 0)
				return new Card(Color.HEARTS, Value.SEVEN);
			else if (color == 1)
				return new Card(Color.DIAMONDS, Value.SEVEN);
			else if (color == 2)
				return new Card(Color.SPADES, Value.SEVEN);
			else if (color == 3)
				return new Card(Color.CLUBS, Value.SEVEN);
		case 7:
			if (color == 0)
				return new Card(Color.HEARTS, Value.EIGHT);
			else if (color == 1)
				return new Card(Color.DIAMONDS, Value.EIGHT);
			else if (color == 2)
				return new Card(Color.SPADES, Value.EIGHT);
			else if (color == 3)
				return new Card(Color.CLUBS, Value.EIGHT);
		case 8:
			if (color == 0)
				return new Card(Color.HEARTS, Value.NINE);
			else if (color == 1)
				return new Card(Color.DIAMONDS, Value.NINE);
			else if (color == 2)
				return new Card(Color.SPADES, Value.NINE);
			else if (color == 3)
				return new Card(Color.CLUBS, Value.NINE);
		case 9:
			if (color == 0)
				return new Card(Color.HEARTS, Value.TEN);
			else if (color == 1)
				return new Card(Color.DIAMONDS, Value.TEN);
			else if (color == 2)
				return new Card(Color.SPADES, Value.TEN);
			else if (color == 3)
				return new Card(Color.CLUBS, Value.TEN);
		case 10:
			if (color == 0)
				return new Card(Color.HEARTS, Value.JACK);
			else if (color == 1)
				return new Card(Color.DIAMONDS, Value.JACK);
			else if (color == 2)
				return new Card(Color.SPADES, Value.JACK);
			else if (color == 3)
				return new Card(Color.CLUBS, Value.JACK);
		case 11:
			if (color == 0)
				return new Card(Color.HEARTS, Value.QUEEN);
			else if (color == 1)
				return new Card(Color.DIAMONDS, Value.QUEEN);
			else if (color == 2)
				return new Card(Color.SPADES, Value.QUEEN);
			else if (color == 3)
				return new Card(Color.CLUBS, Value.QUEEN);
		case 12:
			if (color == 0)
				return new Card(Color.HEARTS, Value.KING);
			else if (color == 1)
				return new Card(Color.DIAMONDS, Value.KING);
			else if (color == 2)
				return new Card(Color.SPADES, Value.KING);
			else if (color == 3)
				return new Card(Color.CLUBS, Value.KING);
		case 13:
			if (color == 0)
				return new Card(Color.HEARTS, Value.ACE);
			else if (color == 1)
				return new Card(Color.DIAMONDS, Value.ACE);
			else if (color == 2)
				return new Card(Color.SPADES, Value.ACE);
			else if (color == 3)
				return new Card(Color.CLUBS, Value.ACE);
		default:
			return new Card(Color.SPADES, Value.ACE);
		}
	}

	/**
	 * Implementation of Fisher-Yates shuffle
	 * 
	 * @param ar
	 */
	public static Card[] shuffle(Card [] ar) {
		Random rnd = new Random();
		for (int i = ar.length - 1; i > 0; i--) {
			int index = rnd.nextInt(i + 1);
			Card a = ar[index];
			ar[index] = ar[i];
			ar[i] = a;
		} 
		return ar;
	}
	
}
