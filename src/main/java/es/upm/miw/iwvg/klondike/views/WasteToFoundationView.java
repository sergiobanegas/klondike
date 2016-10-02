package es.upm.miw.iwvg.klondike.views;

import es.upm.miw.iwvg.klondike.controllers.WasteToFoundationController;
import es.upm.miw.iwvg.klondike.utils.IO;

public class WasteToFoundationView {

    public void interact(WasteToFoundationController controller) {
        IO io = new IO();
        int numFoundation = io.readInt("¿A qué palo? [1-4]:");
        while (numFoundation < 1 || numFoundation > 4) {
            io.writeln("ERROR!!! El número del palo debe ser entre 1 y 4 inclusives");
            numFoundation = io.readInt("¿A qué palo? [1-4]:");
        }
        controller.control(numFoundation - 1);
    }
}
