package TicTacToe;

import TicTacToe.Controller.GameController;
import TicTacToe.Exceptions.InvaildGameDimensionException;
import TicTacToe.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    public static void main(String[] args) throws InvaildGameDimensionException {
        System.out.println("Hello welcome to TIC TAC TOE game");
        Scanner sc = new Scanner(System.in);

        System.out.println("enter dimension of board : ");
        int dimension = sc.nextInt();

        System.out.println("enter number of players : ");
        int noOfPlayers = sc.nextInt();

        List<Player> players = new ArrayList<>();

        System.out.println("will there be a bot player : y/n");
        String isBot = sc.next();

        if(isBot.equals("y")){
            noOfPlayers = noOfPlayers - 1;

            System.out.println(" enter name of bot : ");
            String name = sc.next();

            System.out.println("enter symbol of bot : ");
            String botSymbol = sc.next();

            System.out.println("enter bot difficulty level : 1-easy, 2-medium, 3-hard");
            int difficultyLevel = sc.nextInt();

//            todo for value to enum
            players.add(new Bot(name, botSymbol.charAt(0) , BotDifficultyLevel.EASY));
        }

        for(int i = 0; i < noOfPlayers; i++){
            System.out.println("enter name of player " + i+1);
            String name = sc.next();

            System.out.println("enter symbol of player " + i+1);
            String symbol = sc.next();

            Player player = new Player(name , symbol.charAt(0), PlayerType.HUMAN);
            players.add(player);
        }

        GameController gameController = new GameController();
        Game game = gameController.createGame(dimension,players);

        while(gameController.getGameStatus(game)==GameStatus.IN_PROGRESS){
            //TODO play the game
            //break
            System.out.println("current Board : ");
            gameController.displayBoard(game);
            gameController.executeNextMove(game);
        }
        if(gameController.getGameStatus(game) == GameStatus.DRAW){
            System.out.println("Game is draw. nobody wins");
            gameController.displayBoard(game);
        }else{
            System.out.println("CONGRATULATIONS!! Game is won by " + gameController.getWinner(game));
            gameController.displayBoard(game);
        }
    }
}
