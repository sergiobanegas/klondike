package es.upm.miw.iwvg.klondike.controllers.local;

import es.upm.miw.iwvg.klondike.Logic;
import es.upm.miw.iwvg.klondike.models.Deck;

public class LocalLogic implements Logic {

	private Deck deck;

	private LocalMoveControllerBuilder colocateControllerBuilder;
	
	private LocalStartController startController;

	private LocalContinueController continueController;

	public LocalLogic() {
		deck = new Deck();
		colocateControllerBuilder = new LocalMoveControllerBuilder(game);
		startController = new LocalStartController(deck, colocateControllerBuilder);
		continueController = new LocalContinueController(game);
	}

	public LocalOperationController getOperationController() {
		switch (game.getState()){
		case INITIAL:
			return startController;
		case IN_GAME:
			return colocateControllerBuilder.getColocateController();
		case FINAL:
			return continueController;
		case EXIT:
		default:
			return null;
		}
	}
}