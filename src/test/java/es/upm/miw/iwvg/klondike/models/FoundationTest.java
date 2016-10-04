package es.upm.miw.iwvg.klondike.models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FoundationTest {

    private Foundation foundation;

    @Before
    public void before() {
        foundation = new Foundation(Suit.TREBOLES);
    }
    
    @Test
    public void sameSuitTest(){
        assertTrue(foundation.sameSuit(new Card(CardValue.KING, Suit.TREBOLES)));
        assertFalse(foundation.sameSuit(new Card(CardValue.TWO, Suit.CORAZONES)));
    }

    @Test
    public void toStringTest() {
        assertEquals("<vacío>", foundation.toString());
        foundation.addCard(new Card(CardValue.KING, Suit.TREBOLES));
        foundation.addCard(new Card(CardValue.NINE, Suit.TREBOLES));
        Card lastCard = new Card(CardValue.ACE, Suit.TREBOLES);
        foundation.addCard(lastCard);
        assertEquals(lastCard.toString(), foundation.toString());
    }
}
