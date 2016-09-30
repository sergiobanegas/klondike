package es.upm.miw.iwvg.klondike.controllers;

import es.upm.miw.iwvg.klondike.models.Game;
import es.upm.miw.iwvg.klondike.models.Option;

public class OptionController {

    private Option[] options;
    
    private static final int NUM_OPTIONS = 9;

    public OptionController(Game game) {
        options = new Option[NUM_OPTIONS];
        for (int i = 0; i < NUM_OPTIONS; i++) {
            options[i] = new Option(i + 1, game);
        }
    }

    public OperationController control(int numOption) {
            return (OperationController) options[numOption - 1].getController();
    }

    public static int getNumOptions() {
        return NUM_OPTIONS;
    }
}
