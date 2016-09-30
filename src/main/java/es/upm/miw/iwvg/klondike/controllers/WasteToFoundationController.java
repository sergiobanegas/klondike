package es.upm.miw.iwvg.klondike.controllers;

import es.upm.miw.iwvg.klondike.View;
import es.upm.miw.iwvg.klondike.models.Game;

public class WasteToFoundationController extends MoveController{

    public WasteToFoundationController(Game game) {
        super(game);
    }
    
    @Override
    public void accept(View operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }
    
    public void control(int numFoundation) {
        assert validateMove(numFoundation) == null;
        game.getFoundation(numFoundation).addCard(game.getWaste().popCard());
    }
    
    public Error validateMove(int numFoundation) {
        if (!game.getFoundation(numFoundation).getLastCard().validAbove(game.getWaste().getLastCard()) && !game.getFoundation(numFoundation).isEmpty()){
            return Error.INVALID_CARD;
        }
        return null;
    }


}

