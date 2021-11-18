package co.com.aglopezn.gameoflife.bussiness;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoardTest {

    @Test
    public void aBoardCanNotHaveNegativeRows(){
        int rows = -2;
        int cols = 2;
        Assertions.assertThrows(Exception.class, () -> new Board.Builder(rows, cols).build());
    }

    @Test
    public void aBoardCanNotHaveNegativeCols(){
        int rows = 2;
        int cols = -2;
        Assertions.assertThrows(Exception.class, () -> new Board.Builder(rows, cols).build());
    }

    @Test
    public void aBoardMayHaveOnlyDeadCells(){
        int rows = 2;
        int cols = 2;
        Board board = new Board.Builder(rows, cols).build();
        Assertions.assertEquals(0, board.countCellsAlive());
    }

    @Test
    public void aBoardMayHaveOnlyLiveCells(){
        int rows = 2;
        int cols = 2;
        Board board = new Board.Builder(rows, cols)
                .liveCellAt(0,0)
                .liveCellAt(0,1)
                .liveCellAt(1,0)
                .liveCellAt(1,1)
                .build();
        Assertions.assertEquals(4, board.countCellsAlive());
    }

    @Test
    public void aBoardCanCountLiveNeighboursOfACell(){
        int rows = 3;
        int cols = 3;
        Board board = new Board.Builder(rows, cols)
                .liveCellAt(0,0)
                .liveCellAt(0,1)
                .liveCellAt(0,2)
                .liveCellAt(1,0)
                .liveCellAt(1,1)
                .liveCellAt(1,2)
                .liveCellAt(2,0)
                .liveCellAt(2,1)
                .liveCellAt(2,2)
                .build();
        Assertions.assertEquals(8, board.liveNeighboursOfCellAt(1,1));
    }

    @Test
    public void aBoardHasADeadCellWith4LiveNeighbours(){
        int rows = 3;
        int cols = 3;
        Board board = new Board.Builder(rows, cols)
                .liveCellAt(0,2)
                .liveCellAt(1,0)
                .liveCellAt(1,2)
                .liveCellAt(2,0)
                .build();
        Assertions.assertEquals(4, board.liveNeighboursOfCellAt(1,1));
    }

    @Test
    public void aCellOnACornerMayHave3NeighboursAliveMax(){
        int rows = 3;
        int cols = 3;
        Board board = new Board.Builder(rows, cols)
                .liveCellAt(0,1)
                .liveCellAt(1,0)
                .liveCellAt(1,1)
                .build();
        Assertions.assertEquals(3, board.liveNeighboursOfCellAt(0,0));
    }

    @Test
    public void aCellOnAnEdgeThatHas4NeighboursAlive(){
        int rows = 3;
        int cols = 3;
        Board board = new Board.Builder(rows, cols)
                .liveCellAt(0,0)
                .liveCellAt(0,1)
                .liveCellAt(0,2)
                .liveCellAt(1,0)
                .liveCellAt(1,1)
                .build();
        Assertions.assertEquals(4, board.liveNeighboursOfCellAt(0,1));
    }

    @Test
    public void aBoardWithOneCellAliveBecomesDead(){
        int rows = 1;
        int cols = 1;
        Board board = new Board.Builder(rows, cols)
                .liveCellAt(0,0)
                .build();
        Assertions.assertEquals(0, board.nextGeneration().countCellsAlive());
    }

    /**
     * What is a linker in: https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life#Examples_of_patterns
     */
    @Test
    public void aBoardMayBeABlinker(){
        int rows = 3;
        int cols = 3;
        Board board = new Board.Builder(rows, cols)
                .liveCellAt(1,0)
                .liveCellAt(1,1)
                .liveCellAt(1,2)
                .build();
        Board nextBoard = board.nextGeneration();
        Assertions.assertEquals(true, nextBoard.cellAt(0,1).isAlive());
        Assertions.assertEquals(true, nextBoard.cellAt(1,1).isAlive());
        Assertions.assertEquals(true, nextBoard.cellAt(2,1).isAlive());
        Assertions.assertEquals(3, board.nextGeneration().countCellsAlive());
    }

    /**
     * What is a beacon in: https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life#Examples_of_patterns
     */
    @Test
    public void aBoardMayBeABeacon(){
        int rows = 4;
        int cols = 4;
        Board board = new Board.Builder(rows, cols)
                .liveCellAt(0,0)
                .liveCellAt(0,1)
                .liveCellAt(1,0)
                .liveCellAt(1,1)
                .liveCellAt(2,2)
                .liveCellAt(2,3)
                .liveCellAt(3,2)
                .liveCellAt(3,3)
                .build();
        Assertions.assertEquals(false, board.nextGeneration().cellAt(1,1).isAlive());
        Assertions.assertEquals(6, board.nextGeneration().countCellsAlive());
        Assertions.assertEquals(8, board.nextGeneration().nextGeneration().countCellsAlive());
    }
}
