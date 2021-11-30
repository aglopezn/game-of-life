package co.com.aglopezn.gameoflife.console.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class GameRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Welcome to Game of Life!");
        String filepath = "static/toad.txt";
        Game game = Game.fromFile(filepath);
        System.out.println(game.start());
    }
}
