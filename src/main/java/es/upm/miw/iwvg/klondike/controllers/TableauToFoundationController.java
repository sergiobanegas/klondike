package es.upm.miw.iwvg.klondike.controllers;

import es.upm.miw.iwvg.klondike.View;
import es.upm.miw.iwvg.klondike.models.TableauPiles;
import es.upm.miw.iwvg.klondike.views.MoveView;

public class TableauToFoundationController extends MoveController {

    private int numTableau, numFoundation;

    public TableauToFoundationController() {
        super();
    }

    @Override
    public void accept(View operationControllerVisitor) {
        operationControllerVisitor.visitMove(this);
    }

    @Override
    public void control() {
        TableauPiles tableauOrigin = getTableauPile(numTableau);
        if (checkFaceUpCard(tableauOrigin) != null) {
            System.out.println(checkFaceUpCard(tableauOrigin));
        } else if (validateMove() != null) {
            System.out.println(validateMove());
        } else {
            getFoundation(numFoundation).addCard(getLastCardTableauPile(getTableauPile(numTableau)));
            super.control();
        }
    }

    @Override
    public Error validateMove() {
        if (getFoundation(numFoundation).sameSuit(getLastCardTableauPile(getTableauPile(numTableau)))) {
            if (getFoundation(numFoundation).isEmpty()) {
                if (isCardValue(getLastCardTableauPile(getTableauPile(numTableau)), "A")) {
                    return null;
                }
                return new Error(ErrorEnum.NOT_VALID_MOVE);
            } else if (!getLastCard(getFoundation(numFoundation))
                    .validAboveFoundation(getLastCardTableauPile(getTableauPile(numFoundation)))) {
                return new Error(getLastCardTableauPile(getTableauPile(numTableau)), getLastCard(getFoundation(numFoundation)));
            }
            return null;
        }
        return new Error(getLastCardTableauPile(getTableauPile(numTableau)), getLastCard(getFoundation(numFoundation)));
    }

    public void setNumTableau(int numTableau) {
        this.numTableau = numTableau;
    }

    public void setNumFoundation(int numFoundation) {
        this.numFoundation = numFoundation;
    }

    public Error checkFaceUpCard(TableauPiles tableauOrigin) {
        if (tableauOrigin.hasFaceUpCards()) {
            return null;
        }
        return new Error(ErrorEnum.NO_FACEUP_CARDS);
    }

    @Override
    public void acceptMove(MoveView view) {
        view.visit(this);
    }

}
