package es.upm.miw.iwvg.klondike.models;

import static org.junit.Assert.*;

import org.junit.Test;

public class WasteTest {
    
    @Test
    public void toStringTest() {
        Waste discard = new Waste();
        assertEquals("<vacío>", discard.toString());
        Card card1 = new Card(CardValue.KING, Suit.PIKES);
        discard.addCard(card1);
        assertEquals(card1.toString(), discard.toString());
        Card card2 = new Card(CardValue.THREE, Suit.HEARTS);
        Card card3 = new Card(CardValue.SIX, Suit.CLOVERS);
        discard.addCard(card2);
        discard.addCard(card3);
        assertEquals(card1.toString() + card2.toString() + card3.toString(), discard.toString());
    }
}
