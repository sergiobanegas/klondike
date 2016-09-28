package es.upm.miw.iwvg.klondike.models;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CardListTest {

    private CardList cards;

    @Before
    public void before() {
        cards = new CardList();
        cards.addCard(new Card(CardValue.TWO, Suit.BASTOS));
        cards.addCard(new Card(CardValue.ACE, Suit.COPAS));
        cards.addCard(new Card(CardValue.QUEEN, Suit.ESPADAS));
    }

    @Test
    public void isEmptyTest() {
        assertFalse(cards.isEmpty());
        cards = new CardList();
        assertTrue(cards.isEmpty());
    }

    @Test
    public void addCardTest() {
        assertEquals(3, cards.getCards().size());
        cards.addCard(new Card(CardValue.QUEEN, Suit.OROS));
        assertEquals(4, cards.getCards().size());
    }

    @Test
    public void getCardTest() {
        assertEquals(new Card(CardValue.QUEEN, Suit.ESPADAS).toString(), cards.getCard().toString());
    }

    @Test
    public void removeCardTest() {
        cards.removeCard();
        assertEquals(2, cards.getCards().size());
    }

    @Test
    public void getCardsTest() {
        assertEquals(3, cards.getCards().size());
    }

    @Test
    public void toStringCardListTest() {
        List<Card> cardsAux = new ArrayList<Card>();
        cardsAux.add(new Card(CardValue.TWO, Suit.BASTOS));
        cardsAux.add(new Card(CardValue.ACE, Suit.COPAS));
        cardsAux.add(new Card(CardValue.QUEEN, Suit.ESPADAS));
        assertEquals(cardsAux.get(0).toString() + cardsAux.get(1).toString() + cardsAux.get(2).toString(),
                cards.toStringCardList(cardsAux));
    }
}
