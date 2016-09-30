package es.upm.miw.iwvg.klondike;

import es.upm.miw.iwvg.klondike.controllers.DeckToWasteController;
import es.upm.miw.iwvg.klondike.controllers.OperationController;
import es.upm.miw.iwvg.klondike.controllers.StartController;
import es.upm.miw.iwvg.klondike.controllers.WasteToDeckController;
import es.upm.miw.iwvg.klondike.controllers.WasteToFoundationController;
import es.upm.miw.iwvg.klondike.views.DeckToWasteView;
import es.upm.miw.iwvg.klondike.views.StartView;
import es.upm.miw.iwvg.klondike.views.WasteToDeckView;
import es.upm.miw.iwvg.klondike.views.WasteToFoundationView;

public class View{

    private StartView startView;
    
    private WasteToFoundationView wasteToFoundationView;
    
    private WasteToDeckView wasteToDeckView;

    private DeckToWasteView deckToWasteView;
    
    public View() {
        startView = new StartView();
        deckToWasteView = new DeckToWasteView();
        wasteToDeckView = new WasteToDeckView();
        wasteToFoundationView = new WasteToFoundationView();
        wasteToFoundationView = new WasteToFoundationView();
    }
    
    public void interact(OperationController operationController) {
        assert operationController != null;
        operationController.accept(this);
    }

    public void visit(StartController startController) {
        startView.start(startController);
    }

    public void visit(DeckToWasteController deckToWasteController) {
        deckToWasteView.interact(deckToWasteController);
    }
    
    public void visit(WasteToDeckController wasteToDeckController) {
        wasteToDeckView.interact(wasteToDeckController);
    }
    
    public void visit(WasteToFoundationController wasteToFoundationController) {
        wasteToFoundationView.interact(wasteToFoundationController);
    }

}
