package es.upm.miw.iwvg.klondike.controllers;

import es.upm.miw.iwvg.klondike.View;
import es.upm.miw.iwvg.klondike.models.Game;
import es.upm.miw.iwvg.klondike.models.TableauPiles;
import es.upm.miw.iwvg.klondike.views.MoveView;

public class WasteToTableauController extends MoveController {

    private int numTableau;

    public WasteToTableauController(Game game) {
        super(game);
    }

    @Override
    public void accept(View operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }

    @Override
    public void control() {
        TableauPiles tableau = getTableauPile(numTableau);
        if (checkFaceUpCard(tableau) != null) {
            System.out.println("ERROR!!! La escalera no tiene cartas descubiertas");
        } else if (validateMove() != null) {
            System.out.println("ERROR!!! Movimiento no válido");
        } else {
            tableau.addCardFaceUp(popLastCardWaste());
        }
    }

    @Override
    public Error validateMove() {
        TableauPiles tableau = getTableauPile(numTableau);
        if (tableau.isEmpty()) {
            if (isCardValue(getLastCardWaste(), "K")) {
                return null;
            } else {
                return Error.NOT_VALID_MOVE;
            }
        } else if (!getLastCardTableauPile(tableau).validAboveTableau(getLastCardWaste())) {
            return Error.NOT_VALID_MOVE;
        }
        return null;
    }

    public Error checkFaceUpCard(TableauPiles tableauOrigin) {
        if (tableauOrigin.hasFaceUpCards()) {
            return null;
        }
        return Error.FLIPCARD_ERROR;
    }

    public void setNumTableau(int numTableau) {
        this.numTableau = numTableau;
    }

    @Override
    public void acceptMove(MoveView view) {
        view.visit(this);
    }

}
