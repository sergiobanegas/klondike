package es.upm.miw.iwvg.klondike.controllers;


import es.upm.miw.iwvg.klondike.View;
import es.upm.miw.iwvg.klondike.models.Game;
import es.upm.miw.iwvg.klondike.models.Option;
import es.upm.miw.iwvg.klondike.views.MoveView;

public abstract class MoveController extends OperationController {


    protected MoveController(Game game) {
        super(game);
    }
        
    abstract Error validateMove();
    
    public Option getOption(){
        return game.getOption();
    }
    
    @Override
    public void accept(View view) {
        view.visit(this);
    }
    
    public abstract void acceptMove(MoveView view);
}
