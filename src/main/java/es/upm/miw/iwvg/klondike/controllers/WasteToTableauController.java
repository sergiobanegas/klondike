package es.upm.miw.iwvg.klondike.controllers;

import es.upm.miw.iwvg.klondike.View;
import es.upm.miw.iwvg.klondike.models.Game;
import es.upm.miw.iwvg.klondike.models.TableauPiles;

public class WasteToTableauController extends MoveController {

    public WasteToTableauController(Game game) {
        super(game);
    }

    @Override
    public void accept(View operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }

    public void control(int numTableau) {
        TableauPiles tableau = game.getTableauPile(numTableau);
        if (checkFaceUpCard(tableau) != null) {
            System.out.println("ERROR!!! La escalera no tiene cartas descubiertas");
        } else if (validateMove(numTableau) != null) {
            System.out.println("ERROR!!! Movimiento no válido");
        } else {
            game.getTableauPile(numTableau).addCard(game.getWaste().popCard());
        }
    }

    public Error checkFaceUpCard(TableauPiles tableauOrigin) {
        if (tableauOrigin.hasFaceUpCards()) {
            return null;
        }
        return Error.FLIPCARD_ERROR;
    }

    public Error validateMove(int numTableau) {
        TableauPiles tableau = game.getTableauPile(numTableau);
        if (tableau.isEmpty()) {
            if (game.getWaste().getLastCard().getValue().getValue() == "k") {
                return null;
            } else {
                return Error.NOT_VALID_MOVE;
            }
        } else if (!tableau.getLastCard().validAboveTableau(game.getWaste().getLastCard())) {
            return Error.NOT_VALID_MOVE;
        }
        return null;
    }

}
