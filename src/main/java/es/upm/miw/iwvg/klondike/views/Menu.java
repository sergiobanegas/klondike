package es.upm.miw.iwvg.klondike.views;

import es.upm.miw.iwvg.klondike.controllers.OperationController;
import es.upm.miw.iwvg.klondike.controllers.OptionController;
import es.upm.miw.iwvg.klondike.models.Game;
import es.upm.miw.iwvg.klondike.utils.IO;

public class Menu {
    private Game game;
    private OptionController optionController;
    
    public Menu(Game game) {
        this.game = game;
        this.optionController=new OptionController(game);
    }

    public void showStatus() {
        IO io = new IO();
        io.writeln("===========================");
        io.write("Baraja: ");
        io.writeln(game.getDeck().toString());      
        io.writeln(game.getDeck().getCards().toString());  
        io.write("Descarte: ");
        io.writeln(game.getWaste().toString());
        io.write("Palo corazones: ");
        io.writeln(game.getFoundation(0).toString());
        io.write("Palo diamantes: ");
        io.writeln(game.getFoundation(1).toString());
        io.write("Palo tréboles: ");
        io.writeln(game.getFoundation(2).toString());
        io.write("Palo picas: ");
        io.writeln(game.getFoundation(3).toString());
        io.write("Escalera 1: ");
        io.writeln(game.getTableauPile(0).toString());
        io.write("Escalera 2: ");
        io.writeln(game.getTableauPile(1).toString());
        io.write("Escalera 3: ");
        io.writeln(game.getTableauPile(2).toString());
        io.write("Escalera 4: ");
        io.writeln(game.getTableauPile(3).toString());
        io.write("Escalera 5: ");
        io.writeln(game.getTableauPile(4).toString());
        io.write("Escalera 6: ");
        io.writeln(game.getTableauPile(5).toString());
        io.write("Escalera 7: ");
        io.writeln(game.getTableauPile(6).toString());
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

    public OperationController render() {
            showStatus();
            showMenu();
            IO io = new IO();           
            int numOption = io.readInt("Opción? [1-9]:");
            while (numOption>9){
                if (numOption > 9) {
                    io.writeln("¡ERROR! Opción no válida");
                }
                numOption = io.readInt("Opción? [1-9]:");
            }     
            return optionController.control(numOption);
    }
}
