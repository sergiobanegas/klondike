package es.upm.miw.iwvg.klondike.controllers;

import es.upm.miw.iwvg.klondike.View;
import es.upm.miw.iwvg.klondike.views.MoveView;

public class WasteToDeckController extends MoveController {

    public WasteToDeckController() {
        super();
    }

    @Override
    public void accept(View operationControllerVisitor) {
        operationControllerVisitor.visitMove(this);
    }

    @Override
    public void control() {
        Error error = validateMove();
        if (error != null) {
            System.out.println(error);
        }
        while (!game.isWasteEmpty()) {
            game.addCardDeck(game.popCardWaste());
        }
    }

    @Override
    public Error validateMove() {
        if (game.isWasteEmpty()) {
            return new Error(ErrorEnum.WASTE_EMPTY);
        }
        return null;
    }

    @Override
    public void acceptMove(MoveView view) {
        view.visitWasteToDeck(this);
    }

}
