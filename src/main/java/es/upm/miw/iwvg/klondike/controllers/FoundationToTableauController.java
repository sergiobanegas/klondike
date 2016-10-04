package es.upm.miw.iwvg.klondike.controllers;

import es.upm.miw.iwvg.klondike.View;
import es.upm.miw.iwvg.klondike.models.TableauPiles;
import es.upm.miw.iwvg.klondike.views.MoveView;

public class FoundationToTableauController extends MoveController {

    private int numTableau, numFoundation;

    public FoundationToTableauController() {
        super();
    }

    @Override
    public void accept(View operationControllerVisitor) {
        operationControllerVisitor.visitMove(this);
    }

    @Override
    public void control() {
        TableauPiles tableau = game.getTableauPile(numTableau);
        if (game.getFoundation(numFoundation).isEmpty()) {
            System.out.println(new Error(ErrorEnum.FOUNDATION_EMPTY));
        } else if (checkFaceUpCard(tableau) != null) {
            System.out.println(checkFaceUpCard(tableau));
        } else if (validateMove() != null) {
            System.out.println(validateMove());
        } else {
            tableau.addCardFaceUp(game.popCardFoundation(numFoundation));
        }
    }

    @Override
    public Error validateMove() {
        TableauPiles tableau = game.getTableauPile(numTableau);
        if (tableau.isEmpty()) {
            if (game.getFoundation(numFoundation).getLastCard().hasValue("K")) {
                return null;
            } else {
                return new Error(ErrorEnum.NOT_VALID_MOVE);
            }
        } else if (!tableau.getLastCard().validAboveTableau(game.getFoundation(numFoundation).getLastCard())) {
            return new Error(game.getFoundation(numFoundation).getLastCard(), tableau.getLastCard());
        }
        return null;
    }

    public Error checkFaceUpCard(TableauPiles tableauOrigin) {
        if (tableauOrigin.hasFaceUpCards()) {
            return null;
        }
        return new Error(ErrorEnum.NO_FACEUP_CARDS);
    }

    public void setNumTableau(int numTableau) {
        this.numTableau = numTableau;
    }

    public void setNumFoundation(int numFoundation) {
        this.numFoundation = numFoundation;
    }

    @Override
    public void acceptMove(MoveView view) {
        view.visitFoundationToTableau(this);
    }

}
