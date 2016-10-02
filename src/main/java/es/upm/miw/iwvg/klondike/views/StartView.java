package es.upm.miw.iwvg.klondike.views;

import es.upm.miw.iwvg.klondike.controllers.OperationController;

public class StartView implements ViewInterface {

    @Override
    public void interact(OperationController startController) {
        startController.control();
    }
}
