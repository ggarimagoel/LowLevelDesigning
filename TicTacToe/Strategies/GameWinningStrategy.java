package TicTacToe.Strategies;

import TicTacToe.models.Board;
import TicTacToe.models.Move;

public interface GameWinningStrategy {
    boolean checkWinner(Board board, Move move);
}
