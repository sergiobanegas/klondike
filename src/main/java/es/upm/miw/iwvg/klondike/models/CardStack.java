package es.upm.miw.iwvg.klondike.models;

import java.util.List;
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

    public Card getLastCard() {
        return cards.get(cards.size() - 1);
    }

    public void removeCard() {
        cards.pop();
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public Stack<Card> getCards() {
        return cards;
    }

    public void clear() {
        this.cards = new Stack<Card>();
    }

    public String toStringCardList(List<Card> cards) {
        String toString = "";
        for (Card card : cards) {
            toString += card.toString();
        }
        return toString;
    }
}
