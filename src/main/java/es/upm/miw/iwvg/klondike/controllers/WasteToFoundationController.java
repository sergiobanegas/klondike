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
        operationControllerVisitor.visitMove(this);
    }

    @Override
    public void control() {
        if (game.isWasteEmpty()) {
            System.out.println(ErrorEnum.WASTE_EMPTY);
        } else if (validateMove() != null) {
            System.out.println(validateMove());
        } else {
            game.getFoundation(numFoundation).addCard(game.popCardWaste());
            super.control();
        }
    }

    @Override
    public Error validateMove() {
        if (game.getFoundation(numFoundation).sameSuit(game.getLastCardWaste())) {
            if (game.getFoundation(numFoundation).isEmpty()) {
                if (game.getLastCardWaste().hasValue("A")) {
                    return null;
                }
                return new Error(ErrorEnum.NOT_VALID_MOVE);
            } else if (!game.getFoundation(numFoundation).getLastCard().validAboveFoundation(game.getLastCardWaste())) {
                return new Error(game.getLastCardWaste(), game.getFoundation(numFoundation).getLastCard());
            }
            return null;
        } else if (game.getFoundation(numFoundation).isEmpty()){
            return new Error(ErrorEnum.NOT_VALID_MOVE);
        }else{
            return new Error(game.getLastCardWaste(), game.getFoundation(numFoundation).getLastCard());
        }
        
    }

    public void setNumFoundation(int numFoundation) {
        assert numFoundation >= 0;
        assert numFoundation < 4;
        this.numFoundation = numFoundation;
    }

    @Override
    public void acceptMove(MoveView view) {
        view.visitWasteToFoundation(this);
    }

}
