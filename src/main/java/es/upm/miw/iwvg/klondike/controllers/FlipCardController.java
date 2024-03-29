package es.upm.miw.iwvg.klondike.controllers;

import es.upm.miw.iwvg.klondike.View;
import es.upm.miw.iwvg.klondike.models.TableauPiles;
import es.upm.miw.iwvg.klondike.views.MoveView;

public class FlipCardController extends MoveController {

    private int numTableau;

    public FlipCardController() {
        super();
    }

    public void setNumTableau(int numTableau) {
        assert numTableau >= 0;
        assert numTableau < 7;
        this.numTableau = numTableau;
    }

    @Override
    public void accept(View operationControllerVisitor) {
        operationControllerVisitor.visitMove(this);
    }

    @Override
    public void control() {
        TableauPiles tableau = game.getTableauPile(numTableau);
        Error error = validateMove();
        if (tableau.isEmpty()) {
            System.out.println(ErrorEnum.TABLEAU_EMPTY);
        } else if (validateMove() != null) {
            System.out.println(error);
        } else {
            tableau.flipCard();
        }
    }

    @Override
    public Error validateMove() {
        if (!game.getTableauPile(numTableau).hasFaceUpCards()) {
            if (!game.getTableauPile(numTableau).hasFaceDownCards()) {
                return new Error(ErrorEnum.NO_FACEDOWN_CARDS);
            } else {
                return null;
            }

        }
        return new Error(ErrorEnum.EXISTS_FACEUP_CARDS);
    }

    @Override
    public void acceptMove(MoveView view) {
        view.visitFlipCard(this);
    }

}
