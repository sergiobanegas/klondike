package es.upm.miw.iwvg.klondike.models;

import java.util.Collections;

public class Deck extends CardList {

    public Deck() {
        super();
        CardValue[] values = CardValue.values();
        Suit[] suits = Suit.values();
        for (CardValue cardValue : values) {
            for (Suit suit : suits) {
                super.cards.add(new Card(cardValue, suit));
            }
        }
        Collections.shuffle(super.cards);
    }

    @Override
    public String toString() {
        if (super.cards.isEmpty()) {
            return "<vacía>";
        } else {
            return "[X,X]";
        }
    }
}
