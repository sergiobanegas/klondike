package es.upm.miw.iwvg.klondike.models;

import java.util.Stack;

public class TableauPiles {

    public static final int NUMBER_OF_PILES = 7;

    private Stack<Card> cardsFaceDown;

    private Stack<Card> cardsFaceUp;

    public TableauPiles() {
        this.cardsFaceDown = new Stack<Card>();
        this.cardsFaceUp = new Stack<Card>();
    }

    public TableauPiles(int length) {

    }

    public boolean isEmpty() {
        return cardsFaceDown.isEmpty() && cardsFaceUp.isEmpty();
    }

    public Card getLastCard() {
        return cardsFaceUp.get(cardsFaceUp.size() - 1);
    }

    public void flipCard() {
        assert cardsFaceUp.isEmpty() == true;
        cardsFaceUp.push(cardsFaceDown.pop());
    }

    public Card popCard() {
        return cardsFaceUp.pop();
    }

    public void addCard(Card card) {
        cardsFaceUp.add(card);
    }

    public Stack<Card> getCardsFaceDown() {
        return cardsFaceDown;
    }

    public boolean hasFaceUpCards() {
        return !this.cardsFaceUp.isEmpty();
    }

    public Stack<Card> getCardsFaceUp() {
        return cardsFaceUp;
    }

    public static int getNumberOfPiles() {
        return NUMBER_OF_PILES;
    }

    public void clear() {
        cardsFaceUp = new Stack<Card>();
        cardsFaceDown = new Stack<Card>();
    }

    @Override
    public String toString() {
        if (cardsFaceDown.isEmpty() && cardsFaceUp.isEmpty()) {
            return "<vacío>";
        }

        String stringPileDown = "";
        for (int i = 0; i < cardsFaceDown.size(); i++) {
            stringPileDown += "[";
        }
        String stringPileUp = "";
        for (int i = 0; i < cardsFaceUp.size(); i++) {
            stringPileDown += cardsFaceUp.get(i);
        }
        return stringPileDown + stringPileUp;
    }
}
