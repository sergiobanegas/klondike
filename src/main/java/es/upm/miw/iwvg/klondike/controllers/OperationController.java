package es.upm.miw.iwvg.klondike.controllers;

import es.upm.miw.iwvg.klondike.View;
import es.upm.miw.iwvg.klondike.models.Game;

public abstract class OperationController implements ControllerInterface {

    protected Game game;
    
    protected OperationController() {
        this.game = Game.getInstance();
    }
    
    public abstract void accept(View view);

    public abstract void control();

}
