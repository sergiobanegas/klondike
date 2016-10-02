package es.upm.miw.iwvg.klondike;

import es.upm.miw.iwvg.klondike.controllers.FinalizedController;
import es.upm.miw.iwvg.klondike.controllers.OperationController;
import es.upm.miw.iwvg.klondike.controllers.StartController;
import es.upm.miw.iwvg.klondike.models.Game;
import es.upm.miw.iwvg.klondike.views.Menu;

public class Logic {

    private Game game;

    private Menu menu;

    public Logic() {
        game = new Game();
        menu = new Menu(game);
    }

    public OperationController getOperationController() {
        switch (game.getState()) {
        case INITIAL:
            return new StartController(game);
        case IN_GAME:
            return menu.render();
        case FINALIZED:
            return new FinalizedController(game);
        default:
            return null;
        }
    }
}
