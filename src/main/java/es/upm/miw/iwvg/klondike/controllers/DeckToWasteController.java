package es.upm.miw.iwvg.klondike.controllers;

import es.upm.miw.iwvg.klondike.View;
import es.upm.miw.iwvg.klondike.models.Game;
import es.upm.miw.iwvg.klondike.views.ControllerInterface;
import es.upm.miw.iwvg.klondike.views.GameView;

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
        System.out.println("CONTROLANDO DeckToWasteController");       

    }


}

