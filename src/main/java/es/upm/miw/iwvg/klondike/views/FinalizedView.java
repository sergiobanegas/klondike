package es.upm.miw.iwvg.klondike.views;

import es.upm.miw.iwvg.klondike.controllers.FinalizedController;
import es.upm.miw.iwvg.klondike.utils.IO;

public class FinalizedView {

    public void interact(FinalizedController controller) {
        new IO().writeln("ENHORABUENA, HAS GANADO!!!");
        controller.control();
    }
}
