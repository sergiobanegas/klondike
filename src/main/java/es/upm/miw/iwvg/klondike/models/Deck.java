package es.upm.miw.iwvg.klondike.models;

import java.util.Collections;

public class Deck extends CardStack {

    public Deck() {
        super();
        CardValue[] values = CardValue.values();
        Suit[] suits = Suit.values();
        for (CardValue cardValue : values) {
            for (Suit suit : suits) {
                cards.add(new Card(cardValue, suit));
            }
        }
        Collections.shuffle(cards);
    }

    @Override
    public String toString() {
        if (cards.isEmpty()) {
            return "<vacía>";
        } else {
            return "[X,X]";
        }
    }
}
