package TicTacToe.models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Board {
    private int size;
    private List<List<Cell>> cells;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cell>> getBoard() {
        return cells;
    }

    public void setBoard(List<List<Cell>> cells) {
        this.cells = cells;
    }

    public Board(int size){
        this.size = size;
        this.cells = new ArrayList<>();

        for(int i = 0 ; i < size; i++){
            this.cells.add(new ArrayList<>());
            for(int j = 0 ; j < size; j++){
                this.cells.get(i).add(new Cell(i,j));
            }
        }
    }

    public  void displayBoard(){
        for(int i = 0; i < cells.size(); i++){
            for(int j = 0 ; j < cells.size(); j++){
                Cell curr = cells.get(i).get(j);
                if(curr.getCellState().equals(CellState.EMPTY)){
                    System.out.print("|    |");
                }else{
                    System.out.print("|   " + curr.getPlayer().getSymbol() + "|");
                }
            }
            System.out.println();
        }
    }
     public void applyMove(Move move){
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        this.getBoard().get(row).get(col).setCellState(CellState.FILLED);
        this.getBoard().get(row).get(col).setPlayer(move.getPlayer());

     }
}
