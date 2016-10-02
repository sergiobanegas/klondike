package es.upm.miw.iwvg.klondike.controllers;

import es.upm.miw.iwvg.klondike.View;
import es.upm.miw.iwvg.klondike.models.Game;
import es.upm.miw.iwvg.klondike.models.TableauPiles;

public class FlipCardController extends MoveController {

    public FlipCardController(Game game) {
        super(game);
    }

    @Override
    public void accept(View operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }

    public void control(int numTableau) {
        TableauPiles tableau=game.getTableauPile(numTableau);
        if (validateMove(numTableau) != null) {
            System.out.println("ERROR!!! No se puede voltear una carta descubierta");
        } else if (tableau.isEmpty()){
            System.out.println("ERROR!!! La escalera está vacía");
        }else{
            game.getTableauPile(numTableau).flipCard();
        }
    }

    public Error validateMove(int numTableau) {
        if (game.getTableauPile(numTableau).getCardsFaceUp().isEmpty()) {
            return null;
        }
        return Error.FLIPCARD_ERROR;
    }

}
