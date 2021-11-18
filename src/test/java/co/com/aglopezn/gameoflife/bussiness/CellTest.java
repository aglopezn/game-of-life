package co.com.aglopezn.gameoflife.bussiness;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CellTest {

    @Test
    public void aCellMayBeAlive(){
        Cell cell = new Cell(Cell.states.ALIVE);
        Assertions.assertEquals(true, cell.isAlive());
    }

    @Test
    public void aCellMayBeDead(){
        Cell cell = new Cell(Cell.states.DEAD);
        Assertions.assertEquals(false, cell.isAlive());
    }

    @Test
    public void aLiveCellWith2NeighboursAliveKeepsAlive(){
        Cell cell = new Cell(Cell.states.ALIVE);
        Assertions.assertEquals(true, cell.withNeighboursAlive(2).isAlive());
    }

    @Test
    public void aLiveCellWith3NeighboursAliveKeepsAlive(){
        Cell cell = new Cell(Cell.states.ALIVE);
        Assertions.assertEquals(true, cell.withNeighboursAlive(3).isAlive());
    }

    @Test
    public void aDeadCellWith3NeighboursAliveBecomeAlive(){
        Cell cell = new Cell(Cell.states.DEAD);
        Assertions.assertEquals(true, cell.withNeighboursAlive(3).isAlive());
    }

    @Test
    public void aCellWithLessThan2NeighboursAliveBecomeDead(){
        Cell cell = new Cell(Cell.states.ALIVE);
        Assertions.assertEquals(false, cell.withNeighboursAlive(1).isAlive());
    }

    @Test
    public void aCellWithMoreThan3NeighboursAliveBecomeDead(){
        Cell cell = new Cell(Cell.states.ALIVE);
        Assertions.assertEquals(false, cell.withNeighboursAlive(4).isAlive());
    }

    @Test
    public void aDeadCellWith2NeighboursAliveRemainsDead(){
        Cell cell = new Cell(Cell.states.DEAD);
        Assertions.assertEquals(false, cell.withNeighboursAlive(2).isAlive());
    }
}
