package TicTacToe.Strategy;

import TicTacToe.model.Board;
import TicTacToe.model.Cell;
import TicTacToe.model.GameState;
import TicTacToe.model.Player;

public class OrderOfNWinningStrategy implements GameWinningStrategy{
    public GameState chkForWinner(Board board, Player player, Cell cell){
        Cell[][] cells = board.getCells();

        //chking row win

        int currRow = cell.getRow();
        boolean flagRow = true;
        for(int j = 0; j < cells.length;j++){
            if(cells[currRow][j].getPlayer() != player ){
                flagRow = false;
                break;
            }
        }
//        if(flag){
//            return GameState.END_IN_RESULT;
//        }

        //chking col win

        int currCol = cell.getCol();
        boolean flagCol = true;
        for(int i = 0; i < cells.length;i++){
            if(cells[currCol][i].getPlayer() != player ){
                flagCol = false;
                break;
            }
        }

        // chking diagnol win
        boolean flagDiag = true;
        if(currRow ==currCol){

            for(int i = 0; i < cells.length; i++){
                if(cells[i][i].getPlayer() != player){
                    flagDiag = false;
                    break;
                }
            }
        }

        // chking Antidiagnol win
        boolean flagAntiDiag = true;
        if(currRow + currCol == cells.length-1){

            for(int i = 0; i < cells.length; i++){
                if(cells[i][cells.length-1-i].getPlayer() != player){
                    flagAntiDiag = false;
                    break;
                }
            }
        }
        if(flagRow == true||flagCol == true|| flagDiag == true||flagAntiDiag == true){
            return GameState.END_IN_RESULT;
        }

        // end in draw


    }

}
