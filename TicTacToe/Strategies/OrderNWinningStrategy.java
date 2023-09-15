package TicTacToe.Strategies;

import TicTacToe.models.Board;
import TicTacToe.models.Cell;
import TicTacToe.models.Move;
import TicTacToe.models.Player;

import java.util.List;

public class OrderNWinningStrategy implements GameWinningStrategy {

    private int dimension;

    public OrderNWinningStrategy(int dimension) {
        this.dimension = dimension;
    }

    @Override
    public boolean checkWinner(Board board, Move move) {

        Player player = move.getPlayer();
        Cell cell = move.getCell();
        List<List<Cell>> cells = board.getBoard();
        int curr_row = cell.getRow();
        int curr_col = cell.getCol();

        // checking row win
        boolean flagrow = true;
        for(int i = 0; i < cells.size();i++){
            if(cells.get(curr_row).get(i).getPlayer() != player){
                flagrow = false;
                break;
            }
        }

        // checking col win
        boolean flagcol = true;
        for(int i = 0; i < cells.size();i++){
            if(cells.get(i).get(curr_col).getPlayer() != player){
                flagcol = false;
                break;
            }
        }

        // Check diagonal from top-left to bottom-right
        boolean diagflag = true;
        if (curr_row == curr_col) {
            for (int i = 0; i < dimension; i++) {
                if (cells.get(i).get(i).getPlayer() != player) {
                    diagflag = false;
                    break;
                }
            }
            if (diagflag) {
                return true;
            }
        }

        // Check diagonal from top-right to bottom-left
        boolean antidiagflag = true;
        if (curr_row + curr_col == dimension - 1) {

            for (int i = 0; i < dimension; i++) {
                if (cells.get(i).get(dimension - 1 - i).getPlayer() != player) {
                    antidiagflag = false;
                    break;
                }
            }
            if (antidiagflag) {
                return true;
            }
        }

        return flagrow||flagcol||antidiagflag||diagflag;
    }
}
