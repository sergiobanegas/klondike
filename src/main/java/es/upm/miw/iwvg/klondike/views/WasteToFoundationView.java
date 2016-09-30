package es.upm.miw.iwvg.klondike.views;

import es.upm.miw.iwvg.klondike.controllers.WasteToFoundationController;
import es.upm.miw.iwvg.klondike.utils.IO;

public class WasteToFoundationView{
	
	public void interact(WasteToFoundationController controller) {
	    IO io = new IO();
	    int numFoundation = io.readInt("¿Qué palo? [1-4]:");
	    controller.control(numFoundation-1);
	}
}
