package es.upm.miw.iwvg.klondike.controllers;

import java.util.Stack;

import es.upm.miw.iwvg.klondike.View;
import es.upm.miw.iwvg.klondike.models.Card;
import es.upm.miw.iwvg.klondike.models.TableauPiles;
import es.upm.miw.iwvg.klondike.views.MoveView;

public class TableauToTableauController extends MoveController {

    private int numTableauTarget, numTableauOrigin, numCards;

    public TableauToTableauController() {
        super();
    }

    @Override
    public void accept(View operationControllerVisitor) {
        operationControllerVisitor.visitMove(this);
    }

    @Override
    public void control() {
        TableauPiles tableauOrigin = game.getTableauPile(numTableauOrigin);
        TableauPiles tableauTarget = game.getTableauPile(numTableauTarget);
        if (tableauOrigin.isEmpty()) {
            System.out.println(ErrorEnum.TABLEAU_EMPTY);
        } else if (checkFaceUpCard(tableauOrigin) != null) {
            System.out.println(checkFaceUpCard(tableauOrigin));
        } else if (checkFaceUpCard(tableauTarget) != null) {
            System.out.println(checkFaceUpCard(tableauTarget));
        } else if (validateMove() != null) {
            System.out.println(validateMove());
        } else {
            Stack<Card> stackAux = new Stack<Card>();
            for (int i = 0; i < numCards; i++) {
                stackAux.push(tableauOrigin.popCard());
            }
            while (!stackAux.isEmpty()) {
                tableauTarget.addCardFaceUp(stackAux.pop());
            }
        }
    }

    @Override
    public Error validateMove() {
        TableauPiles tableauOrigin = game.getTableauPile(numTableauOrigin);
        TableauPiles tableauTarget = game.getTableauPile(numTableauTarget);
        if (tableauTarget.isEmpty()) {
            if (tableauOrigin.getFaceUpCard(numCards - 1).hasValue("K")) {
                return null;
            } else {
                return new Error(ErrorEnum.NOT_VALID_MOVE);
            }
        } else {
            if (tableauOrigin.getFaceUpCardsNumber() < numCards) {
                return new Error(ErrorEnum.NOT_ENOUGH_CARDS);
            } else if (!tableauTarget.getLastCard().validAboveTableau(tableauOrigin.getFaceUpCard(numCards))) {
                return new Error(tableauOrigin.getFaceUpCard(numCards), tableauTarget.getLastCard());
            }
        }
        return null;
    }

    public void setNumTableauOrigin(int numTableauOrigin) {
        assert numTableauOrigin >= 0;
        assert numTableauOrigin < 7;
        this.numTableauOrigin = numTableauOrigin;
    }

    public void setNumTableauTarget(int numTableauTarget) {
        assert numTableauTarget >= 0;
        assert numTableauTarget < 7;
        this.numTableauTarget = numTableauTarget;
    }

    public void setNumCards(int numCards) {
        assert numCards >= 0;
        this.numCards = numCards;
    }

    public Error checkFaceUpCard(TableauPiles tableau) {
        if (tableau.hasFaceUpCards()) {
            return null;
        }
        return new Error(ErrorEnum.NO_FACEUP_CARDS);
    }

    @Override
    public void acceptMove(MoveView view) {
        view.visitTableauToTableau(this);
    }

}
