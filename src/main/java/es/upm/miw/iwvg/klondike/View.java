package es.upm.miw.iwvg.klondike;

import es.upm.miw.iwvg.klondike.controllers.DeckToWasteController;
import es.upm.miw.iwvg.klondike.controllers.MoveController;
import es.upm.miw.iwvg.klondike.controllers.OperationController;
import es.upm.miw.iwvg.klondike.controllers.StartController;
import es.upm.miw.iwvg.klondike.views.GameView;
import es.upm.miw.iwvg.klondike.views.StartView;
import es.upm.miw.iwvg.klondike.views.ViewInterface;

public class View{

    private StartView startView;

    private GameView gameView;

    // private ExitView exitView;

    public View() {
        startView = new StartView();
        gameView = new GameView();
        // exitView = new ExitView();
    }
    
    public void interact(OperationController operationController) {
        assert operationController != null;
        operationController.accept(this);
    }

    public void visit(StartController startController) {
        startView.start(startController);
    }

    public void visit(DeckToWasteController deckToWasteController) {
        gameView.interact(deckToWasteController);
    }
    //
    // public void visit(ExitController exitController) {
    // exitView.interact(exitController);
    // }

}
