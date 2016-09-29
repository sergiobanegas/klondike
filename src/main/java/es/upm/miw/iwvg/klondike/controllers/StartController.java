package es.upm.miw.iwvg.klondike.controllers;

import es.upm.miw.iwvg.klondike.View;
import es.upm.miw.iwvg.klondike.models.Game;
import es.upm.miw.iwvg.klondike.models.State;

public class StartController extends OperationController {

    public StartController(Game game) {
        super(game);
    }
    
    public void start(){
        System.out.println("Soy el controlador Start, creando cosas...");
        this.setState(State.IN_GAME);
    }

    @Override
    public void accept(View operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }

}
