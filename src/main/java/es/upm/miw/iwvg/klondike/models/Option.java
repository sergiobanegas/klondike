package es.upm.miw.iwvg.klondike.models;

import es.upm.miw.iwvg.klondike.controllers.DeckToWasteController;
import es.upm.miw.iwvg.klondike.views.ControllerInterface;
import es.upm.miw.iwvg.klondike.views.ViewInterface;

public class Option {

    private ControllerInterface optionControllerInterface;

    private ViewInterface viewInterface;

    public Option(int option, Game game) {
        switch (option) {
        case 1:
            optionControllerInterface = new DeckToWasteController(game);
            break;
//        case 2:
//            optionControllerInterface = new DiscardToDeckController();
//            viewInterface = new DiscardToDeckView(optionControllerInterface);
//            break;
//        case 3:
//            optionControllerInterface = new DiscardToFoundationController();
//            viewInterface = new DiscardToFoundationView(optionControllerInterface);
//            break;
//        case 4:
//            optionControllerInterface = new DiscardToPileController();
//            viewInterface = new DiscardToPileView(optionControllerInterface);
//            break;
//        case 5:
//            optionControllerInterface = new PileToFoundationController();
//            viewInterface = new PileToFoundationView(optionControllerInterface);
//            break;
//        case 6:
//            optionControllerInterface = new PileToPileController();
//            viewInterface = new PileToPileView(optionControllerInterface);
//            break;
//        case 7:
//            optionControllerInterface = new FundationToPileController();
//            viewInterface = new FoundationToPileView(optionControllerInterface);
//            break;
//        case 8:
//            optionControllerInterface = new FlipController();
//            viewInterface = new FlipView(optionControllerInterface);
//            break;
//        case 9:
//            optionControllerInterface = new QuitController();
//            viewInterface = new QuitView(optionControllerInterface);
//            break;
        }
    }
    
    public ControllerInterface getController(){
        return optionControllerInterface;
    }

    public void control() {
        viewInterface.render();
    }
}
