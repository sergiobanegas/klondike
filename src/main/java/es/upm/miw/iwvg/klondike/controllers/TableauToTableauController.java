package es.upm.miw.iwvg.klondike.controllers;

import java.util.Stack;

import es.upm.miw.iwvg.klondike.View;
import es.upm.miw.iwvg.klondike.models.Card;
import es.upm.miw.iwvg.klondike.models.Game;
import es.upm.miw.iwvg.klondike.models.TableauPiles;

public class TableauToTableauController extends MoveController {

    public TableauToTableauController(Game game) {
        super(game);
    }

    @Override
    public void accept(View operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }

    public void control(int numTableauOrigin, int numCards, int numTableauTarget) {
        TableauPiles tableauOrigin = game.getTableauPile(numTableauOrigin);
        TableauPiles tableauTarget = game.getTableauPile(numTableauTarget);
        if (checkFaceUpCard(tableauOrigin) != null) {
            System.out.println("ERROR!!! La escalera origen no tiene cartas descubiertas");
        } else if (checkFaceUpCard(tableauTarget) != null) {
            System.out.println("ERROR!!! La escalera destino no tiene cartas descubiertas");
        } else if (validateMove(numTableauOrigin, numCards, numTableauTarget) != null) {
            System.out.println("ERROR!!! Movimiento no válido");
        } else {
            Stack<Card> stackAux = new Stack<Card>();
            for (int i = 0; i < numCards; i++) {
                stackAux.push(tableauOrigin.popCard());
            }
            while (!stackAux.isEmpty()) {
                tableauTarget.addCard(stackAux.pop());
            }
        }
    }

    public Error checkFaceUpCard(TableauPiles tableauOrigin) {
        if (tableauOrigin.hasFaceUpCards()) {
            return null;
        }
        return Error.FLIPCARD_ERROR;
    }

    public Error validateMove(int numTableauOrigin, int numCards, int numTableauTarget) {
        TableauPiles tableauOrigin = game.getTableauPile(numTableauOrigin);
        TableauPiles tableauTarget = game.getTableauPile(numTableauTarget);
        if (tableauTarget.isEmpty()) {
            if (tableauOrigin.getCardsFaceUp().get(numCards - 1).getValue().getValue() == "K") {
                return null;
            } else {
                return Error.NOT_VALID_MOVE;
            }
        } else {
            if (!tableauTarget.getLastCard()
                    .validAboveTableau(tableauOrigin.getCardsFaceUp().get(tableauOrigin.getCardsFaceUp().size() - numCards))) {
                return Error.NOT_VALID_MOVE;
            }
        }
        return null;
    }

}
