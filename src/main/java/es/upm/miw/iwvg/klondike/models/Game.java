package es.upm.miw.iwvg.klondike.models;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Foundation> foundations;

    private List<TableauPiles> tableauPiles;

    private Deck deck;

    private Waste waste;

    private State state;

    private Option option;

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

    public List<TableauPiles> getTableauPiles() {
        return tableauPiles;
    }

    public void addFoundation(Foundation foundation) {
        this.foundations.add(foundation);
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    public List<Foundation> getFoundations() {
        return foundations;
    }

    public Foundation getFoundation(int position) {
        return foundations.get(position);
    }

    public Waste getWaste() {
        return waste;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setFoundations(List<Foundation> foundations) {
        this.foundations = foundations;
    }

    public void setTableauPiles(List<TableauPiles> tableauPiles) {
        this.tableauPiles = tableauPiles;
    }

    public void setWaste(Waste waste) {
        this.waste = waste;
    }

    public void put(Card card, CardStack target) {
        target.getCards().add(card);
    }

    public void remove(CardStack target) {
        target.removeCard();
    }

    public boolean validMove(Card card, CardStack target) {
        return target.getLastCard().isNextCardValue(card);
    }

    public boolean isGameFinalized() {
        int cards = 0;
        for (Foundation foundation : foundations) {
            cards += foundation.getCards().size();
        }
        return cards == Suit.values().length * CardValue.values().length;
    }

    public void end() {
        deck.clear();
        waste.clear();
        for (TableauPiles tableauPile : tableauPiles) {
            tableauPile.clear();
        }
    }

}
