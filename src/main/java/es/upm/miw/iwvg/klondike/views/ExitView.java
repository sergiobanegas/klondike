package es.upm.miw.iwvg.klondike.views;

import es.upm.miw.iwvg.klondike.controllers.OperationController;
import es.upm.miw.iwvg.klondike.utils.IO;

public class ExitView implements ViewInterface {

    @Override
    public void interact(OperationController controller) {
        IO io = new IO();
        int answer = io.readInt("¿Estás seguro de terminar el juego? (0-no, 1-sí)");
        while ((answer != 0) && (answer != 1)) {
            io.writeln("Por favor, introduzca un número válido.");
            io.readInt("¿Estás seguro de terminar el juego? (0-no, 1-sí)");
        }
        if (answer == 1) {
            io.writeln("Adios!!!");
            controller.control();
        }
    }
}
