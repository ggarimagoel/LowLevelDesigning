package TicTacToe.models;

import java.util.Scanner;

public class Player {
    private String name;
    private char symbol;
    private  PlayerType playerType;

    public Player(String name, char symbol, PlayerType playerType) {
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

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

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Move decideMove(Board board){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter row to make move : ");
        int row = sc.nextInt();
        System.out.println("enter col to make move : ");
        int col = sc.nextInt();

        return new Move(this, new Cell(row,col));
    }
}
