package es.upm.miw.iwvg.klondike.models;

import java.util.List;
import java.util.Stack;

public class Waste extends CardStack{

    private static final int SIZE=3;
    
    public Waste(){
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
                List<Card> lastCards = super.getCards().subList(super.cards.size() - (SIZE+1), super.cards.size() - 1);
                return super.toStringCardList(lastCards);
            }
        }
    }
}
