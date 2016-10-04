package es.upm.miw.iwvg.klondike.models;

import java.util.Stack;

public class CardStack {
    protected Stack<Card> cards;

    public CardStack() {
        cards = new Stack<Card>();
    }

    public void addCard(Card card) {
        assert card != null;
        cards.add(card);
    }

    public Card popCard() {
        return cards.pop();
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public void clear() {
        this.cards = new Stack<Card>();
    }
}
