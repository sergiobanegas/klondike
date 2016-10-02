package es.upm.miw.iwvg.klondike;

import es.upm.miw.iwvg.klondike.controllers.OperationController;

public class Klondike {

    private Logic logic;

    private View view;

    public Klondike(View view, Logic logic) {
        this.view = view;
        this.logic = logic;
    }

    public void play() {
        OperationController controller;
        boolean finalized = false;
        do {
            controller = logic.getOperationController();
            if (controller != null) {
                finalized = view.interact(controller);
            }
        } while (controller != null && !finalized);
    }

    public static void main(String[] args) {
        new Klondike(new View(), new Logic()).play();
    }
}
