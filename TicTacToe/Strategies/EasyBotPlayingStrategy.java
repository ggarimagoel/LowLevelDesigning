package TicTacToe.Strategies;

import TicTacToe.models.*;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{
    @Override
    public Move decideMove(Board board, Player player) {

        for(int i = 0; i < board.getSize(); i++){
            for(int j = 0 ; j < board.getSize(); j++){
                if(board.getBoard().get(i).get(j).getCellState() == CellState.EMPTY){
                    return new Move(player, new Cell(i,j));
                }
            }
        }
        return null;
    }
}
