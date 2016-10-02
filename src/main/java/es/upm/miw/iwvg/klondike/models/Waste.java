package es.upm.miw.iwvg.klondike.models;

import java.util.List;

public class Waste extends CardStack {

    private static final int SIZE = 3;

    public Waste() {
        super();
    }

    @Override
    public String toString() {
        if (super.cards.isEmpty()) {
            return "<vacío>";
        } else {
            if (super.cards.size() < 4) {
                return super.toStringCardList(super.cards);
            } else {
                List<Card> lastCards = super.getCards().subList(super.cards.size() - SIZE, super.cards.size());
                return super.toStringCardList(lastCards);
            }
        }
    }
}
