package es.upm.miw.iwvg.klondike.views;

import es.upm.miw.iwvg.klondike.controllers.FoundationToTableauController;
import es.upm.miw.iwvg.klondike.utils.IO;

public class FoundationToTableauView {

    public void interact(FoundationToTableauController controller) {
        IO io = new IO();
        int numFoundation = io.readInt("¿De qué palo? [1-4]:");
        while (numFoundation<1 || numFoundation>4){
            io.writeln("ERROR!!! El número del palo debe ser entre 1 y 4 inclusives");
            numFoundation = io.readInt("¿De qué palo? [1-4]:");
        }
        
        int numTableau = io.readInt("¿A qué escalera? [1-7]:");
        while (numTableau<1 || numTableau>7){
            io.writeln("ERROR!!! El número de la escalera debe ser entre 1 y 7 inclusives");
            numTableau = io.readInt("¿A qué escalera? [1-7]:");
        }
        
        controller.control(numFoundation - 1, numTableau - 1);
    }
}
