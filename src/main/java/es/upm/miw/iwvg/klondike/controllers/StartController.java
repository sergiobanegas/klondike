package es.upm.miw.iwvg.klondike.controllers;

import es.upm.miw.iwvg.klondike.View;
import es.upm.miw.iwvg.klondike.models.Deck;
import es.upm.miw.iwvg.klondike.models.Foundation;
import es.upm.miw.iwvg.klondike.models.Game;
import es.upm.miw.iwvg.klondike.models.State;
import es.upm.miw.iwvg.klondike.models.Suit;
import es.upm.miw.iwvg.klondike.models.TableauPiles;
import es.upm.miw.iwvg.klondike.models.Waste;

public class StartController extends OperationController {

    public StartController(Game game) {
        super(game);
    }

    public void start() {
        game.setDeck(new Deck());
        game.setWaste(new Waste());
        createTableauPiles();
        createFoundations();
        this.setState(State.IN_GAME);
    }

    private void createTableauPiles() {
        for (int i = 0; i < TableauPiles.NUMBER_OF_PILES; i++) {
            TableauPiles tableau = new TableauPiles();
            for (int j = 0; j < i; j++) {
                tableau.getCardsFaceDown().addCard(game.getDeck().popCard());
            }
            tableau.getCardsFaceUp().add(game.getDeck().popCard());
            game.getTableauPiles().add(tableau);
        }
    }

    private void createFoundations() {
        for (int i=0;i<Suit.values().length;i++){
            game.addFoundation(new Foundation());
        }
    }

    @Override
    public void accept(View operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }

}
