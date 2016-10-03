package es.upm.miw.iwvg.klondike.controllers;

import java.util.Stack;

import es.upm.miw.iwvg.klondike.View;
import es.upm.miw.iwvg.klondike.models.Card;
import es.upm.miw.iwvg.klondike.models.Game;
import es.upm.miw.iwvg.klondike.models.TableauPiles;
import es.upm.miw.iwvg.klondike.views.MoveView;

public class TableauToTableauController extends MoveController {

    private int numTableauTarget, numTableauOrigin, numCards;

    public TableauToTableauController(Game game) {
        super(game);
    }

    @Override
    public void accept(View operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }

    @Override
    public void control() {
        TableauPiles tableauOrigin = getTableauPile(numTableauOrigin);
        TableauPiles tableauTarget = getTableauPile(numTableauTarget);
        if (checkFaceUpCard(tableauOrigin) != null) {
            System.out.println("ERROR!!! La escalera origen no tiene cartas descubiertas");
        } else if (checkFaceUpCard(tableauTarget) != null) {
            System.out.println("ERROR!!! La escalera destino no tiene cartas descubiertas");
        } else if (validateMove() != null) {
            System.out.println("ERROR!!! Movimiento no válido");
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
                return Error.NOT_VALID_MOVE;
            }
        } else {
            if (tableauOrigin.getFaceUpCardsNumber() < numCards) {
                return Error.NOT_VALID_MOVE;
            } else if (!getLastCardTableauPile(tableauTarget).validAboveTableau(tableauOrigin.getFaceUpCard(numCards))) {
                return Error.NOT_VALID_MOVE;
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

    public Error checkFaceUpCard(TableauPiles tableauOrigin) {
        if (tableauOrigin.hasFaceUpCards()) {
            return null;
        }
        return Error.FLIPCARD_ERROR;
    }

    @Override
    public void acceptMove(MoveView view) {
        view.visit(this);
    }

}
