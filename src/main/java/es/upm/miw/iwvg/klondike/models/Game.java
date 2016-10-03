package es.upm.miw.iwvg.klondike.models;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Foundation> foundations;

    private List<TableauPiles> tableauPiles;

    private Deck deck;

    private Waste waste;

    private State state;

    public Game() {
        state = State.INITIAL;
        this.foundations = new ArrayList<Foundation>();
        this.tableauPiles = new ArrayList<TableauPiles>();
    }

    public State getState() {
        return state;
    }

    public TableauPiles getTableauPile(int position) {
        return tableauPiles.get(position);
    }

    public void addFoundation(Foundation foundation) {
        this.foundations.add(foundation);
    }

    public void addTableauPile(TableauPiles tableau) {
        this.tableauPiles.add(tableau);
    }

    public Foundation getFoundation(int position) {
        return foundations.get(position);
    }

    public void addCardWaste(Card card) {
        waste.addCard(card);
    }

    public void addCardDeck(Card card) {
        deck.addCard(card);
    }

    public Card getLastCardWaste() {
        return waste.getLastCard();
    }

    public Card popCardWaste() {
        return waste.popCard();
    }

    public Card popCardDeck() {
        return deck.popCard();
    }

    public boolean isWasteEmpty() {
        return waste.isEmpty();
    }

    public boolean isDeckEmpty() {
        return deck.isEmpty();
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setWaste(Waste waste) {
        this.waste = waste;
    }

    public boolean isGameFinalized() {
        int cards = 0;
        for (Foundation foundation : foundations) {
            cards += foundation.getCards().size();
        }
        return cards == Suit.values().length * CardValue.values().length;
    }

    public String getDeckString() {
        return deck.toString();
    }

    public String getWasteString() {
        return waste.toString();
    }

    public String getFoundationString(int position) {
        return getFoundation(position).toString();
    }

    public String getTableauString(int position) {
        return getTableauPile(position).toString();
    }

    public void end() {
        deck.clear();
        waste.clear();
        for (TableauPiles tableauPile : tableauPiles) {
            tableauPile.clear();
        }
    }

}
