package es.upm.miw.iwvg.klondike.models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WasteTest {

    private Waste waste;

    @Before
    public void before() {
        waste = new Waste();
    }

    @Test
    public void toStringTest() {
        assertEquals("<vacío>", waste.toString());
        Card card1 = new Card(CardValue.KING, Suit.PICAS);
        Card card2 = new Card(CardValue.THREE, Suit.CORAZONES);
        Card card3 = new Card(CardValue.SIX, Suit.TREBOLES);
        waste.addCard(card1);
        assertEquals(card1.toString(), waste.toString());
        waste.addCard(card2);
        waste.addCard(card3);
        assertEquals(card1.toString() + card2.toString() + card3.toString(), waste.toString());
    }

    @Test
    public void popCardTest() {
        Card card1 = new Card(CardValue.QUEEN, Suit.DIAMANTES);
        Card card2 = new Card(CardValue.THREE, Suit.TREBOLES);
        Card card3 = new Card(CardValue.SEVEN, Suit.PICAS);
        waste.addCard(card1);
        waste.addCard(card2);
        waste.addCard(card3);
        assertEquals(card1.toString() + card2.toString() + card3.toString(), waste.toString());
        waste.setDisplaySize(1);
        assertEquals(card3.toString(), waste.toString());
        waste.setDisplaySize(2);
        assertEquals(card2.toString() + card3.toString(), waste.toString());
    }
}
