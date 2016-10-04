package es.upm.miw.iwvg.klondike.models;

public class Foundation extends CardStack {

    private Suit suit;

    public Foundation(Suit suit) {
        super();
        this.suit = suit;
    }

    public boolean sameSuit(Card card) {
        return card.isSuit(suit);
    }

    public int getSize() {
        return cards.size();
    }

    public Card getLastCard() {
        return cards.get(cards.size() - 1);
    }

    @Override
    public String toString() {
        if (super.cards.isEmpty()) {
            return "<vacío>";
        } else {
            return super.cards.get(super.cards.size() - 1).toString();
        }
    }
}
