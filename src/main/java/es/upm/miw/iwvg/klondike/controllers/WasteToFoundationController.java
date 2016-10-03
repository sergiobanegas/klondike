package es.upm.miw.iwvg.klondike.controllers;

import es.upm.miw.iwvg.klondike.View;
import es.upm.miw.iwvg.klondike.views.MoveView;

public class WasteToFoundationController extends MoveController {

    private int numFoundation;

    public WasteToFoundationController() {
        super();
    }

    @Override
    public void accept(View operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }

    @Override
    public void control() {
        if (isWasteEmpty()) {
            System.out.println(ErrorEnum.WASTE_EMPTY);
        } else if (validateMove() != null) {
            System.out.println(validateMove());
        } else {
            getFoundation(numFoundation).addCard(popLastCardWaste());
            super.control();
        }
    }

    @Override
    public Error validateMove() {
        if (getFoundation(numFoundation).sameSuit(getLastCardWaste())) {
            if (getFoundation(numFoundation).isEmpty()) {
                if (isCardValue(getLastCardWaste(), "A")) {
                    return null;
                }
                return new Error(ErrorEnum.NOT_VALID_MOVE);
            } else if (!getLastCard(getFoundation(numFoundation)).validAboveFoundation(getLastCardWaste())) {
                return new Error(getLastCardWaste(), getLastCard(getFoundation(numFoundation)));
            }
            return null;
        }
        return new Error(getLastCardWaste(), getLastCard(getFoundation(numFoundation)));
    }

    public void setNumFoundation(int numFoundation) {
        this.numFoundation = numFoundation;
    }

    @Override
    public void acceptMove(MoveView view) {
        view.visit(this);
    }

}
