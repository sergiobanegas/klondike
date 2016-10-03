package es.upm.miw.iwvg.klondike.views;

import es.upm.miw.iwvg.klondike.controllers.ControllerInterface;

public class WasteToDeckView implements ViewInterface {

    public void interact(ControllerInterface controller) {
        controller.control();
    }

}
