package co.com.aglopezn.gameoflife.console.app;

import co.com.aglopezn.gameoflife.bussiness.Board;
import co.com.aglopezn.gameoflife.util.FileUtil;

import java.util.List;

public class Game {

    private static final char CHARACTER_ALIVE = '*';
    private static final char CHARACTER_DEATH = '.';
    private final int rows;
    private final int cols;
    private final int generations;
    private Board board;

    private Game(int rows, int cols, int generations, Board board){
        this.rows = rows;
        this.cols = cols;
        this.generations = generations;
        this.board = board;
    }

    public static Game fromFile(String pathToFile) {
        List<String> data = FileUtil.read(pathToFile);
        String[] variables = data.get(0).split(" ");
        int rows = Integer.parseInt(variables[0]);
        int cols = Integer.parseInt(variables[1]);
        int generations = Integer.parseInt(variables[2]);
        Board board = initializeBoard(rows, cols, data.subList(1, data.size()));
        return new Game(rows, cols, generations, board);
    }

    public String start() {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(getState());
        for (int i=0; i<generations - 1; i++){
            strBuilder.append(nextGeneration());
        }
        return strBuilder.toString();
    }

    public String nextGeneration(){
        this.board = this.board.nextGeneration();
        return getState();
    }

    public String getState(){
        StringBuilder builder = new StringBuilder();
        String newline = System.getProperty("line.separator");
        for (int i=0; i<rows; ++i){
            for (int j=0; j<cols; ++j){
                char status = board.cellAt(i,j).isAlive() ? CHARACTER_ALIVE : CHARACTER_DEATH;
                builder.append(status);
            }
            builder.append(newline);
        }
        return builder.toString();
    }

    private static Board initializeBoard(int rows, int cols, List<String> initialData){
        Board.Builder boardBuilder = new Board.Builder(rows, cols);
        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                if (initialData.get(i).charAt(j) == Game.CHARACTER_ALIVE){
                 boardBuilder.liveCellAt(i,j);
                }
            }
        }
        return boardBuilder.build();
    }
}
