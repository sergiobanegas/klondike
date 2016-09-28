package es.upm.miw.iwvg.klondike.models;

import java.util.ArrayList;
import java.util.List;

public class CardList {
    protected List<Card> cards;

    public CardList() {
        cards = new ArrayList<Card>();
    }

    public void addCard(Card card) {
        assert card != null;
        cards.add(card);
    }

    public Card getCard() {
        return cards.get(cards.size() - 1);
    }

    public void removeCard() {
        cards.remove(cards.size() - 1);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public List<Card> getCards() {
        return cards;
    }

    public String toStringCardList(List<Card> cards) {
        String toString = "";
        for (Card card : cards) {
            toString += card.toString();
        }
        return toString;
    }
}
