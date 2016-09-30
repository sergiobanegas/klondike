package es.upm.miw.iwvg.klondike.controllers;

public enum Error {
	
	NOT_VALID_MOVE("No se puede colocar la carta en esa pila"),
	REPEATED_COORDINATE(""),
	DECK_EMPTY("La baraja está vacía"),
	WASTE_EMPTY("El descarte está vacío"),
	INVALID_CARD("El número o el color de la carta no corresponde con la escalera destino"),
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
