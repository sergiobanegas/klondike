package es.upm.miw.iwvg.klondike.models;

import es.upm.miw.iwvg.klondike.controllers.DeckToWasteController;
import es.upm.miw.iwvg.klondike.controllers.ExitController;
import es.upm.miw.iwvg.klondike.controllers.FlipCardController;
import es.upm.miw.iwvg.klondike.controllers.FoundationToTableauController;
import es.upm.miw.iwvg.klondike.controllers.OperationController;
import es.upm.miw.iwvg.klondike.controllers.TableauToFoundationController;
import es.upm.miw.iwvg.klondike.controllers.TableauToTableauController;
import es.upm.miw.iwvg.klondike.controllers.WasteToDeckController;
import es.upm.miw.iwvg.klondike.controllers.WasteToFoundationController;
import es.upm.miw.iwvg.klondike.controllers.WasteToTableauController;

public class Option {

    private OperationController optionControllerInterface;

    public Option(int option, Game game) {
        switch (option) {
        case 1:
            optionControllerInterface = new DeckToWasteController(game);
            break;
        case 2:
            optionControllerInterface = new WasteToDeckController(game);
            break;
        case 3:
            optionControllerInterface = new WasteToFoundationController(game);
            break;
        case 4:
            optionControllerInterface = new WasteToTableauController(game);
            break;
        case 5:
            optionControllerInterface = new TableauToFoundationController(game);
            break;
        case 6:
            optionControllerInterface = new TableauToTableauController(game);
            break;
        case 7:
            optionControllerInterface = new FoundationToTableauController(game);
            break;
        case 8:
            optionControllerInterface = new FlipCardController(game);
            break;
        case 9:
            optionControllerInterface = new ExitController(game);
            break;
        }
    }

    public OperationController getController() {
        return optionControllerInterface;
    }

}
