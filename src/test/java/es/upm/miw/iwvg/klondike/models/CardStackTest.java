package es.upm.miw.iwvg.klondike.models;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CardStackTest {

    private CardStack cards;

    @Before
    public void before() {
        cards = new CardStack();
        cards.addCard(new Card(CardValue.TWO, Suit.CLOVERS));
        cards.addCard(new Card(CardValue.ACE, Suit.HEARTS));
        cards.addCard(new Card(CardValue.QUEEN, Suit.TILES));
    }

    @Test
    public void isEmptyTest() {
        assertFalse(cards.isEmpty());
        cards = new CardStack();
        assertTrue(cards.isEmpty());
    }

    @Test
    public void addCardTest() {
        assertEquals(3, cards.getCards().size());
        cards.addCard(new Card(CardValue.QUEEN, Suit.TILES));
        assertEquals(4, cards.getCards().size());
    }

    @Test
    public void getCardTest() {
        assertEquals(new Card(CardValue.QUEEN, Suit.TILES).toString(), cards.getCard().toString());
    }

    @Test
    public void removeCardTest() {
        cards.removeCard();
        assertEquals(2, cards.getCards().size());
    }

    @Test
    public void getCardsTest() {
        assertEquals(3, cards.getCards().size());
    }

    @Test
    public void toStringCardListTest() {
        List<Card> cardsAux = new ArrayList<Card>();
        cardsAux.add(new Card(CardValue.TWO, Suit.TILES));
        cardsAux.add(new Card(CardValue.ACE, Suit.HEARTS));
        cardsAux.add(new Card(CardValue.QUEEN, Suit.PIKES));
        assertEquals(cardsAux.get(0).toString() + cardsAux.get(1).toString() + cardsAux.get(2).toString(),
                cards.toStringCardList(cardsAux));
    }
}
