package es.upm.miw.iwvg.klondike;

import es.upm.miw.iwvg.klondike.controllers.ControllerInterface;
import es.upm.miw.iwvg.klondike.controllers.ExitController;
import es.upm.miw.iwvg.klondike.controllers.FinalizedController;
import es.upm.miw.iwvg.klondike.controllers.MoveController;
import es.upm.miw.iwvg.klondike.controllers.StartController;
import es.upm.miw.iwvg.klondike.views.ExitView;
import es.upm.miw.iwvg.klondike.views.FinalizedView;
import es.upm.miw.iwvg.klondike.views.MoveView;
import es.upm.miw.iwvg.klondike.views.StartView;
import es.upm.miw.iwvg.klondike.views.ViewInterface;

public class View implements ViewInterface {

    private StartView startView;

    private MoveView moveView;

    private ExitView exitView;

    private FinalizedView finalizedView;

    public View() {
        startView = new StartView();
        moveView = new MoveView();
        exitView = new ExitView();
        finalizedView = new FinalizedView();
    }

    @Override
    public void interact(ControllerInterface operationController) {
        assert operationController != null;
        operationController.accept(this);
    }

    public void visitStart(StartController startController) {
        startView.interact(startController);
    }

    public void visitMove(MoveController moveController) {
        moveView.interact(moveController);
    }

    public void visitExit(ExitController exitController) {
        exitView.interact(exitController);
    }

    public void visitFinalized(FinalizedController finalizedController) {
        finalizedView.interact(finalizedController);
    }

}
