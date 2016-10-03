package es.upm.miw.iwvg.klondike.controllers;

import es.upm.miw.iwvg.klondike.View;
import es.upm.miw.iwvg.klondike.models.Card;
import es.upm.miw.iwvg.klondike.models.CardStack;
import es.upm.miw.iwvg.klondike.models.Foundation;
import es.upm.miw.iwvg.klondike.models.State;
import es.upm.miw.iwvg.klondike.models.TableauPiles;
import es.upm.miw.iwvg.klondike.views.MoveView;

public abstract class MoveController extends OperationController {

    public void control() {
        if (game.isGameFinalized()) {
            game.setState(State.FINALIZED);
        }
    }

    abstract Error validateMove();

    public abstract void acceptMove(MoveView view);

    public TableauPiles getTableauPile(int position) {
        return game.getTableauPile(position);
    }

    public Card popLastCardWaste() {
        return game.popCardWaste();
    }

    public Card getLastCard(CardStack stack) {
        return stack.getLastCard();
    }

    public Card getLastCardWaste() {
        return game.getLastCardWaste();
    }

    public Card getLastCardTableauPile(TableauPiles tableau) {
        return tableau.getLastCard();
    }

    public boolean isCardValue(Card card, String value) {
        return card.getValue().getValue() == value;
    }
    
    public boolean isWasteEmpty() {
        return game.isWasteEmpty();
    }

    public Foundation getFoundation(int position) {
        return game.getFoundation(position);
    }

    @Override
    public void accept(View view) {
        view.visit(this);
    }

}
