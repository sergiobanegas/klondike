package es.upm.miw.iwvg.klondike.models;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CardStackTest {

    private CardStack cards;

    @Before
    public void before() {
        cards = new CardStack();
        cards.addCard(new Card(CardValue.TWO, Suit.TREBOLES));
        cards.addCard(new Card(CardValue.ACE, Suit.CORAZONES));
        cards.addCard(new Card(CardValue.QUEEN, Suit.DIAMANTES));
    }

    @Test
    public void isEmptyTest() {
        assertFalse(cards.isEmpty());
        cards.clear();
        assertTrue(cards.isEmpty());
    }

    @Test
    public void addCardTest() {
        assertEquals(3, cards.size());
        cards.addCard(new Card(CardValue.QUEEN, Suit.DIAMANTES));
        assertEquals(4, cards.size());
    }

    @Test
    public void getCardTest() {
        assertEquals(new Card(CardValue.QUEEN, Suit.DIAMANTES).toString(), cards.getLastCard().toString());
    }

    @Test
    public void popCardTest() {
        cards.popCard();
        assertEquals(2, cards.size());
    }

    @Test
    public void getCardsTest() {
        assertEquals(3, cards.size());
    }

}
