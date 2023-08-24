package TicTacToe.model;
public class Move {
    private Player player;
    private int row;
    private int col;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public  Move( Player player,int row, int col){
        this.player = player;  // decided by game(next turn)
        this.setRow(row);      // decided by user
        this.setCol(col);      // decided by user
    }
}
