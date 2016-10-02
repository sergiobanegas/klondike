package es.upm.miw.iwvg.klondike.views;

import es.upm.miw.iwvg.klondike.controllers.OperationController;

public class WasteToDeckView implements ViewInterface {

    public void interact(OperationController controller) {
        controller.control();
    }

}
