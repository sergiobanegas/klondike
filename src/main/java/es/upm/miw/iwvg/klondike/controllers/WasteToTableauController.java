package es.upm.miw.iwvg.klondike.controllers;

import es.upm.miw.iwvg.klondike.View;
import es.upm.miw.iwvg.klondike.models.TableauPiles;
import es.upm.miw.iwvg.klondike.views.MoveView;

public class WasteToTableauController extends MoveController {

    private int numTableau;

    public WasteToTableauController() {
        super();
    }

    @Override
    public void accept(View operationControllerVisitor) {
        operationControllerVisitor.visitMove(this);
    }

    @Override
    public void control() {
        TableauPiles tableau = game.getTableauPile(numTableau);
        if (game.isWasteEmpty()) {
            System.out.println(ErrorEnum.WASTE_EMPTY);
        } else if (checkFaceUpCard(tableau) != null) {
            System.out.println(checkFaceUpCard(tableau));
        } else if (validateMove() != null) {
            System.out.println(validateMove());
        } else {
            tableau.addCardFaceUp(game.popCardWaste());
        }
    }

    @Override
    public Error validateMove() {
        TableauPiles tableau = game.getTableauPile(numTableau);
        if (tableau.isEmpty()) {
            if (game.getLastCardWaste().hasValue("K")) {
                return null;
            } else {
                return new Error(ErrorEnum.NOT_VALID_MOVE);
            }
        } else if (!tableau.getLastCard().validAboveTableau(game.getLastCardWaste())) {
            return new Error(game.getLastCardWaste(), tableau.getLastCard());
        }
        return null;
    }

    public Error checkFaceUpCard(TableauPiles tableauOrigin) {
        if (tableauOrigin.hasFaceUpCards()) {
            return null;
        }
        return new Error(ErrorEnum.FLIPCARD_ERROR);
    }

    public void setNumTableau(int numTableau) {
        assert numTableau >= 0;
        assert numTableau < 7;
        this.numTableau = numTableau;
    }

    @Override
    public void acceptMove(MoveView view) {
        view.visitWasteToTableau(this);
    }

}
