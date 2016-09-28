package es.upm.miw.iwvg.klondike.models;

public enum Suit {

    OROS("o"), COPAS("c"), ESPADAS("e"), BASTOS("b");

    private String value;

    private Suit(String value) {
        this.value = value;
    }
    
    public int position() {
        return this.ordinal() + 1;
    }

    public String getValue() {
        return value;
    }
    
}