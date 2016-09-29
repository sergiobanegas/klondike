package es.upm.miw.iwvg.klondike.views;

import es.upm.miw.iwvg.klondike.View;

public class View implements View {
	
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
		gameView.interact(moveController);
	}

	@Override
	public void visit(ContinueController continueController) {
		continueView.interact(continueController);
	}

}
