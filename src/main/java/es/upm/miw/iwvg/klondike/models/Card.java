package es.upm.miw.iwvg.klondike.models;

public class Card {
    private CardValue value;

    private Color color;
    
    private Suit suit;

    public Card(CardValue value, Suit suit) {
        this.value = value;
        this.suit = suit;
        if (suit.equals(Suit.HEARTS)||suit.equals(Suit.TILES)){
            this.color=Color.RED;
        }else{
            this.color=Color.BLACK;
        }
    }

    public Suit getSuit() {
        return suit;
    }

    public CardValue getValue() {
        return value;
    }
    
    public Color getColor() {
        return color;
    }
    
    public boolean isSameColor(Card card) {
        return card.getColor().getValue()==color.getValue();
        
    }

    public boolean isNextCardValue(Card card) {
        return value.next() == card.getValue();
    }

    @Override
    public String toString() {
        return "[" + value.getValue() + "," + suit.getValue() + "]";
    }
}
