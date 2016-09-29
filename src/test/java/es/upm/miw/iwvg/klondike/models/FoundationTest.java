package es.upm.miw.iwvg.klondike.models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FoundationTest {

    private Foundation foundation;

    @Before
    public void before() {
        foundation = new Foundation();
    }

    @Test
    public void toStringTest() {
        assertEquals("<vacío>", foundation.toString());
        foundation.addCard(new Card(CardValue.KING, Suit.CLOVERS));
        foundation.addCard(new Card(CardValue.NINE, Suit.CLOVERS));
        Card lastCard = new Card(CardValue.ACE, Suit.CLOVERS);
        foundation.addCard(lastCard);
        assertEquals(lastCard.toString(), foundation.toString());
    }
}
