package es.upm.miw.iwvg.klondike;

import es.upm.miw.iwvg.klondike.controllers.DeckToWasteController;
import es.upm.miw.iwvg.klondike.controllers.OperationController;
import es.upm.miw.iwvg.klondike.controllers.StartController;
import es.upm.miw.iwvg.klondike.controllers.TableauToFoundationController;
import es.upm.miw.iwvg.klondike.controllers.WasteToDeckController;
import es.upm.miw.iwvg.klondike.controllers.WasteToFoundationController;
import es.upm.miw.iwvg.klondike.controllers.WasteToTableauController;
import es.upm.miw.iwvg.klondike.views.DeckToWasteView;
import es.upm.miw.iwvg.klondike.views.StartView;
import es.upm.miw.iwvg.klondike.views.TableauToFoundationView;
import es.upm.miw.iwvg.klondike.views.WasteToDeckView;
import es.upm.miw.iwvg.klondike.views.WasteToFoundationView;
import es.upm.miw.iwvg.klondike.views.WasteToTableauView;

public class View{

    private StartView startView;
    
    private WasteToFoundationView wasteToFoundationView;
    
    private WasteToDeckView wasteToDeckView;
    
    private WasteToTableauView wasteToTableauView;

    private DeckToWasteView deckToWasteView;
    
    private TableauToFoundationView tableauToFoundationView;
        
    public View() {
        startView = new StartView();
        deckToWasteView = new DeckToWasteView();
        wasteToDeckView = new WasteToDeckView();
        wasteToTableauView = new WasteToTableauView();
        wasteToFoundationView = new WasteToFoundationView();
        tableauToFoundationView = new TableauToFoundationView();
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
    
    public void visit(WasteToTableauController wasteToTableauController) {
        wasteToTableauView.interact(wasteToTableauController);
    }
    
    public void visit(TableauToFoundationController tableauToFoundationController) {
        tableauToFoundationView.interact(tableauToFoundationController);
    }

}
