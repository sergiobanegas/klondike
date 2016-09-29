package es.upm.miw.iwvg.klondike;

import es.upm.miw.iwvg.klondike.controllers.Logic;
import es.upm.miw.iwvg.klondike.controllers.OperationController;
import es.upm.miw.iwvg.klondike.views.View;

public class Klondike {

    private Logic logic;

    private View view;

    public Klondike(View view, Logic logic) {
        this.view = view;
        this.logic = logic;
    }
    
    public void play() {
        OperationController controller;
        do {
            controller = logic.getOperationController();
            if (controller != null){
                view.interact(controller);
            }
        } while (controller != null);   
    }
    
    public static void main(String[] args) {
        new Klondike(new View(), new Logic()).play();
    }
}
