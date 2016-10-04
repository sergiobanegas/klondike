package es.upm.miw.iwvg.klondike.models;

public class Foundation extends CardStack {

    private Suit suit;

    public Foundation(Suit suit) {
        super();
        assert suit != null;
        this.suit = suit;
    }

    public boolean sameSuit(Card card) {
        assert card != null;
        return card.isSuit(suit);
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
