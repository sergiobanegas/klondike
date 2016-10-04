package es.upm.miw.iwvg.klondike.models;

public interface GameInterface {
    String getDeckString();

    String getWasteString();

    String getFoundationString(int position);

    String getTableauPileString(int position);
}
