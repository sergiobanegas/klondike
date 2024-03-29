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
        TableauPiles tableauOrigin = game.getTableauPile(numTableau);
        if (tableauOrigin.isEmpty()) {
            System.out.println(ErrorEnum.TABLEAU_EMPTY);
        } else if (checkFaceUpCard(tableauOrigin) != null) {
            System.out.println(checkFaceUpCard(tableauOrigin));
        } else if (validateMove() != null) {
            System.out.println(validateMove());
        } else {
            game.getFoundation(numFoundation).addCard(game.getTableauPile(numTableau).popCard());
            super.control();
        }
    }

    @Override
    public Error validateMove() {
        if (game.getFoundation(numFoundation).sameSuit(game.getTableauPile(numTableau).getLastCard())) {
            if (game.getFoundation(numFoundation).isEmpty()) {
                if (game.getTableauPile(numTableau).getLastCard().hasValue("A")) {
                    return null;
                }
                return new Error(ErrorEnum.NOT_VALID_MOVE);
            } else if (!game.getFoundation(numFoundation).getLastCard()
                    .validAboveFoundation(game.getTableauPile(numFoundation).getLastCard())) {
                return new Error(game.getTableauPile(numTableau).getLastCard(), game.getFoundation(numFoundation).getLastCard());
            }
            return null;
        }
        if (game.isFoundationEmpty(numFoundation)){
           return new Error(ErrorEnum.NOT_VALID_MOVE);
        }else{
            return new Error(game.getTableauPile(numTableau).getLastCard(), game.getFoundation(numFoundation).getLastCard());
        }    
    }

    public void setNumTableau(int numTableau) {
        assert numTableau >= 0;
        assert numTableau < 7;
        this.numTableau = numTableau;
    }

    public void setNumFoundation(int numFoundation) {
        assert numTableau >= 0;
        assert numTableau < 4;
        this.numFoundation = numFoundation;
    }

    public Error checkFaceUpCard(TableauPiles tableau) {
        if (tableau.hasFaceUpCards()) {
            return null;
        }
        return new Error(ErrorEnum.NO_FACEUP_CARDS);
    }

    @Override
    public void acceptMove(MoveView view) {
        view.visitTableauToFoundation(this);
    }

}
