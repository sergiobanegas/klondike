package es.upm.miw.iwvg.klondike;

import es.upm.miw.iwvg.klondike.controllers.OperationController;
import es.upm.miw.iwvg.klondike.controllers.StartController;
import es.upm.miw.iwvg.klondike.models.Game;
import es.upm.miw.iwvg.klondike.views.Menu;

public class Logic {

    private Game game;

    private StartController startController;

    private Menu menu;

    public Logic() {
        game = new Game();
        menu = new Menu(game);
        startController = new StartController(game);
    }

    public OperationController getOperationController() {
        switch (game.getState()) {
        case INITIAL:
            return startController;
        case IN_GAME:
            OperationController controller = menu.render();
            return controller;
        case EXIT:
            return null;
        default:
            return null;
        }
    }
}
