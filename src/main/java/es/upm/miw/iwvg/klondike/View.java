package es.upm.miw.iwvg.klondike;

import es.upm.miw.iwvg.klondike.controllers.DeckToWasteController;
import es.upm.miw.iwvg.klondike.controllers.ExitController;
import es.upm.miw.iwvg.klondike.controllers.FlipCardController;
import es.upm.miw.iwvg.klondike.controllers.FoundationToTableauController;
import es.upm.miw.iwvg.klondike.controllers.OperationController;
import es.upm.miw.iwvg.klondike.controllers.StartController;
import es.upm.miw.iwvg.klondike.controllers.TableauToFoundationController;
import es.upm.miw.iwvg.klondike.controllers.TableauToTableauController;
import es.upm.miw.iwvg.klondike.controllers.WasteToDeckController;
import es.upm.miw.iwvg.klondike.controllers.WasteToFoundationController;
import es.upm.miw.iwvg.klondike.controllers.WasteToTableauController;
import es.upm.miw.iwvg.klondike.utils.IO;
import es.upm.miw.iwvg.klondike.views.DeckToWasteView;
import es.upm.miw.iwvg.klondike.views.ExitView;
import es.upm.miw.iwvg.klondike.views.FlipCardView;
import es.upm.miw.iwvg.klondike.views.FoundationToTableauView;
import es.upm.miw.iwvg.klondike.views.StartView;
import es.upm.miw.iwvg.klondike.views.TableauToFoundationView;
import es.upm.miw.iwvg.klondike.views.TableauToTableauView;
import es.upm.miw.iwvg.klondike.views.WasteToDeckView;
import es.upm.miw.iwvg.klondike.views.WasteToFoundationView;
import es.upm.miw.iwvg.klondike.views.WasteToTableauView;

public class View {

    private StartView startView;

    private WasteToFoundationView wasteToFoundationView;

    private WasteToDeckView wasteToDeckView;

    private WasteToTableauView wasteToTableauView;

    private DeckToWasteView deckToWasteView;

    private TableauToFoundationView tableauToFoundationView;

    private TableauToTableauView tableauToTableauView;

    private FoundationToTableauView foundationToTableauView;

    private FlipCardView flipCardView;

    private ExitView exitView;

    public View() {
        startView = new StartView();
        deckToWasteView = new DeckToWasteView();
        wasteToDeckView = new WasteToDeckView();
        wasteToTableauView = new WasteToTableauView();
        wasteToFoundationView = new WasteToFoundationView();
        tableauToFoundationView = new TableauToFoundationView();
        tableauToTableauView = new TableauToTableauView();
        foundationToTableauView = new FoundationToTableauView();
        flipCardView = new FlipCardView();
        exitView = new ExitView();
    }

    public boolean interact(OperationController operationController) {
        assert operationController != null;
        operationController.accept(this);
        if (operationController.isGameFinalized()) {
            new IO().writeln("ENHORABUENA, HAS GANADO!!!");
            return true;
        }
        if (operationController.isGameQuit()) {
            return true;
        }
        return false;
    }

    public void visit(StartController startController) {
        startView.start(startController);
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

    public void visit(ExitController exitController) {
        exitView.interact(exitController);
    }

}
