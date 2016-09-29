package es.upm.miw.iwvg.klondike;

import es.upm.miw.iwvg.klondike.controllers.OperationController;

public class View {
    
    private StartView startView;
    
    private MoveView moveView;
    
    private ExitView exitView;
    
    public View(){
        startView = new StartView();
        moveView = new MoveView();
        exitView = new ExitView();
    }

    public void interact(OperationController operationController) {
        assert operationController != null;
        operationController.accept(this);
    }
    
    @Override
    public void visit(StartController startController) {
        startView.interact(startController);
    }
    
    @Override
    public void visit(MoveController moveController) {
        moveView.interact(moveController);
    }

    @Override
    public void visit(ExitController exitController) {
        exitView.interact(exitController);
    }

}
