package es.upm.miw.iwvg.klondike.views;

import es.upm.miw.iwvg.klondike.controllers.WasteToTableauController;
import es.upm.miw.iwvg.klondike.utils.IO;

public class WasteToTableauView {

    public void interact(WasteToTableauController controller) {
        IO io = new IO();
        int numTableau = io.readInt("¿Qué escalera? [1-7]:");
        controller.control(numTableau - 1);
    }
}
