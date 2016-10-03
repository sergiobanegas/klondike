package es.upm.miw.iwvg.klondike.views;

import es.upm.miw.iwvg.klondike.controllers.ControllerInterface;

public class DeckToWasteView implements ViewInterface {

    @Override
    public void interact(ControllerInterface controller) {
        controller.control();
    }

}
