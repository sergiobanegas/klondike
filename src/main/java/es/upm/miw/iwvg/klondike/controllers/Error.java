package es.upm.miw.iwvg.klondike.controllers;

public enum Error {
	
	NOT_VALID_MOVE("No se puede colocar la carta en esa pila"),
	REPEATED_COORDINATE(""),
	DECK_EMPTY("La baraja está vacía"),
	NOT_PROPERTY("Esa casilla no está ocupada por ninguna de tus fichas");
	
	private String message;
	
	private Error(String message){
		this.message = message;
	}
	
	@Override
	public String toString(){
		return message;
	}
}
