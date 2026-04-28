package src.connect4.backend;

public class Board {
    private int currentPlayer;
    public int getCurrentPlayer() {
        return this.currentPlayer;
    }

    public boolean makeMove(int column) {
        return false;
    }

    int[][] getGrid() {
        return new int[0][0];
    }

    boolean checkWin() {
     return false;
    }

    boolean isDraw() {
        return false;
    }

    public Board() {

    }
}
