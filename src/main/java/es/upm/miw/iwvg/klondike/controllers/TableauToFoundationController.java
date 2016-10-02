package es.upm.miw.iwvg.klondike.controllers;

import es.upm.miw.iwvg.klondike.View;
import es.upm.miw.iwvg.klondike.models.Game;
import es.upm.miw.iwvg.klondike.models.TableauPiles;
import es.upm.miw.iwvg.klondike.views.MoveView;

public class TableauToFoundationController extends MoveController {

    private int numTableau, numFoundation;

    public TableauToFoundationController(Game game) {
        super(game);
    }

    @Override
    public void accept(View operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }

    @Override
    public void control() {
        TableauPiles tableauOrigin = game.getTableauPile(numTableau);
        if (checkFaceUpCard(tableauOrigin) != null) {
            System.out.println("ERROR!!! La escalera no tiene cartas descubiertas");
        } else if (validateMove() != null) {
            System.out.println("ERROR!!! Movimiento no válido");
        } else {
            game.getFoundation(numFoundation).addCard(game.getTableauPile(numTableau).popCard());
        }
    }

    @Override
    public Error validateMove() {
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
        return Error.FLIPCARD_ERROR;
    }

    @Override
    public void acceptMove(MoveView view) {
        view.visit(this);
    }

}
