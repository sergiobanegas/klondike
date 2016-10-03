package es.upm.miw.iwvg.klondike.models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CardTest {

    private Card[] cards;

    @Before
    public void before() {
        this.cards = new Card[4];
        this.cards[0] = new Card(CardValue.ACE, Suit.DIAMANTES);
        this.cards[1] = new Card(CardValue.FOUR, Suit.PICAS);
        this.cards[2] = new Card(CardValue.JACK, Suit.CORAZONES);
        this.cards[3] = new Card(CardValue.KING, Suit.TREBOLES);
    }

    @Test
    public void getSuitTest() {
        assertEquals(Suit.DIAMANTES, this.cards[0].getSuit());
        assertEquals(Suit.PICAS, this.cards[1].getSuit());
        assertEquals(Suit.CORAZONES, this.cards[2].getSuit());
        assertEquals(Suit.TREBOLES, this.cards[3].getSuit());
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
        assertTrue(this.cards[0].isNextCardValue(new Card(CardValue.TWO, Suit.DIAMANTES)));
        assertTrue(this.cards[1].isNextCardValue(new Card(CardValue.FIVE, Suit.PICAS)));
        assertFalse(this.cards[2].isNextCardValue(new Card(CardValue.KING, Suit.CORAZONES)));
        assertFalse(this.cards[3].isNextCardValue(new Card(CardValue.THREE, Suit.TREBOLES)));
    }
}
