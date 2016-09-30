package es.upm.miw.iwvg.klondike.controllers;


import es.upm.miw.iwvg.klondike.models.Game;

public abstract class MoveController extends OperationController {


    protected MoveController(Game game) {
        super(game);
    }
        

//    public Error validateTarget(Coordinate target) {
//        if (!this.empty(target)) {
//            System.out.println("Error no libre");
//            return Error.NOT_EMPTY;
//        }
//        return null;
//    }
}
