package TicTacToe.Strategies;

import TicTacToe.models.Board;
import TicTacToe.models.Move;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneWinningStrategy implements GameWinningStrategy {

        //for every row a hashmap of symbol vs count (for three rows 3 hashmaps etc)
        List<HashMap<Character, Integer>> rowMapList = new ArrayList<>();

        //for every col a hashmap of symbol vs count
        List<HashMap<Character, Integer>> colMapList = new ArrayList<>();

        //for every diag a hashmap of symbol vs count
        HashMap<Character, Integer> topLeftBottomRight= new HashMap<>();
        HashMap<Character, Integer> topRightBottomLeft = new HashMap<>();

        public OrderOneWinningStrategy(int dimension){
            for(int i = 0; i < dimension; i++){
                rowMapList.add(new HashMap<>());
                colMapList.add(new HashMap<>());
            }
        }
        public boolean checkWinner( Board board, Move move){
            char symbol = move.getPlayer().getSymbol();
            int row = move.getCell().getRow();
            int col = move.getCell().getCol();
            int dimension = board.getBoard().size();

            //update the count

            if(!rowMapList.get(row).containsKey(symbol)){   // if symbol does not exist, add it with val 0
                rowMapList.get(row).put(symbol,0);
            }
            if(!colMapList.get(col).containsKey(symbol)){
                colMapList.get(col).put(symbol,0);
            }
            rowMapList.get(row).put(symbol,rowMapList.get(row).get(symbol) + 1); // increase the symbol count
            colMapList.get(col).put(symbol,colMapList.get(col).get(symbol) + 1);


            //checking diagonal
            if(row == col){
                if(!topLeftBottomRight.containsKey(symbol)){
                    topLeftBottomRight.put(symbol, 0);
                }
                topLeftBottomRight.put(symbol, topLeftBottomRight.get(symbol)+1);
            }

            // checking anti diagonal
            if(row + col == dimension-1){
                if(!topRightBottomLeft.containsKey(symbol)){
                    topRightBottomLeft.put(symbol, 0);
                }
                topRightBottomLeft.put(symbol, topRightBottomLeft.get(symbol)+1);
            }

            // checking for winner
            if(rowMapList.get(row).get(symbol) == dimension ||colMapList.get(col).get(symbol) == dimension ){
                return true;
            }
            if(row == col && topLeftBottomRight.get(symbol) == dimension){
                return true;
            }
            if(row + col == dimension-1  && topRightBottomLeft.get(symbol) == dimension){
                return true;
            }
            return false;

        }
}
