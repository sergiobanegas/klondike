package es.upm.miw.iwvg.klondike.controllers;

import es.upm.miw.iwvg.klondike.View;
import es.upm.miw.iwvg.klondike.models.TableauPiles;
import es.upm.miw.iwvg.klondike.views.MoveView;

public class FlipCardController extends MoveController {

    private int numTableau;

    public FlipCardController() {
        super();
    }

    @Override
    public void accept(View operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }

    @Override
    public void control() {
        TableauPiles tableau = getTableauPile(numTableau);
        Error error = validateMove();
        if (tableau.isEmpty()) {
            System.out.println(new Error(ErrorEnum.TABLEAU_EMPTY));
        } else if (validateMove() != null) {
            System.out.println(error);
        } else {
            tableau.flipCard();
        }
    }

    @Override
    public Error validateMove() {
        if ((getTableauPile(numTableau).getCardsFaceUp().isEmpty())) {// FIXME
            if (getTableauPile(numTableau).getCardsFaceDown().isEmpty()) {
                return new Error(ErrorEnum.NO_FACEDOWN_CARDS);
            } else {
                return null;
            }

        }
        return new Error(ErrorEnum.EXISTS_FACEUP_CARDS);
    }

    public void setNumTableau(int numTableau) {
        this.numTableau = numTableau;
    }

    @Override
    public void acceptMove(MoveView view) {
        view.visit(this);
    }

}
