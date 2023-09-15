package TicTacToe.models;

import TicTacToe.Exceptions.InvaildGameDimensionException;
import TicTacToe.Strategies.GameWinningStrategy;
import TicTacToe.Strategies.OrderNWinningStrategy;
import TicTacToe.Strategies.OrderOneWinningStrategy;

import java.util.ArrayList;
import java.util.List;

    public class Game {
    private Board board;
    private List<Player> players;
    private  List<Move> moves;
    private GameStatus gameStatus;
    private  int turn;
    private Player winner;
    private GameWinningStrategy gameWinningStrategy;

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameWinningStrategy getGameWinningStrategy() {
        return gameWinningStrategy;
    }

    public void setGameWinningStrategy(GameWinningStrategy gameWinningStrategy) {
        this.gameWinningStrategy = gameWinningStrategy;
    }

    public  static Builder getBuilder(){
        return new Builder();
    }

    public void makeNextMove()  {
        Player curr = players.get(turn);
        System.out.println("It is " + curr.getName() + " 's  turn");
        Move move = curr.decideMove(board);

        int row= move.getCell().getRow();
        int col = move.getCell().getCol();

        if(board.getBoard().get(row).get(col).getCellState().equals(CellState.EMPTY)){
            board.applyMove(move);
            moves.add(move);

            //check for winner
            if(gameWinningStrategy.checkWinner(board,move)){
                gameStatus = GameStatus.ENDED;
                winner = curr;
            }
            //chk for  draw
            if( moves.size() == board.getSize()* board.getSize()){
                gameStatus = GameStatus.DRAW;
            }
           // next player takes the turn
            turn = turn+1;
            turn = turn% players.size();
        }
        else{
            //throw an execption
        }
    }

    // builder class
        public static class  Builder{
        private int dimension;
        private List<Player> players;

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }
        public Builder setDimension( int dimension) {
            this.dimension = dimension;
            return this;
        }
        public Game build(){
            // validations
            try{
                isValid();
            }
            catch(InvaildGameDimensionException e){
                return null;
            }
            Game game = new Game();
            game.setBoard(new Board(dimension));
            game.setPlayers(players);
            game.setMoves(new ArrayList<>());
            game.setGameStatus(GameStatus.IN_PROGRESS);
            game.setGameWinningStrategy(new OrderNWinningStrategy(dimension));

            return game;
        }

        private boolean isValid() throws InvaildGameDimensionException{
            if(dimension < 3){
                throw new InvaildGameDimensionException("Dimension should be greater than 2");
            }
            if(players.size() < 2){
                throw new InvaildGameDimensionException("number of players  should be greater than 1");
            }
            return true;
        }
    }
}
