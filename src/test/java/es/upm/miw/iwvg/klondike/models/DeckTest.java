package es.upm.miw.iwvg.klondike.models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DeckTest {

    private Deck deck;

    @Before
    public void before() {
        this.deck = new Deck();
    }

    @Test
    public void deckSizeTest() {
        assertEquals(52, deck.size());
    }

    @Test
    public void toStringTest() {
        Deck deck = new Deck();
        assertEquals("[X,X]", deck.toString());
    }
}
