package es.upm.miw.iwvg.klondike.models;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({CardStackTest.class, CardTest.class, DeckTest.class, FoundationTest.class, SuitTest.class, TableauPilesTest.class,
        WasteTest.class})
public class AllTests {

}
