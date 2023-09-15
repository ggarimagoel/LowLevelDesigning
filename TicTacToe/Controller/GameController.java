package TicTacToe.Controller;

import TicTacToe.Exceptions.InvaildGameDimensionException;
import TicTacToe.models.Game;
import TicTacToe.models.GameStatus;
import TicTacToe.models.Player;

import java.util.List;

public class GameController {
    public Game createGame(int dimension, List<Player> players){
        return Game.getBuilder().
                setDimension(dimension).
                setPlayers(players).build();


    }
    public GameStatus getGameStatus(Game game){
        return game.getGameStatus();
    }
    public String getWinner(Game game){
        return game.getWinner().getName();
    }
    public void setGameStatus(Game game, GameStatus gameStatus){
        game.setGameStatus(gameStatus);
    }
    public  void displayBoard(Game game){
        game.getBoard().displayBoard();
    }
    public void executeNextMove(Game game) throws InvaildGameDimensionException {
        game.makeNextMove();
    }
}
