package es.upm.miw.iwvg.klondike.controllers;

import es.upm.miw.iwvg.klondike.View;
import es.upm.miw.iwvg.klondike.models.Game;
import es.upm.miw.iwvg.klondike.views.MoveView;

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
            getFoundation(numFoundation).addCard(popLastCardWaste());
        }
        super.control();
    }

    @Override
    public Error validateMove() {
        if (getFoundation(numFoundation).sameSuit(getLastCardWaste())) {
            if (getFoundation(numFoundation).isEmpty()) {
                if (isCardValue(getLastCardWaste(), "A")) {
                    return null;
                }
                return Error.NOT_VALID_MOVE;
            } else if (!getLastCard(getFoundation(numFoundation)).validAboveFoundation(getLastCardWaste())) {
                return Error.INVALID_CARD;
            }
            return null;
        }
        return Error.INVALID_SUIT;
    }

    public void setNumFoundation(int numFoundation) {
        this.numFoundation = numFoundation;
    }

    @Override
    public void acceptMove(MoveView view) {
        view.visit(this);
    }

}
