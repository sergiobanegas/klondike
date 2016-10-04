package es.upm.miw.iwvg.klondike.controllers;

import es.upm.miw.iwvg.klondike.models.Card;

public class Error {

    private String message;

    public Error(ErrorEnum error) {
        assert error != null;
        this.message = error.toString();
    }

    public Error(Card card1, Card card2) {
        assert card1 != null;
        assert card2 != null;
        this.message = "ERROR!!! No se puede poner " + card1.toString() + " sobre " + card2.toString();
    }

    @Override
    public String toString() {
        return message;
    }
}
