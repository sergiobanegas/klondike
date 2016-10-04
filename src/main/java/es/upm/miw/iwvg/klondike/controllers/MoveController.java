package es.upm.miw.iwvg.klondike.controllers;

import es.upm.miw.iwvg.klondike.View;
import es.upm.miw.iwvg.klondike.models.State;
import es.upm.miw.iwvg.klondike.views.MoveView;

public abstract class MoveController extends OperationController {

    public void control() {
        if (game.isGameFinalized()) {
            game.setState(State.FINALIZED);
        }
    }

    abstract Error validateMove();

    public abstract void acceptMove(MoveView view);

    @Override
    public void accept(View view) {
        view.visitMove(this);
    }

}
