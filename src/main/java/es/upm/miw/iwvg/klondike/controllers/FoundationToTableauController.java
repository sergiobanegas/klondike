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
        TableauPiles tableau = getTableauPile(numTableau);
        if (game.isFoundationEmpty(numFoundation)) {
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
        TableauPiles tableau = getTableauPile(numTableau);
        if (tableau.isEmpty()) {
            if (isCardValue(getLastCard(getFoundation(numFoundation)), "k")) {
                return null;
            } else {
                return new Error(ErrorEnum.NOT_VALID_MOVE);
            }
        } else if (!getLastCardTableauPile(tableau).validAboveTableau(getLastCard(getFoundation(numFoundation)))) {
            return new Error(getLastCard(getFoundation(numFoundation)), getLastCardTableauPile(tableau));
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
        view.visit(this);
    }

}
