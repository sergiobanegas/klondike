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
        TableauPiles tableauOrigin = getTableauPile(numTableauOrigin);
        TableauPiles tableauTarget = getTableauPile(numTableauTarget);
        if (checkFaceUpCard(tableauOrigin) != null) {
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
        TableauPiles tableauOrigin = getTableauPile(numTableauOrigin);
        TableauPiles tableauTarget = getTableauPile(numTableauTarget);
        if (tableauTarget.isEmpty()) {
            if (isCardValue(tableauOrigin.getFaceUpCard(numCards - 1), "K")) {
                return null;
            } else {
                return new Error(ErrorEnum.NOT_VALID_MOVE);
            }
        } else {
            if (tableauOrigin.getFaceUpCardsNumber() < numCards) {
                return new Error(ErrorEnum.NOT_ENOUGH_CARDS);
            } else if (!getLastCardTableauPile(tableauTarget).validAboveTableau(tableauOrigin.getFaceUpCard(numCards))) {
                return new Error(tableauOrigin.getFaceUpCard(numCards), getLastCardTableauPile(tableauTarget));
            }
        }
        return null;
    }

    public void setNumTableauOrigin(int numTableauOrigin) {
        this.numTableauOrigin = numTableauOrigin;
    }

    public void setNumTableauTarget(int numTableauTarget) {
        this.numTableauTarget = numTableauTarget;
    }

    public void setNumCards(int numCards) {
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
        view.visit(this);
    }

}
