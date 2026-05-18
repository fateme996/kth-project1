package src.connect4.backend;

public class Board {
    private final int BOARD_HEIGHT = 6;
    private final int[][] grid;
    private int currentPlayer;
    private int lastMoveX;
    private int lastMoveY;
    public int getCurrentPlayer() {
        return this.currentPlayer;
    }

    public boolean makeMove(int column) {
        for (int i = 0; i < BOARD_HEIGHT; i++) {
            if (this.grid[i][column] == 0) {
                this.grid[i][column] = currentPlayer;
                this.currentPlayer = this.currentPlayer & 1;
                this.currentPlayer += 1;
                this.lastMoveX = column;
                this.lastMoveY = i;
                return true;
            }
        }
        return false;
    }

    public int[][] getGrid() {
        return this.grid;
    }

    public boolean checkWin() {
        int checkingPlayer = this.grid[this.lastMoveY][this.lastMoveX];
        // check vertical
        int inARow = 0;
        for (int i = -3; i <= 3; i++) {
            int currentY = this.lastMoveY + i;
            if (currentY >= 0 && currentY < 6) {
                if (this.grid[currentY][this.lastMoveX] == checkingPlayer) {
                    inARow += 1;
                } else {
                    inARow = 0;
                }
            }
            if (inARow >= 4) {
                return true;
            }
        }
        // check horizontal
        inARow = 0;
        for (int i = -3; i <= 3; i++) {
            int currentX = this.lastMoveX + i;
            if (currentX >= 0 && currentX < 7) {
                if (this.grid[currentX][lastMoveY] == checkingPlayer) {
                    inARow += 1;
                } else {
                    inARow = 0;
                }
            }
            if (inARow >= 4) {
                return true;
            }
        }
        // check first diagonal
        inARow = 0;
        for (int i = -3; i <= 3; i++) {
            int currentX = this.lastMoveX + i;
            int currentY = this.lastMoveY + i;
            if (currentX >= 0 && currentX < 7 && currentY > 0 && currentY < 6) {
                if (this.grid[currentX][currentY] == checkingPlayer) {
                    inARow += 1;
                } else {
                    inARow = 0;
                }
            }
            if (inARow >= 4) {
                return true;
            }
        }
        // check second diagonal
        inARow = 0;
        for (int i = -3; i <= 3; i++) {
            int currentX = this.lastMoveX + i;
            int currentY = this.lastMoveY - i;
            if (currentX >= 0 && currentX < 7 && currentY >= 0 && currentY < 6) {
                if (this.grid[currentX][currentY] == checkingPlayer) {
                    inARow += 1;
                } else {
                    inARow = 0;
                }
            }
            if (inARow >= 4) {
                return true;
            }
        }
        return false;
    }

    public boolean isDraw() {
        return false;
    }

    public Board(int startingPlayer) {
        this.grid = new int[6][7];
        this.currentPlayer = startingPlayer;
    }

    public Board() {
        this(1);
    }
}
