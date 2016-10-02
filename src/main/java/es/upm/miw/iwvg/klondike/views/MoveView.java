package es.upm.miw.iwvg.klondike.views;

import es.upm.miw.iwvg.klondike.controllers.DeckToWasteController;
import es.upm.miw.iwvg.klondike.controllers.FlipCardController;
import es.upm.miw.iwvg.klondike.controllers.FoundationToTableauController;
import es.upm.miw.iwvg.klondike.controllers.MoveController;
import es.upm.miw.iwvg.klondike.controllers.OperationController;
import es.upm.miw.iwvg.klondike.controllers.TableauToFoundationController;
import es.upm.miw.iwvg.klondike.controllers.TableauToTableauController;
import es.upm.miw.iwvg.klondike.controllers.WasteToDeckController;
import es.upm.miw.iwvg.klondike.controllers.WasteToFoundationController;
import es.upm.miw.iwvg.klondike.controllers.WasteToTableauController;

public class MoveView implements ViewInterface {

    private WasteToFoundationView wasteToFoundationView;

    private WasteToDeckView wasteToDeckView;

    private WasteToTableauView wasteToTableauView;

    private DeckToWasteView deckToWasteView;

    private TableauToFoundationView tableauToFoundationView;

    private TableauToTableauView tableauToTableauView;

    private FoundationToTableauView foundationToTableauView;

    private FlipCardView flipCardView;

    public MoveView() {
        deckToWasteView = new DeckToWasteView();
        wasteToDeckView = new WasteToDeckView();
        wasteToTableauView = new WasteToTableauView();
        wasteToFoundationView = new WasteToFoundationView();
        tableauToFoundationView = new TableauToFoundationView();
        tableauToTableauView = new TableauToTableauView();
        foundationToTableauView = new FoundationToTableauView();
        flipCardView = new FlipCardView();
    }

    @Override
    public void interact(OperationController controller) {
        MoveController moveController = (MoveController) controller;
        moveController.acceptMove(this);
    }

    public void visit(DeckToWasteController deckToWasteController) {
        deckToWasteView.interact(deckToWasteController);
    }

    public void visit(WasteToDeckController wasteToDeckController) {
        wasteToDeckView.interact(wasteToDeckController);
    }

    public void visit(WasteToFoundationController wasteToFoundationController) {
        wasteToFoundationView.interact(wasteToFoundationController);
    }

    public void visit(WasteToTableauController wasteToTableauController) {
        wasteToTableauView.interact(wasteToTableauController);
    }

    public void visit(TableauToFoundationController tableauToFoundationController) {
        tableauToFoundationView.interact(tableauToFoundationController);
    }

    public void visit(TableauToTableauController tableauToTableauController) {
        tableauToTableauView.interact(tableauToTableauController);
    }

    public void visit(FoundationToTableauController foundationToTableauController) {
        foundationToTableauView.interact(foundationToTableauController);
    }

    public void visit(FlipCardController flipCardController) {
        flipCardView.interact(flipCardController);
    }

}
