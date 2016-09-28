package es.upm.miw.iwvg.klondike.models;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardValueTest {

    @Test
    public void getValueTest() {
        assertEquals("A", CardValue.ACE.getValue());
        assertEquals("J", CardValue.JACK.getValue());
        assertEquals("K", CardValue.KING.getValue());
    }

    @Test
    public void next() {
        assertEquals(CardValue.TWO, CardValue.ACE.next());
        assertEquals(CardValue.QUEEN, CardValue.JACK.next());
        assertEquals(CardValue.ACE, CardValue.KING.next());
    }

}