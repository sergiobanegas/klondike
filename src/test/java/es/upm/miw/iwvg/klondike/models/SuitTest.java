package es.upm.miw.iwvg.klondike.models;

import static org.junit.Assert.*;

import org.junit.Test;

public class SuitTest {

    
    @Test
    public void getValueTest() {
        assertEquals("t", Suit.TREBOLES.getValue());
        assertEquals("d", Suit.DIAMANTES.getValue());
        assertEquals("p", Suit.PICAS.getValue());
        assertEquals("c", Suit.CORAZONES.getValue());
    }

    @Test
    public void positionTest() {
        assertEquals(1, Suit.CORAZONES.position());
        assertEquals(2, Suit.DIAMANTES.position());
        assertEquals(3, Suit.TREBOLES.position());
        assertEquals(4, Suit.PICAS.position());
    }
    
}