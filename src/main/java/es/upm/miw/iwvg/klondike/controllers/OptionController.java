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
        switch (numOption){
        case 1:
            return (OperationController) options[numOption - 1].getController();
//        case 2:
//            break;
//        case 3:
//            break;
//        case 4:
//            break;
//        case 5:
//            break;
//        case 6:
//            break;
//        case 7:
//            break;
//        case 8:
//            break;
//        case 9:
//            break;
//        }
           default:
               return null;
        }
    }

    public static int getNumOptions() {
        return NUM_OPTIONS;
    }
}
