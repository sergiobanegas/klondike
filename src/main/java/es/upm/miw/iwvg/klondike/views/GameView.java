package es.upm.miw.iwvg.klondike.views;

import es.upm.miw.iwvg.klondike.controllers.DeckToWasteController;
import es.upm.miw.iwvg.klondike.controllers.MoveController;
import es.upm.miw.iwvg.klondike.utils.IO;

public class GameView{

	private IO io = new IO();
	
	public void interact(DeckToWasteController deckToWasteController) {
	    deckToWasteController.control();
	}

    public void visit(DeckToWasteController deckToWasteController) {
        // this.showTitle("Pone", putController.take());
        // PutTargetCoordinateView putCoordinateView = new PutTargetCoordinateView(
        // putController.getCoordinateController());
        // this.put(putController, putCoordinateView);
        // this.showGame(putController);
        System.out.println("Soy DeckToWasteController");
    }
	
//	public void visit(DeckToWasteController deckToWasteController) {
////		this.showTitle("Pone", putController.take());
////		PutTargetCoordinateView putCoordinateView = new PutTargetCoordinateView(
////				putController.getCoordinateController());
////		this.put(putController, putCoordinateView);
////		this.showGame(putController);
//	    System.out.println("Soy DeckToWasteController");
//	}

//	public void visit(MoveController moveController) {
//		this.showTitle("Mueve", moveController.take());
//		MoveOriginCoordinateView moveOriginCoordinateView = new MoveOriginCoordinateView(
//				moveController.getCoordinateController());
//		this.remove(moveController, moveOriginCoordinateView);
//		MoveTargetCoordinateView moveTargetCoordinateView = new MoveTargetCoordinateView(
//				moveController.getCoordinateController(), origin);
//		this.put(moveController, moveTargetCoordinateView);
//		this.showGame(moveController);
	}

//	private void showTitle(String title, Color color) {
//		colorView.writeln(title + " el jugador ");
//	}
//
//	private void put(PutController putController,
//			ColocateCoordinateView colocateCoordinateView) {
//		Coordinate target;
//		Error error = null;
//		do {
//			target = colocateCoordinateView.getCoordinate();
//			error = putController.validateTarget(target);
//			if (error != null) {
//				io.writeln("" + error);
//			}
//		} while (error != null);
//		putController.put(target);
//	}
//
//	private void remove(MoveController moveController,
//			ColocateCoordinateView colocateCoordinateView) {
//		Error error = null;
//		do {
//			origin = colocateCoordinateView.getCoordinate();
//			error = moveController.validateOrigin(origin);
//			if (error != null) {
//				io.writeln("" + error);
//			}
//		} while (error != null);
//		moveController.remove(origin);
//	}
//	
//	private void put(MoveController moveController,
//			ColocateCoordinateView colocateCoordinateView) {
//		Coordinate target;
//		Error error = null;
//		do {
//			target = colocateCoordinateView.getCoordinate();
//			error = moveController.validateTarget(origin, target);
//			if (error != null) {
//				io.writeln("" + error);
//			}
//		} while (error != null);
//		moveController.put(target);
//	}
//
//	private void showGame(ColocateController colocateController) {
//		new BoardView(colocateController).write();
//		if (colocateController.existTicTacToe()) {
//			colorView.writeWinner();
//		}
//	}
