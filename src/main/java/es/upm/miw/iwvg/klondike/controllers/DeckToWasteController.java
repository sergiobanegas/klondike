package es.upm.miw.iwvg.klondike.controllers;

import es.upm.miw.iwvg.klondike.View;
import es.upm.miw.iwvg.klondike.models.Game;
import es.upm.miw.iwvg.klondike.views.MoveView;

public class DeckToWasteController extends MoveController {

    private static final int MAX_CARDS_DISCARD = 3;

    public DeckToWasteController(Game game) {
        super(game);
    }

    @Override
    public void control() {
        if (validateMove() != null) {
            System.out.println("ERROR!!! La baraja está vacía");
        } else {
            for (int i = 0; i < MAX_CARDS_DISCARD; i++) {
                if (validateMove() == null) {
                    game.addCardWaste(popLastCardDeck());
                } else {
                    break;
                }
            }
        }
    }

    @Override
    public Error validateMove() {
        if (game.isDeckEmpty()) {
            return Error.DECK_EMPTY;
        }
        return null;
    }

    @Override
    public void accept(View view) {
        view.visit(this);
    }

    @Override
    public void acceptMove(MoveView view) {
        view.visit(this);
    }

}
