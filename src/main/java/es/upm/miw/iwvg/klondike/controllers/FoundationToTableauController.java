package es.upm.miw.iwvg.klondike.controllers;

import es.upm.miw.iwvg.klondike.View;
import es.upm.miw.iwvg.klondike.models.Game;
import es.upm.miw.iwvg.klondike.models.TableauPiles;
import es.upm.miw.iwvg.klondike.views.MoveView;

public class FoundationToTableauController extends MoveController {

    private int numTableau, numFoundation;

    public FoundationToTableauController(Game game) {
        super(game);
    }

    @Override
    public void accept(View operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }

    @Override
    public void control() {
        TableauPiles tableau = game.getTableauPile(numTableau);
        if (checkFaceUpCard(tableau) != null) {
            System.out.println("ERROR!!! La escalera no tiene cartas descubiertas");
        }
        if (validateMove() != null) {
            System.out.println("ERROR!!! Movimiento no válido");
        } else {
            game.getTableauPile(numTableau).addCard(game.getFoundation(numFoundation).popCard());
        }
    }

    @Override
    public Error validateMove() {
        TableauPiles tableau = game.getTableauPile(numTableau);
        if (tableau.isEmpty()) {
            if (game.getFoundation(numFoundation).getLastCard().getValue().getValue() == "k") {
                return null;
            } else {
                return Error.NOT_VALID_MOVE;
            }
        } else if (!tableau.getLastCard().validAboveTableau(game.getFoundation(numFoundation).getLastCard())) {
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

    public void setNumFoundation(int numFoundation) {
        this.numFoundation = numFoundation;
    }
    
    @Override
    public void acceptMove(MoveView view) {
        view.visit(this);  
    }

}
