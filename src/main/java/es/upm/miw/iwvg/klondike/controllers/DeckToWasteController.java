package es.upm.miw.iwvg.klondike.controllers;

import es.upm.miw.iwvg.klondike.View;
import es.upm.miw.iwvg.klondike.models.Game;
import es.upm.miw.iwvg.klondike.views.ControllerInterface;

public class DeckToWasteController extends MoveController implements ControllerInterface {

    private static final int MAX_CARDS_DISCARD = 3;

    public DeckToWasteController(Game game) {
        super(game);
    }
    
    @Override
    public void accept(View operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }
    
    @Override
    public void control() {
        for (int i=0; i<MAX_CARDS_DISCARD;i++){
            if (validateMove() == null){
                game.getWaste().addCard(game.getDeck().popCard());
            }else{
                System.out.println("ERROR: la baraja está vacía");
                break;
            };
            
        } 
    }
    
    public Error validateMove() {
        if (game.getDeck().isEmpty()){
            return Error.DECK_EMPTY;
        }
        return null;
    }


}

