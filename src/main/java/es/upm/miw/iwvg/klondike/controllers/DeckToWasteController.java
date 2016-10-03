package es.upm.miw.iwvg.klondike.controllers;

import es.upm.miw.iwvg.klondike.View;
import es.upm.miw.iwvg.klondike.views.MoveView;

public class DeckToWasteController extends MoveController {

    private static final int MAX_CARDS_DISCARD = 3;

    public DeckToWasteController() {
        super();
    }

    @Override
    public void control() {
        Error error = validateMove();
        if (error != null) {
            System.out.println(error);
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
            return new Error(ErrorEnum.DECK_EMPTY);
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
