package es.upm.miw.iwvg.klondike.models;

public class Foundation extends CardStack {

    public Foundation() {
        super();
    }

    @Override
    public String toString() {
        if (super.cards.isEmpty()) {
            return "<vacío>";
        } else {
            return super.cards.get(super.cards.size() - 1).toString();
        }
    }
}
