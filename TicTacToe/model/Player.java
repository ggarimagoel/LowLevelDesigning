package TicTacToe.model;

import java.util.Scanner;

public class Player {
    private String name;
    private char symbol;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public Player(String name, char symbol){
       this.setName(name);              //not this.name = name; bec we are taking input from user here from scanner
       this.setSymbol(symbol);            //not  this.symbol= symbol;bec we are taking input from user here from scanner
    }

    public Move decideMove(Board board){

        Scanner sc = new Scanner(System.in);

        System.out.println("tell row for move");
        int row = sc.nextInt();

        System.out.println("tell col for move");
        int col = sc.nextInt();

        if(row < 0 || row >= board.getCells().length || col < 0 || col >= board.getCells()[0].length){
            System.out.println("invalid input . try again");
                board.display();
                Move move = this.decideMove(board);
                return move;
        }
        if(board.getCells()[row][col].getPlayer() != null){
            System.out.println("already occupied");
            board.display();
            Move move = this.decideMove(board);
            return move;
        }
        else{
            return new Move(this, row,col);
        }
    }
}
