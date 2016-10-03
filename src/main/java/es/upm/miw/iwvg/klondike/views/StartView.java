package es.upm.miw.iwvg.klondike.views;

import es.upm.miw.iwvg.klondike.controllers.ControllerInterface;

public class StartView implements ViewInterface {

    @Override
    public void interact(ControllerInterface startController) {
        startController.control();
    }
}
