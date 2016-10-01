package es.upm.miw.iwvg.klondike.views;

import es.upm.miw.iwvg.klondike.controllers.TableauToFoundationController;
import es.upm.miw.iwvg.klondike.utils.IO;

public class TableauToFoundationView{
	
	public void interact(TableauToFoundationController controller) {
	    IO io = new IO();
	    int numTableau = io.readInt("¿De qué escalera? [1-7]:");
	    int numFoundation = io.readInt("¿A qué palo? [1-4]:");
	    controller.control(numTableau-1, numFoundation-1);
	}
}
