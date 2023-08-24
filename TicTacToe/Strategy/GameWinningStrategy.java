package TicTacToe.Strategy;
import  TicTacToe.model.Board;
import  TicTacToe.model.GameState;
import  TicTacToe.model.Player;
import  TicTacToe.model.Cell;

public interface GameWinningStrategy {
    GameState chkForWinner(Board board, Player player, Cell cell);
}
