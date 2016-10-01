package es.upm.miw.iwvg.klondike.models;

import java.util.ArrayList;
import java.util.List;

public class TableauPiles {

    public static final int NUMBER_OF_PILES = 7;

    private CardStack cardsFaceDown;

    private List<Card> cardsFaceUp;

    public TableauPiles() {
        this.cardsFaceDown = new CardStack();
        this.cardsFaceUp = new ArrayList<Card>();
    }

    public TableauPiles(int length) {

    }

    public boolean isEmpty() {
        return cardsFaceDown.isEmpty() && cardsFaceUp.isEmpty();
    }

    public Card getLastCard() {
        return cardsFaceUp.get(cardsFaceUp.size() - 1);
    }
    
    public Card popCard(){
        Card card=getLastCard();
        cardsFaceUp.remove(cardsFaceUp.size()-1);
        return card;
    }

    public void addCard(Card card) {
        cardsFaceUp.add(card);
    }

    public CardStack getCardsFaceDown() {
        return cardsFaceDown;
    }

    public List<Card> getCardsFaceUp() {
        return cardsFaceUp;
    }

    public static int getNumberOfPiles() {
        return NUMBER_OF_PILES;
    }

    @Override
    public String toString() {
        if (cardsFaceDown.isEmpty() && cardsFaceUp.isEmpty()) {
            return "<vacío>";
        }

        String stringPileDown = "";
        for (int i = 0; i < cardsFaceDown.getCards().size(); i++) {
            stringPileDown += "[";
        }
        String stringPileUp = "";
        for (Card cardFaceUp : cardsFaceUp) {
            stringPileDown += cardFaceUp;
        }
        return stringPileDown + stringPileUp;
    }
}
