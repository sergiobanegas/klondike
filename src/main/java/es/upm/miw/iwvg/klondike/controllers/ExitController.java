package es.upm.miw.iwvg.klondike.controllers;

import es.upm.miw.iwvg.klondike.View;
import es.upm.miw.iwvg.klondike.models.Game;
import es.upm.miw.iwvg.klondike.models.State;

public class ExitController extends OperationController {

    public ExitController(Game game) {
        super(game);
    }

    public void control() {
        game.end();
        setState(State.EXIT);
    }

    @Override
    public void accept(View view) {
        view.visit(this);
    }

}
