package es.upm.miw.iwvg.klondike.models;

import static org.junit.Assert.*;

import org.junit.Test;

public class DiscardTest {
    
    @Test
    public void toStringTest() {
        Discard discard = new Discard();
        assertEquals("<vacío>", discard.toString());
        Card card1 = new Card(CardValue.KING, Suit.OROS);
        discard.addCard(card1);
        assertEquals(card1.toString(), discard.toString());
        Card card2 = new Card(CardValue.THREE, Suit.OROS);
        Card card3 = new Card(CardValue.SIX, Suit.BASTOS);
        discard.addCard(card2);
        discard.addCard(card3);
        assertEquals(card1.toString() + card2.toString() + card3.toString(), discard.toString());
    }
}
