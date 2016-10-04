package es.upm.miw.iwvg.klondike.models;

import java.util.ArrayList;
import java.util.List;

public class Game implements GameInterface {

    private static Game game;

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

    public static Game getInstance() {
        if (game == null) {
            game = new Game();
        }
        return game;
    }

    public static GameInterface getGameInterfaceInstance() {
        return game;
    }

    public State getState() {
        return state;
    }

    public TableauPiles getTableauPile(int position) {
        assert position >= 0;
        assert position < 7;
        return tableauPiles.get(position);
    }

    public void addFoundation(Foundation foundation) {
        assert foundation != null;
        this.foundations.add(foundation);
    }

    public void addTableauPile(TableauPiles tableau) {
        assert tableau != null;
        this.tableauPiles.add(tableau);
    }

    public Foundation getFoundation(int position) {
        assert position >= 0;
        assert position < 4;
        return foundations.get(position);
    }

    public void addCardWaste(Card card) {
        assert card != null;
        waste.addCard(card);
    }

    public void addCardDeck(Card card) {
        assert card != null;
        deck.addCard(card);
    }

    public Card getLastCardWaste() {
        assert waste.isEmpty() == false;
        return waste.getLastCard();
    }

    public Card popCardWaste() {
        assert waste.isEmpty() == false;
        return waste.popCard();
    }

    public Card popCardDeck() {
        assert deck.isEmpty() == false;
        return deck.popCard();
    }

    public Card popCardFoundation(int position) {
        assert position >= 0;
        assert position < 4;
        assert foundations.get(position).isEmpty() == false;
        return foundations.get(position).popCard();
    }

    public boolean isWasteEmpty() {
        return waste.isEmpty();
    }

    public boolean isDeckEmpty() {
        return deck.isEmpty();
    }

    public boolean hasTableauFaceUpCards(int position) {
        assert position >= 0;
        assert position < 7;
        return tableauPiles.get(position).isEmpty();
    }

    public boolean isFoundationEmpty(int position) {
        assert position >= 0;
        assert position < 4;
        return foundations.get(position).isEmpty();
    }

    public void setDeck(Deck deck) {
        assert deck != null;
        this.deck = deck;
    }

    public void setState(State state) {
        assert state != null;
        this.state = state;
    }

    public void setWaste(Waste waste) {
        assert waste != null;
        this.waste = waste;
    }

    public boolean isGameFinalized() {
        int cards = 0;
        for (Foundation foundation : foundations) {
            cards += foundation.size();
        }
        return cards == Suit.values().length * CardValue.values().length;
    }

    public void setWasteDisplaySize(int size) {
        assert size >= 1;
        assert size < 4;
        waste.setDisplaySize(size);
    }

    @Override
    public String getDeckString() {
        return deck.toString();
    }

    @Override
    public String getWasteString() {
        return waste.toString();
    }

    @Override
    public String getFoundationString(int position) {
        return getFoundation(position).toString();
    }

    @Override
    public String getTableauPileString(int position) {
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
