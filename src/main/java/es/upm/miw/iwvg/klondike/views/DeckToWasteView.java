package es.upm.miw.iwvg.klondike.views;

import es.upm.miw.iwvg.klondike.controllers.DeckToWasteController;

public class DeckToWasteView implements ViewInterface {

    private DeckToWasteController deckToWasteController;

    public DeckToWasteView(ControllerInterface controller) {
        deckToWasteController = (DeckToWasteController) controller;
    }

    @Override
    public void render() {
        deckToWasteController.control();
    }

}