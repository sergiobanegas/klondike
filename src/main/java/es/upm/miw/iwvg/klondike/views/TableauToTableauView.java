package es.upm.miw.iwvg.klondike.views;

import es.upm.miw.iwvg.klondike.controllers.TableauToTableauController;
import es.upm.miw.iwvg.klondike.utils.IO;

public class TableauToTableauView {

    public void interact(TableauToTableauController controller) {
        IO io = new IO();
        int numTableauOrigin = io.readInt("¿De qué escalera? [1-7]:");
        while (numTableauOrigin < 1 || numTableauOrigin > 7) {
            io.writeln("ERROR!!! El número de la escalera debe ser entre 1 y 7 inclusives");
            numTableauOrigin = io.readInt("¿De qué escalera? [1-7]:");
        }
        int numCards = io.readInt("¿Cuántas cartas?");
        int numTableauTarget = io.readInt("¿A qué escalera? [1-7]:");
        while (numTableauTarget < 1 || numTableauTarget > 7) {
            io.writeln("ERROR!!! El número de la escalera debe ser entre 1 y 7 inclusives");
            numTableauTarget = io.readInt("¿A qué escalera? [1-7]:");
        }
        controller.control(numTableauOrigin - 1, numCards, numTableauTarget - 1);
    }
}
