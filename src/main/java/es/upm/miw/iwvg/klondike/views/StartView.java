package es.upm.miw.iwvg.klondike.views;

import es.upm.miw.iwvg.klondike.controllers.StartController;

public class StartView {

	public void start(StartController startController){
	    System.out.println("Soy la vista Start");
	    startController.start();
	}
}
