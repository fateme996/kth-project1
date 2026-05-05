package src.connect4.backend;

public class Board {
    private final int[][] grid;
    private int currentPlayer;
    public int getCurrentPlayer() {
        return this.currentPlayer;
    }

    public boolean makeMove(int column) {
        return false;
    }

    int[][] getGrid() {
        return this.grid;
    }

    boolean checkWin() {
     return false;
    }

    boolean isDraw() {
        return false;
    }

    public Board(int startingPlayer) {
        this.grid = new int[7][6];
        this.currentPlayer = startingPlayer;
    }

    public Board() {
        this(1);
    }
}
