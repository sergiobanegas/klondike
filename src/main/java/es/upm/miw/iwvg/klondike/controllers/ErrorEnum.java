package es.upm.miw.iwvg.klondike.controllers;

import es.upm.miw.iwvg.klondike.models.Card;

public enum ErrorEnum {
	
	NOT_VALID_MOVE("ERROR!!!  No se puede colocar esa carta en esa posición"),
	NOT_ENOUGH_CARDS("ERROR!!!  No se pueden coger más cartas de las que hay en un montón"),
	DECK_EMPTY("ERROR!!!  La baraja está vacía"),
	FOUNDATION_EMPTY("ERROR!!!  El palo está vacío"),
	TABLEAU_EMPTY("ERROR!!!  La escalera está vacía"),
	FLIPCARD_ERROR("ERROR!!!  No hay ninguna carta descubierta para descubrir"),
	EXISTS_FACEUP_CARDS("ERROR!!!  Ya existen cartas descubiertas"),
	WASTE_EMPTY("ERROR!!!  El descarte está vacío"),
    NO_FACEUP_CARDS("ERROR!!!  No hay ninguna carta descubierta para mover"),
    NO_FACEDOWN_CARDS("ERROR!!!  No hay ninguna carta oculta para descubrir");
    
	private String message;
	
	private ErrorEnum(String message){
	    assert message != null;
		this.message = message;
	}
	
	private ErrorEnum(Card card1, Card card2){
	    assert card1 != null;
	    assert card2 != null;
        this.message="ERROR!!!  No se puede poner "+card1.toString()+" sobre "+card2.toString();
    }
	
	@Override
	public String toString(){
		return message;
	}
}
