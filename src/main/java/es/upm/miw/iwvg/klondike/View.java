package es.upm.miw.iwvg.klondike;

import es.upm.miw.iwvg.klondike.controllers.ExitController;
import es.upm.miw.iwvg.klondike.controllers.MoveController;
import es.upm.miw.iwvg.klondike.controllers.OperationController;
import es.upm.miw.iwvg.klondike.controllers.StartController;
import es.upm.miw.iwvg.klondike.utils.IO;
import es.upm.miw.iwvg.klondike.views.ExitView;
import es.upm.miw.iwvg.klondike.views.MoveView;
import es.upm.miw.iwvg.klondike.views.StartView;
import es.upm.miw.iwvg.klondike.views.ViewInterface;

public class View implements ViewInterface {

    private StartView startView;

    private MoveView moveView;

    private ExitView exitView;

    public View() {
        startView = new StartView();
        moveView = new MoveView();
        exitView = new ExitView();
    }

    public boolean interact(OperationController operationController) {
        assert operationController != null;
        operationController.accept(this);
        if (operationController.isGameFinalized()) {
            new IO().writeln("ENHORABUENA, HAS GANADO!!!");
            return true;
        }
        return false;
    }

    public void visit(StartController startController) {
        startView.interact(startController);
    }

    public void visit(MoveController moveController) {
        moveView.interact(moveController);
    }

    public void visit(ExitController exitController) {
        exitView.interact(exitController);
    }

}
