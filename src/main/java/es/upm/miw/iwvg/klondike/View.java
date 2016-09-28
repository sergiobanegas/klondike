package es.upm.miw.iwvg.klondike;

import es.upm.miw.iwvg.klondike.controllers.OperationController;
import es.upm.miw.iwvg.klondike.controllers.OperationControllerVisitor;

public interface View extends OperationControllerVisitor {

	public void interact(OperationController operationController);
}
