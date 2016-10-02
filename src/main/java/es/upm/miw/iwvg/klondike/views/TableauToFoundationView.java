package es.upm.miw.iwvg.klondike.views;

import es.upm.miw.iwvg.klondike.controllers.TableauToFoundationController;
import es.upm.miw.iwvg.klondike.utils.IO;

public class TableauToFoundationView {

    public void interact(TableauToFoundationController controller) {
        IO io = new IO();
        int numTableau = io.readInt("¿De qué escalera? [1-7]:");
        while (numTableau < 1 || numTableau > 7) {
            io.writeln("ERROR!!! El número de la escalera debe ser entre 1 y 7 inclusives");
            numTableau = io.readInt("¿De qué escalera? [1-7]:");
        }
        int numFoundation = io.readInt("¿A qué palo? [1-4]:");
        while (numFoundation < 1 || numFoundation > 4) {
            io.writeln("ERROR!!! El número del palo debe ser entre 1 y 4 inclusives");
            numFoundation = io.readInt("¿A qué palo? [1-4]:");
        }
        controller.setNumFoundation(numFoundation - 1);
        controller.setNumTableau(numTableau - 1);
        controller.control();
    }
}
