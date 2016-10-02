package es.upm.miw.iwvg.klondike.controllers;

import es.upm.miw.iwvg.klondike.View;
import es.upm.miw.iwvg.klondike.models.Game;
import es.upm.miw.iwvg.klondike.models.TableauPiles;
import es.upm.miw.iwvg.klondike.views.MoveView;

public class FlipCardController extends MoveController {

    private int numTableau;

    public FlipCardController(Game game) {
        super(game);
    }

    @Override
    public void accept(View operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }

    @Override
    public void control() {
        TableauPiles tableau = game.getTableauPile(numTableau);
        if (validateMove() != null) {
            System.out.println("ERROR!!! No se puede voltear una carta descubierta");
        } else if (tableau.isEmpty()) {
            System.out.println("ERROR!!! La escalera está vacía");
        } else {
            game.getTableauPile(numTableau).flipCard();
        }
    }

    @Override
    public Error validateMove() {
        if (game.getTableauPile(numTableau).getCardsFaceUp().isEmpty()) {
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
