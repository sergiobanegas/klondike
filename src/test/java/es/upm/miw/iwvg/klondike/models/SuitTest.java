package es.upm.miw.iwvg.klondike.models;

import static org.junit.Assert.*;

import org.junit.Test;

public class SuitTest {

    
    @Test
    public void getValueTest() {
        assertEquals("o", Suit.OROS.getValue());
        assertEquals("c", Suit.COPAS.getValue());
        assertEquals("e", Suit.ESPADAS.getValue());
        assertEquals("b", Suit.BASTOS.getValue());
    }

    @Test
    public void positionTest() {
        assertEquals(1, Suit.OROS.position());
        assertEquals(2, Suit.COPAS.position());
        assertEquals(3, Suit.ESPADAS.position());
        assertEquals(4, Suit.BASTOS.position());
    }
    
}