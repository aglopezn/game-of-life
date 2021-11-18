package co.com.aglopezn.gameoflife.bussiness;

public class Cell {

    public enum states {
        ALIVE,
        DEAD
    }

    private states state;

    public Cell(states state){
        this.state = state;
    }

    public boolean isAlive(){
        return this.state == states.ALIVE;
    }

    public Cell withNeighboursAlive(int amount){
        if (isAlive() && (amount == 2 || amount == 3)) return new Cell(states.ALIVE);
        if (!isAlive() && amount == 3) return new Cell(states.ALIVE);
        return new Cell(states.DEAD);
    }
}
