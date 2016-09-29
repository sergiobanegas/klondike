package es.upm.miw.iwvg.klondike.models;

public class Game {

    private Foundation foundation;

    private TableauPiles tableau;

    private Deck deck;

    private Waste waste;

    private State state;

    public Game() {
        state = State.INITIAL;
        deck = new Deck();
        waste = new Waste();
        tableau = new TableauPiles();
        foundation = new Foundation();
    }

    public State getState() {
        return state;
    }
    
    public Deck getDeck() {
        return deck;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void put(Card card, CardStack target) {
        target.getCards().add(card);
    }

    public void remove(CardStack target) {
        target.removeCard();
    }
    
    public boolean validMove(Card card, CardStack target) {
        return target.getCard().isNextCardValue(card);
    }

    public boolean isGameFinalized() {
        return tableau.isEmpty() && deck.isEmpty() && waste.isEmpty();
    }

}
