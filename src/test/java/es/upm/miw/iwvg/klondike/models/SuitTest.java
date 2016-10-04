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

}
