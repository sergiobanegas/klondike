package es.upm.miw.iwvg.klondike.controllers;

import es.upm.miw.iwvg.klondike.models.Game;
import es.upm.miw.iwvg.klondike.models.GameInterface;

public class MenuController {

    private GameInterface game;

    public MenuController() {
        this.game = Game.getGameInterfaceInstance();
    }

    public String getDeck() {
        return game.getDeckString();
    }

    public String getWaste() {
        return game.getWasteString();
    }

    public String getFoundation(int position) {
        return game.getFoundationString(position);
    }

    public String getTableauPile(int position) {
        return game.getTableauPileString(position);
    }

}
