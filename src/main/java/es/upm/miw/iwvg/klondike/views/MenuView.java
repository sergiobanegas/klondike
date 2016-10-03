package es.upm.miw.iwvg.klondike.views;

import es.upm.miw.iwvg.klondike.controllers.OperationController;
import es.upm.miw.iwvg.klondike.controllers.OptionController;
import es.upm.miw.iwvg.klondike.models.Game;
import es.upm.miw.iwvg.klondike.utils.IO;

public class MenuView {
    private Game game;

    private OptionController optionController;

    public MenuView(Game game) {
        this.game = game;
        this.optionController = new OptionController(game);
    }

    public void showStatus() {
        IO io = new IO();
        io.writeln("===========================");
        io.write("Baraja: ");
        io.writeln(game.getDeckString());
        io.write("Descarte: ");
        io.writeln(game.getWasteString());
        io.write("Palo corazones: ");
        io.writeln(game.getFoundationString(0));
        io.write("Palo diamantes: ");
        io.writeln(game.getFoundationString(1));
        io.write("Palo tréboles: ");
        io.writeln(game.getFoundationString(2));
        io.write("Palo picas: ");
        io.writeln(game.getFoundationString(3));
        io.write("Escalera 1: ");
        io.writeln(game.getTableauString(0));
        io.write("Escalera 2: ");
        io.writeln(game.getTableauString(1));
        io.write("Escalera 3: ");
        io.writeln(game.getTableauString(2));
        io.write("Escalera 4: ");
        io.writeln(game.getTableauString(3));
        io.write("Escalera 5: ");
        io.writeln(game.getTableauString(4));
        io.write("Escalera 6: ");
        io.writeln(game.getTableauString(5));
        io.write("Escalera 7: ");
        io.writeln(game.getTableauString(6));
        io.writeln("===========================");
    }

    public void showMenu() {
        IO io = new IO();
        io.writeln("1. Mover de baraja a descarte");
        io.writeln("2. Mover de descarte a baraja");
        io.writeln("3. Mover de descarte a palo");
        io.writeln("4. Mover de descarte a escalera");
        io.writeln("5. Mover de escalera a palo");
        io.writeln("6. Mover de escalera a escalera");
        io.writeln("7. Mover de palo a escalera");
        io.writeln("8. Voltear en escalera");
        io.writeln("9. Salir");
    }

    public OperationController interact() {
        showStatus();
        showMenu();
        IO io = new IO();
        int numOption = io.readInt("Opción? [1-9]:");
        while (numOption > 9) {
            if (numOption > 9) {
                io.writeln("¡ERROR! Opción no válida");
            }
            numOption = io.readInt("Opción? [1-9]:");
        }
        return optionController.control(numOption);
    }
}
