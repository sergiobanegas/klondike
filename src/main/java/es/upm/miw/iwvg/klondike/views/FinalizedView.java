package es.upm.miw.iwvg.klondike.views;

import es.upm.miw.iwvg.klondike.controllers.OperationController;
import es.upm.miw.iwvg.klondike.utils.IO;

public class FinalizedView implements ViewInterface {

    @Override
    public void interact(OperationController controller) {
        new IO().writeln("ENHORABUENA, HAS GANADO!!!");
        controller.control();
    }
}
