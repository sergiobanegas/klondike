package es.upm.miw.iwvg.klondike.controllers;

import es.upm.miw.iwvg.klondike.View;
import es.upm.miw.iwvg.klondike.models.Game;

public class WasteToFoundationController extends MoveController {

    public WasteToFoundationController(Game game) {
        super(game);
    }

    @Override
    public void accept(View operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }

    public void control(int numFoundation) {
        if (validateMove(numFoundation) != null) {
            System.out.println("ERROR: movimiento no válido");
        } else {
            game.getFoundation(numFoundation).addCard(game.getWaste().popCard());
        }
    }

    public Error validateMove(int numFoundation) {
        if (game.getFoundation(numFoundation).sameSuit(game.getWaste().getLastCard())) {
            if (game.getFoundation(numFoundation).isEmpty()) {
                if (game.getWaste().getLastCard().getValue().getValue() == "A") {
                    return null;
                }
                return Error.NOT_VALID_MOVE;
            } else if (!game.getFoundation(numFoundation).getLastCard().validAboveFoundation(game.getWaste().getLastCard())) {
                return Error.INVALID_CARD;
            }
            return null;
        }
        return Error.INVALID_SUIT;
    }

}
