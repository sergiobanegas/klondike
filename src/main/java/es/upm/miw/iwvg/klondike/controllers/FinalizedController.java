package es.upm.miw.iwvg.klondike.controllers;

import es.upm.miw.iwvg.klondike.View;
import es.upm.miw.iwvg.klondike.models.State;

public class FinalizedController extends OperationController {

    public FinalizedController() {
        super();
    }

    public void control() {
        game.setState(State.FINALIZED);
    }

    @Override
    public void accept(View view) {
        view.visit(this);
    }

}
