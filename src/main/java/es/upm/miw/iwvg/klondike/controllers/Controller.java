package es.upm.miw.iwvg.klondike.controllers;

import es.upm.miw.iwvg.klondike.models.Card;
import es.upm.miw.iwvg.klondike.models.CardStack;
import es.upm.miw.iwvg.klondike.models.Game;
import es.upm.miw.iwvg.klondike.models.State;

public abstract class Controller {

	protected Game game;

	protected Controller(Game game) {
		assert game != null;
		this.game = game;
	}
	
	
	protected State getState(){
		return game.getState();
	}
	
	public void setState(State state){
		assert state != null;
		game.setState(state);
	}
	
	
	public void put(Card card, CardStack target) {
		assert target != null;
		game.put(card, target);
		if (game.isGameFinalized()) {
			game.setState(State.FINAL);
		}
	}
	
	public void remove(CardStack cards) {
		assert cards != null;
		game.remove(cards);
	}
	
	public boolean validMove(Card card, CardStack target) {
		assert card != null;
		assert target != null;
		return game.validMove(card, target);
	}
	
	
	public boolean isGameFinalized() {
		return game.isGameFinalized();
	}	
	
	public boolean isGameQuit() {
        return game.isGameQuit();
    }
	
}
