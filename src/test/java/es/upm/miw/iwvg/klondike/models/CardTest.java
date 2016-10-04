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
    public void getColorTest() {
        assertEquals("r", this.cards[0].getColor());
        assertEquals("b", this.cards[1].getColor());
        assertEquals("r", this.cards[2].getColor());
        assertEquals("b", this.cards[3].getColor());
    }

    @Test
    public void getValueTest() {
        assertEquals(CardValue.ACE, this.cards[0].getValue());
        assertEquals(CardValue.FOUR, this.cards[1].getValue());
        assertEquals(CardValue.JACK, this.cards[2].getValue());
        assertEquals(CardValue.KING, this.cards[3].getValue());
    }

    @Test
    public void hasValueTest() {
        assertTrue(this.cards[0].hasValue("A"));
        assertTrue(this.cards[1].hasValue("4"));
        assertFalse(this.cards[2].hasValue("Q"));
        assertTrue(this.cards[3].hasValue("K"));
    }

    @Test
    public void isSameColor() {
        assertTrue(this.cards[0].isSameColor(this.cards[2]));
        assertTrue(this.cards[1].isSameColor(this.cards[3]));
        assertFalse(this.cards[0].isSameColor(this.cards[1]));
        assertFalse(this.cards[2].isSameColor(this.cards[3]));
    }

    @Test
    public void isSuit() {
        assertFalse(this.cards[0].isSuit(this.cards[1].getSuit()));
        assertFalse(this.cards[2].isSuit(this.cards[3].getSuit()));
        assertTrue(this.cards[0].isSuit(new Card(CardValue.THREE, Suit.DIAMANTES).getSuit()));
        assertTrue(this.cards[3].isSuit(new Card(CardValue.ACE, Suit.TREBOLES).getSuit()));
    }

    @Test
    public void validAboveFoundation() {
        assertFalse(this.cards[0].validAboveFoundation(this.cards[2]));
        assertFalse(this.cards[1].validAboveFoundation(this.cards[3]));
        assertTrue(this.cards[1].validAboveFoundation(new Card(CardValue.FIVE, Suit.PICAS)));
        assertTrue(this.cards[2].validAboveFoundation(new Card(CardValue.QUEEN, Suit.CORAZONES)));
    }

    @Test
    public void validAboveTableau() {
        assertFalse(this.cards[0].validAboveTableau(this.cards[2]));
        assertFalse(this.cards[1].validAboveTableau(this.cards[3]));
        assertTrue(this.cards[1].validAboveTableau(new Card(CardValue.THREE, Suit.DIAMANTES)));
        assertTrue(this.cards[2].validAboveTableau(new Card(CardValue.TEN, Suit.TREBOLES)));
    }

    @Test
    public void isNextCardValue() {
        assertTrue(this.cards[0].isNextCardValue(new Card(CardValue.TWO, Suit.DIAMANTES)));
        assertTrue(this.cards[1].isNextCardValue(new Card(CardValue.FIVE, Suit.PICAS)));
        assertFalse(this.cards[2].isNextCardValue(new Card(CardValue.KING, Suit.CORAZONES)));
        assertFalse(this.cards[3].isNextCardValue(new Card(CardValue.THREE, Suit.TREBOLES)));
    }

    @Test
    public void toStringTest() {
        assertEquals("[A,d]", this.cards[0].toString());
        assertEquals("[J,c]", this.cards[2].toString());
        assertNotEquals("[3,p]", this.cards[3].toString());
    }
}
