package es.upm.miw.iwvg.klondike.models;

public enum Color {

    BLACK("b"), RED("r");

    private String value;

    private Color(String value) {
        this.value = value;
    }

    public int position() {
        return this.ordinal() + 1;
    }

    public String getValue() {
        return value;
    }

}
