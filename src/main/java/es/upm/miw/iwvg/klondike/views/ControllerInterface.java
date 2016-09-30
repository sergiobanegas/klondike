package es.upm.miw.iwvg.klondike.views;

import es.upm.miw.iwvg.klondike.controllers.Error;

public interface ControllerInterface {

    public void control();
    
    public Error validateMove();
}