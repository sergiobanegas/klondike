package es.upm.miw.iwvg.klondike.models;

import java.util.List;

public class Discard extends CardList{

    private static final int SIZE=3;
    
    public Discard(){
        super();
    }
    
    @Override
    public String toString() {
        if (super.cards.isEmpty()) {
            return "<vacío>";
        } else {
            if (super.cards.size() <= 3) {
                return super.toStringCardList(super.cards);
            } else {
                List<Card> lastCards = super.cards.subList(super.cards.size() - (SIZE+1), super.cards.size() - 1);
                return super.toStringCardList(lastCards);
            }
        }
    }
}
