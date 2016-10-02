package es.upm.miw.iwvg.klondike.controllers;


import es.upm.miw.iwvg.klondike.models.Game;
import es.upm.miw.iwvg.klondike.models.Option;

public abstract class MoveController extends OperationController {


    protected MoveController(Game game) {
        super(game);
    }
        
    abstract Error validateMove();
    
    public Option getOption(){
        return game.getOption();
    }
}
