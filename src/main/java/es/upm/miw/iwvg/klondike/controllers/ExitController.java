package es.upm.miw.iwvg.klondike.controllers;

import es.upm.miw.iwvg.klondike.View;
import es.upm.miw.iwvg.klondike.models.State;

public class ExitController extends OperationController {

    public ExitController() {
        super();
    }

    @Override
    public void control() {
        game.end();
        game.setState(State.EXIT);
    }

    @Override
    public void accept(View view) {
        view.visitExit(this);
    }

}
