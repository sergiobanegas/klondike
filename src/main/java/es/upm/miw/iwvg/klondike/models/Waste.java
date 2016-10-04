package es.upm.miw.iwvg.klondike.models;

import java.util.List;

public class Waste extends CardStack {

    private static final int SIZE = 3;

    public Waste() {
        super();
    }

    @Override
    public String toString() {
        if (cards.isEmpty()) {
            return "<vacío>";
        } else {
            if (cards.size() < 4) {
                return toStringCardList(cards);
            } else {
                List<Card> lastCards = cards.subList(cards.size() - SIZE, cards.size());
                return toStringCardList(lastCards);
            }
        }
    }

    public Card getLastCard() {
        return cards.get(cards.size() - 1);
    }

    public String toStringCardList(List<Card> cards) {
        String toString = "";
        for (Card card : cards) {
            toString += card.toString();
        }
        return toString;
    }
}
