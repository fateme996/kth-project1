package src.connect4.backend;

public class Board {
    private final int BOARD_HEIGHT = 6
    private final int[][] grid;
    private int currentPlayer;
    public int getCurrentPlayer() {
        return this.currentPlayer;
    }

    public boolean makeMove(int column) {
        for (int i = 0; i < BOARD_HEIGHT; i++) {
            if (this.grid[column][i] != 0) {
                this.grid[column][i] = currentPlayer;
                this.currentPlayer = this.currentPlayer & 1;
                this.currentPlayer += 1;
                return true;
            }
        }
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
