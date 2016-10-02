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
        if (validateMove() != null) {
            System.out.println("ERROR!!! La baraja está vacía");
        }
        while (!game.getWaste().isEmpty()) {
            game.getDeck().addCard(game.getWaste().getCards().pop());
        }
    }

    @Override
    public Error validateMove() {
        if (game.getWaste().isEmpty()) {
            return Error.WASTE_EMPTY;
        }
        return null;
    }

    @Override
    public void acceptMove(MoveView view) {
        view.visit(this);
    }

}
