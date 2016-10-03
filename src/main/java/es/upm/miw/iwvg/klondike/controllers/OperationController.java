package es.upm.miw.iwvg.klondike.controllers;

import es.upm.miw.iwvg.klondike.View;

public abstract class OperationController extends Controller implements ControllerInterface {

    public abstract void accept(View view);

    public abstract void control();

}
