package es.upm.miw.iwvg.klondike.views.console;

import es.upm.miw.iwvg.klondike.View;

public class ConsoleView implements View {
	
	private StartView startView;
	
	private GameView gameView;
	
	private ContinueView continueView;
	
	public ConsoleView(){
		startView = new StartView();
		gameView = new GameView();
		continueView = new ContinueView();
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
