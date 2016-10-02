package es.upm.miw.iwvg.klondike.controllers;

import es.upm.miw.iwvg.klondike.View;
import es.upm.miw.iwvg.klondike.models.Game;

public class ExitController extends OperationController {

    public ExitController(Game game) {
        super(game);
    }

    public void accept(View operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }

    public void control() {
        game.end();
    }


}
