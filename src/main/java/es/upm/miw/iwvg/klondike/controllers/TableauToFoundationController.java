package es.upm.miw.iwvg.klondike.controllers;

import es.upm.miw.iwvg.klondike.View;
import es.upm.miw.iwvg.klondike.models.Game;

public class TableauToFoundationController extends MoveController {

    public TableauToFoundationController(Game game) {
        super(game);
    }

    @Override
    public void accept(View operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }

    public void control(int numTableau, int numFoundation) {
        if (validateMove(numTableau, numFoundation) != null) {
            System.out.println("ERROR: movimiento no válido");
        } else {
            game.getFoundation(numFoundation).addCard(game.getTableauPile(numTableau).popCard());
        }
    }

    public Error validateMove(int numTableau, int numFoundation) {
        if (game.getFoundation(numFoundation).sameSuit(game.getTableauPile(numTableau).getLastCard())) {
            if (game.getFoundation(numFoundation).isEmpty()) {
                if (game.getTableauPile(numTableau).getLastCard().getValue().getValue() == "A") {
                    return null;
                }
                return Error.NOT_VALID_MOVE;
            } else if (!game.getFoundation(numFoundation).getLastCard()
                    .validAboveFoundation(game.getTableauPile(numFoundation).getLastCard())) {
                return Error.INVALID_CARD;
            }
            return null;
        }
        return Error.INVALID_SUIT;
    }

}
