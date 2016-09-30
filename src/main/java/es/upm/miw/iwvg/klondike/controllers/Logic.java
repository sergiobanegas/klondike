package es.upm.miw.iwvg.klondike.controllers;

import es.upm.miw.iwvg.klondike.models.Game;
import es.upm.miw.iwvg.klondike.views.Menu;

public class Logic {

    private Game game;

    private StartController startController;

    private DeckToWasteController deckToWasteController;

    private Menu menu;
    //
    // private ExitController exitController;

    public Logic() {
        game = new Game();
        menu = new Menu(game);
        startController = new StartController(game);
        deckToWasteController = new DeckToWasteController(game);
        // exitController = new ExitController(game);
    }

    public OperationController getOperationController() {
        switch (game.getState()) {
        case INITIAL:
            return startController;
        case IN_GAME:
            OperationController controller = menu.render();
            // System.out.println("En juego..");
            return controller;
        case FINAL:

        case EXIT:
        default:
            return null;
        }
    }
}