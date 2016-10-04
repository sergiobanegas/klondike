package es.upm.miw.iwvg.klondike.models;

public enum Suit {

    CORAZONES("c"), DIAMANTES("d"), TREBOLES("t"), PICAS("p");

    private String value;

    private Suit(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
