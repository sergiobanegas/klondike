package es.upm.miw.iwvg.klondike.controllers;

import es.upm.miw.iwvg.klondike.models.Card;
import es.upm.miw.iwvg.klondike.models.Game;
import es.upm.miw.iwvg.klondike.models.State;

public abstract class Controller {

    protected Game game;

    protected Controller(Game game) {
        assert game != null;
        this.game = game;
    }

    protected State getState() {
        return game.getState();
    }

    public void setState(State state) {
        assert state != null;
        game.setState(state);
    }

    public Card popLastCardDeck() {
        return game.popCardDeck();
    }

}
