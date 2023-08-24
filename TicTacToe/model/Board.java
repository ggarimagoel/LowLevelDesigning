package TicTacToe.model;
public class Board {
    private Cell[][] cells;

    public Cell[][] getCells() {
        return cells;
    }
    public void setCells(Cell[][] cells){
        this.cells = cells;
    }

    public Board(int dimension){
        cells = new Cell[dimension][dimension];
        for(int i = 0; i < dimension; i++){
            for(int j = 0; j < dimension; j++){
                cells[i][j] = new Cell(i,j);
            }
        }
    }

    public void display(){
        for(int i = 0; i< cells.length; i++){
            for(int j = 0; j < cells.length; j++){
                Cell currCell = cells[i][j];
                if(currCell.getPlayer() == null){
                    System.out.println("|       |" );
                }
                else{
                    System.out.println("|   " +currCell.getPlayer().getSymbol() + "    |" );
                }
            }
            System.out.println();
        }
    }
}
