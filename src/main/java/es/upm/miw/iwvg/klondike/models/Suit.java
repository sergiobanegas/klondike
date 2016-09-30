package es.upm.miw.iwvg.klondike.models;

public enum Suit {

    HEARTS("h"), TILES("t"), CLOVERS("c"), PIKES("p");

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