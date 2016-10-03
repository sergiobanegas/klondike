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

    public Option(int option) {
        switch (option) {
        case 1:
            optionControllerInterface = new DeckToWasteController();
            break;
        case 2:
            optionControllerInterface = new WasteToDeckController();
            break;
        case 3:
            optionControllerInterface = new WasteToFoundationController();
            break;
        case 4:
            optionControllerInterface = new WasteToTableauController();
            break;
        case 5:
            optionControllerInterface = new TableauToFoundationController();
            break;
        case 6:
            optionControllerInterface = new TableauToTableauController();
            break;
        case 7:
            optionControllerInterface = new FoundationToTableauController();
            break;
        case 8:
            optionControllerInterface = new FlipCardController();
            break;
        case 9:
            optionControllerInterface = new ExitController();
            break;
        }
    }

    public OperationController getController() {
        return optionControllerInterface;
    }

}
