package es.upm.miw.iwvg.klondike.models;

import java.util.List;

public class TableauPiles {

    private CardStack cardsFaceDown;

    private List<Card> cardsFaceUp;

    public TableauPiles() {

    }

    public TableauPiles(int length) {

    }

    public boolean isEmpty() {
        return cardsFaceDown.isEmpty() && cardsFaceUp.isEmpty();
    }
}
