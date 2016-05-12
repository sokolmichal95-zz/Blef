package Utilities;

/**
 * Created by msokol on 5/11/16.
 */
public class Card {

    public enum Value {
        TWO("2"),
        THREE("3"),
        FOUR("4"),
        FIVE("5"),
        SIX("6"),
        SEVEN("7"),
        EIGHT("8"),
        NINE("9"),
        TEN("10"),
        JACK("J"),
        DAME("D"),
        KING("K"),
        AS("A");

        private String cardValue;

        private Value(String cardValue) {
            this.cardValue = cardValue;
        }
        public String getCardValue(){
            return this.cardValue;
        }
    }

    private String color;
    private String value;

    public Card(String color, String value) {
        this.color = color;
        this.value = value;
    }

    public String getCard(){
        return value.concat(color);
    }
}
