package es.upm.miw.iwvg.klondike.views;

import es.upm.miw.iwvg.klondike.controllers.OperationController;

public class DeckToWasteView implements ViewInterface {

    @Override
    public void interact(OperationController controller) {
        controller.control();
    }

}
