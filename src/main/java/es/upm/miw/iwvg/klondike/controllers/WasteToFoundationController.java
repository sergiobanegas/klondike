package es.upm.miw.iwvg.klondike.controllers;

import es.upm.miw.iwvg.klondike.View;
import es.upm.miw.iwvg.klondike.models.Game;

public class WasteToFoundationController extends MoveController {

    private int numFoundation;

    public WasteToFoundationController(Game game) {
        super(game);
    }

    @Override
    public void accept(View operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }

    @Override
    public void control() {
        if (validateMove() != null) {
            System.out.println("ERROR!!! Movimiento no válido");
        } else {
            game.getFoundation(numFoundation).addCard(game.getWaste().popCard());
        }
    }

    @Override
    public Error validateMove() {
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

    public void setNumFoundation(int numFoundation) {
        this.numFoundation = numFoundation;
    }

}
