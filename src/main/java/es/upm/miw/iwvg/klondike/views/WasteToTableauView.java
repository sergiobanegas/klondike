package es.upm.miw.iwvg.klondike.views;

import es.upm.miw.iwvg.klondike.controllers.WasteToTableauController;
import es.upm.miw.iwvg.klondike.utils.IO;

public class WasteToTableauView {

    public void interact(WasteToTableauController controller) {
        IO io = new IO();
        int numTableau = io.readInt("¿A qué escalera? [1-7]:");
        while (numTableau<1 || numTableau>7){
            io.writeln("ERROR!!! El número de la escalera debe ser entre 1 y 7 inclusives");
            numTableau = io.readInt("¿A qué escalera? [1-7]:");
        }
        controller.setNumTableau(numTableau-1);
        controller.control();
    }
}
