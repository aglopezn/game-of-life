package co.com.aglopezn.gameoflife.bussiness;

public class Board {

    private int rows;
    private int cols;
    private Cell[][] grid;

    private Board(Builder builder){
        this.rows = builder.rows;
        this.cols = builder.cols;
        this.grid = builder.grid;
    }

    public int countCellsAlive(){
        int counter = 0;
        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                if (cellAt(i, j).isAlive()) counter++;
            }
        }
        return counter;
    }

    public int liveNeighboursOfCellAt(int row, int col){
        int counter = 0;
        for (int i=-1; i<2; i++){
            for (int j=-1; j<2; j++){
                if (isOutOfTheBoard(row + i, col + j)) continue;
                if (cellAt(row + i,col + j).isAlive()) counter++;
            }
        }
        if (cellAt(row, col).isAlive()) counter--;
        return counter;
    }

    public Board nextGeneration(){
        Builder builder = new Board.Builder(rows, cols);
        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                Cell nextCell = calculateNextGenCell(i, j);
                if (nextCell.isAlive()){
                    builder.liveCellAt(i,j);
                }
            }
        }
        Board nextBoard = builder.build();
        return nextBoard;
    }

    public Cell cellAt(int row, int col){
        return grid[row][col];
    }

    private boolean isOutOfTheBoard(int row, int col){
        if (row < 0 || row >= rows) return true;
        if (col < 0 || col >= cols) return true;
        return false;
    }

    private Cell calculateNextGenCell(int row, int col){
        Cell cell = cellAt(row, col);
        int liveNeighbours = liveNeighboursOfCellAt(row, col);
        return cell.withNeighboursAlive(liveNeighbours);
    }

    public static class Builder {

        private int rows;
        private int cols;
        private Cell[][] grid;

        public Builder(int rows, int cols){
            this.rows = rows;
            this.cols = cols;
            this.grid = new Cell[rows][cols];
            initializeGrid();
        }

        private void initializeGrid(){
            for (int i=0; i<rows; i++){
                for (int j=0; j<cols; j++){
                    grid[i][j] = new Cell(Cell.states.DEAD);
                }
            }
        }

        public Builder liveCellAt(int i, int j){
            grid[i][j] = new Cell(Cell.states.ALIVE);
            return this;
        }

        public Board build(){
            return new Board(this);
        }
    }
}
