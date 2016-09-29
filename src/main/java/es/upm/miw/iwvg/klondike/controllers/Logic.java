package es.upm.miw.iwvg.klondike.controllers;

import es.upm.miw.iwvg.klondike.models.Deck;
import es.upm.miw.iwvg.klondike.models.Game;

public class Logic {

    private Game game;
    
    private StartController startController;
    
	private MoveControllerBuilder colocateControllerBuilder;

	private ExitController exitController;

	public Logic() {
		game = new Game();
		startController = new StartController(game);
		moveController = new MoveController(game);
		exitController = new ExitController(game);
	}

	public LocalOperationController getOperationController() {
		switch (game.getState()){
		case INITIAL:
			return startController;
		case IN_GAME:
			return moveControllerBuilder.getMoveController();
		case FINAL:
		    
		case EXIT:
		default:
			return null;
		}
	}
}