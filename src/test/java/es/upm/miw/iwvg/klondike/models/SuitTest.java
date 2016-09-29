package es.upm.miw.iwvg.klondike.models;

import static org.junit.Assert.*;

import org.junit.Test;

public class SuitTest {

    
    @Test
    public void getValueTest() {
        assertEquals("c", Suit.CLOVERS.getValue());
        assertEquals("t", Suit.TILES.getValue());
        assertEquals("p", Suit.PIKES.getValue());
        assertEquals("h", Suit.HEARTS.getValue());
    }

    @Test
    public void positionTest() {
        assertEquals(1, Suit.HEARTS.position());
        assertEquals(2, Suit.TILES.position());
        assertEquals(3, Suit.CLOVERS.position());
        assertEquals(4, Suit.PIKES.position());
    }
    
}