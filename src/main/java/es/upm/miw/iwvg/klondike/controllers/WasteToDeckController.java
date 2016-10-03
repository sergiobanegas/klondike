package es.upm.miw.iwvg.klondike.controllers;

import es.upm.miw.iwvg.klondike.View;
import es.upm.miw.iwvg.klondike.models.Game;
import es.upm.miw.iwvg.klondike.views.ControllerInterface;
import es.upm.miw.iwvg.klondike.views.MoveView;

public class WasteToDeckController extends MoveController implements ControllerInterface {

    public WasteToDeckController(Game game) {
        super(game);
    }

    @Override
    public void accept(View operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }

    @Override
    public void control() {
        Error error = validateMove();
        if (error != null) {
            System.out.println(error);
        }
        while (!game.isWasteEmpty()) {
            game.addCardDeck(popLastCardWaste());
        }
    }

    @Override
    public Error validateMove() {
        if (isWasteEmpty()) {
            return new Error(ErrorEnum.WASTE_EMPTY);
        }
        return null;
    }

    @Override
    public void acceptMove(MoveView view) {
        view.visit(this);
    }

}
