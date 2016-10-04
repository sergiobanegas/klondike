package es.upm.miw.iwvg.klondike.models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TableauPilesTest {

    private TableauPiles tableau;

    @Before
    public void before() {
        tableau = new TableauPiles();
        tableau.addCardFaceUp(new Card(CardValue.KING, Suit.TREBOLES));
        tableau.addCardFaceUp(new Card(CardValue.TWO, Suit.CORAZONES));
        tableau.addCardFaceUp(new Card(CardValue.FOUR, Suit.TREBOLES));
        tableau.addCardFaceUp(new Card(CardValue.ACE, Suit.PICAS));
        tableau.addCardFaceUp(new Card(CardValue.SIX, Suit.DIAMANTES));
        tableau.addCardFaceDown(new Card(CardValue.QUEEN, Suit.TREBOLES));
        tableau.addCardFaceDown(new Card(CardValue.TEN, Suit.PICAS));
    }

    @Test
    public void isEmptyTest() {
        assertFalse(tableau.isEmpty());
        tableau.clear();
        assertTrue(tableau.isEmpty());
    }

    @Test
    public void getLastCardTest() {
        assertEquals(new Card(CardValue.SIX, Suit.DIAMANTES).toString(), tableau.getLastCard().toString());
        tableau.clear();
        tableau.addCardFaceUp(new Card(CardValue.THREE, Suit.CORAZONES));
        assertEquals(new Card(CardValue.THREE, Suit.CORAZONES).toString(), tableau.getLastCard().toString());
    }

    @Test
    public void flipCardTest() {
        tableau.clear();
        tableau.addCardFaceDown(new Card(CardValue.QUEEN, Suit.TREBOLES));
        tableau.addCardFaceDown(new Card(CardValue.TEN, Suit.PICAS));
        tableau.flipCard();
        assertEquals(new Card(CardValue.TEN, Suit.PICAS).toString(), tableau.getLastCard().toString());
    }

    @Test
    public void popCardTest() {
        assertEquals(new Card(CardValue.SIX, Suit.DIAMANTES).toString(), tableau.popCard().toString());
        assertEquals(new Card(CardValue.ACE, Suit.PICAS).toString(), tableau.getLastCard().toString());
    }

    @Test
    public void getFaceUpCardsNumberTest() {
        assertEquals(5, tableau.getFaceUpCardsNumber());
        tableau.popCard();
        tableau.popCard();
        assertEquals(3, tableau.getFaceUpCardsNumber());
    }

    @Test
    public void addCardFaceUpTest() {
        assertEquals(new Card(CardValue.SIX, Suit.DIAMANTES).toString(), tableau.getLastCard().toString());
        tableau.addCardFaceUp(new Card(CardValue.SEVEN, Suit.PICAS));
        assertEquals(new Card(CardValue.SEVEN, Suit.PICAS).toString(), tableau.getLastCard().toString());
    }

    @Test
    public void addCardFaceDownTest() {
        while (tableau.getFaceUpCardsNumber() != 0) {
            tableau.popCard();
        }
        tableau.flipCard();
        assertEquals(new Card(CardValue.TEN, Suit.PICAS).toString(), tableau.getLastCard().toString());
        tableau.popCard();
        tableau.addCardFaceDown(new Card(CardValue.SEVEN, Suit.PICAS));
        tableau.flipCard();
        assertEquals(new Card(CardValue.SEVEN, Suit.PICAS).toString(), tableau.getLastCard().toString());
    }

    @Test
    public void getFaceUpCardTest() {
        assertEquals(new Card(CardValue.SIX, Suit.DIAMANTES).toString(), tableau.getFaceUpCard(1).toString());
        assertEquals(new Card(CardValue.ACE, Suit.PICAS).toString(), tableau.getFaceUpCard(2).toString());
        assertEquals(new Card(CardValue.FOUR, Suit.TREBOLES).toString(), tableau.getFaceUpCard(3).toString());
    }

    @Test
    public void hasFaceUpCardsTest() {
        assertTrue(tableau.hasFaceUpCards());
        while (tableau.getFaceUpCardsNumber() != 0) {
            tableau.popCard();
        }
        assertFalse(tableau.hasFaceUpCards());
    }

    @Test
    public void hasFaceDownCardsTest() {
        assertTrue(tableau.hasFaceDownCards());
        while (tableau.getFaceUpCardsNumber() != 0) {
            tableau.popCard();
        }
        tableau.flipCard();
        tableau.popCard();
        tableau.flipCard();
        tableau.popCard();
        assertFalse(tableau.hasFaceDownCards());
    }

    @Test
    public void clearTest() {
        assertFalse(tableau.isEmpty());
        tableau.clear();
        assertTrue(tableau.isEmpty());
    }

    @Test
    public void toStringTest() {
        assertEquals("[[[K,t][2,c][4,t][A,p][6,d]", tableau.toString());
        tableau.clear();
        assertEquals("<vacío>", tableau.toString());
    }
}
