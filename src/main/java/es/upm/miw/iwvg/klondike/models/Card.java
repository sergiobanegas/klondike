package es.upm.miw.iwvg.klondike.models;

public class Card {
    private CardValue value;

    private Suit suit;

    public Card(CardValue value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public Suit getSuit() {
        return suit;
    }

    public CardValue getValue() {
        return value;
    }

    public boolean isNextCardValue(Card card) {
        return value.next() == card.getValue();
    }

    @Override
    public String toString() {
        return "[" + value + "," + suit + "]";
    }
}
