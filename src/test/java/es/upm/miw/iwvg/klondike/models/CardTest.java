package es.upm.miw.iwvg.klondike.models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CardTest {

    private Card[] cards;

    @Before
    public void before() {
        this.cards = new Card[4];
        this.cards[0] = new Card(CardValue.ACE, Suit.BASTOS);
        this.cards[1] = new Card(CardValue.FOUR, Suit.COPAS);
        this.cards[2] = new Card(CardValue.JACK, Suit.ESPADAS);
        this.cards[3] = new Card(CardValue.KING, Suit.OROS);
    }

    @Test
    public void getSuitTest() {
        assertEquals(Suit.BASTOS, this.cards[0].getSuit());
        assertEquals(Suit.COPAS, this.cards[1].getSuit());
        assertEquals(Suit.ESPADAS, this.cards[2].getSuit());
        assertEquals(Suit.OROS, this.cards[3].getSuit());
    }

    @Test
    public void getValueTest() {
        assertEquals(CardValue.ACE, this.cards[0].getValue());
        assertEquals(CardValue.FOUR, this.cards[1].getValue());
        assertEquals(CardValue.JACK, this.cards[2].getValue());
        assertEquals(CardValue.KING, this.cards[3].getValue());
    }

    @Test
    public void isNextCardValue() {
        assertTrue(this.cards[0].isNextCardValue(new Card(CardValue.TWO, Suit.ESPADAS)));
        assertTrue(this.cards[1].isNextCardValue(new Card(CardValue.FIVE, Suit.BASTOS)));
        assertFalse(this.cards[2].isNextCardValue(new Card(CardValue.KING, Suit.COPAS)));
        assertFalse(this.cards[3].isNextCardValue(new Card(CardValue.THREE, Suit.OROS)));
    }
}
