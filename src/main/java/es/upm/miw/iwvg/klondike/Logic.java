package es.upm.miw.iwvg.klondike;

import es.upm.miw.iwvg.klondike.controllers.FinalizedController;
import es.upm.miw.iwvg.klondike.controllers.OperationController;
import es.upm.miw.iwvg.klondike.controllers.StartController;
import es.upm.miw.iwvg.klondike.models.Game;
import es.upm.miw.iwvg.klondike.views.MenuView;

public class Logic {

    private Game game;

    private MenuView menu;

    public Logic() {
        game = Game.getInstance();
        menu = new MenuView();
    }

    public OperationController getOperationController() {
        switch (game.getState()) {
        case INITIAL:
            return new StartController();
        case IN_GAME:
            return menu.interact();
        case FINALIZED:
            return new FinalizedController();
        default:
            return null;
        }
    }
}
