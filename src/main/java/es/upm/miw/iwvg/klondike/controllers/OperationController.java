package es.upm.miw.iwvg.klondike.controllers;

import es.upm.miw.iwvg.klondike.View;
import es.upm.miw.iwvg.klondike.models.Game;

public abstract class OperationController extends Controller {
    
    public OperationController(Game game) {
        super(game);
    }

    public abstract void accept(View view);
    public abstract void control();

}
