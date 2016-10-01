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
        if (validateMove(numTableau) != null){
            System.out.println("ERROR: movimiento no válido");
        }else{
            game.getTableauPile(numTableau).addCard(game.getWaste().popCard());
        }
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
