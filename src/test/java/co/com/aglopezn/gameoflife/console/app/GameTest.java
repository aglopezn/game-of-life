package co.com.aglopezn.gameoflife.console.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;


public class GameTest {

    @Test
    public void aGameCanReadInitialStateFromFile() throws FileNotFoundException {
        String filename = "static/initialStateTest.txt";
        Game game = Game.fromFile(filename);
        Assertions.assertTrue(game instanceof Game);
    }

    @Test
    public void aGameMustReturnCurrentStateInString(){
        String newline = System.getProperty("line.separator");
        String filename = "static/initialStateTest.txt";
        Game game = Game.fromFile(filename);
        String stateExpected = "..." + newline
                             + "***" + newline
                             + "..." + newline;
        Assertions.assertEquals(stateExpected, game.getState());
    }

    @Test
    public void aGameMustReturnTheNewGeneration(){
        String newline = System.getProperty("line.separator");
        String filename = "static/initialStateTest.txt";
        Game game = Game.fromFile(filename);
        String stateExpected = ".*." + newline
                             + ".*." + newline
                             + ".*." + newline;
        Assertions.assertEquals(stateExpected, game.nextGeneration());
    }

    @Test
    public void aGameMustStartAndShowTheNumberOfGenerationsGiven() {
        String newline = System.getProperty("line.separator");
        String filename = "static/initialStateTest.txt";
        Game game = Game.fromFile(filename);
        String expected = "..." + newline
                        + "***" + newline
                        + "..." + newline
                        + ".*." + newline
                        + ".*." + newline
                        + ".*." + newline
                        + "..." + newline
                        + "***" + newline
                        + "..." + newline;
        Assertions.assertEquals(expected, game.start());
    }

}
