package src.connect4.backend;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class BoardTest {
    private Board board;
    private int[][] grid;

    @Before
    public void setUp() {
        this.board = new Board();
        this.grid = new int[6][7];
    }

    @Test
    public void canAddToken() {
        board.makeMove(4);
        this.grid[0][4] = 1;
        assertArrayEquals(this.grid, board.getGrid());
    }

    @Test
    public void canWinVertical() {
        board.makeMove(4);
        board.makeMove(3);
        board.makeMove(4);
        board.makeMove(3);
        board.makeMove(4);
        board.makeMove(3);
        board.makeMove(4);
        assertTrue(board.checkWin());
    }

    @Test
    public void canWinHorizontal() {
        board.makeMove(0);
        board.makeMove(0);
        board.makeMove(1);
        board.makeMove(1);
        board.makeMove(2);
        board.makeMove(2);
        board.makeMove(3);
        //System.out.println(board.displayBoard());
        assertTrue(board.checkWin());
    }

    @Test
    public void canWinFirstDiagonal() {
        board.makeMove(0);
        board.makeMove(1);
        board.makeMove(1);
        board.makeMove(0);
        board.makeMove(2);
        board.makeMove(2);
        board.makeMove(2);
        board.makeMove(3);
        board.makeMove(3);
        board.makeMove(3);
        board.makeMove(3);
        System.out.println(board.displayBoard());
        assertTrue(board.checkWin());
    }

    @Test
    public void canWinFirstDiagonalShifted() {
        board.makeMove(3);
        board.makeMove(4);
        board.makeMove(4);
        board.makeMove(3);
        board.makeMove(5);
        board.makeMove(5);
        board.makeMove(5);
        board.makeMove(6);
        board.makeMove(6);
        board.makeMove(6);
        board.makeMove(6);
        System.out.println(board.displayBoard());
        assertTrue(board.checkWin());
    }

    @Test
    public void canWinSecondDiagonal() {
        board.makeMove(3);
        board.makeMove(2);
        board.makeMove(2);
        board.makeMove(3);
        board.makeMove(1);
        board.makeMove(1);
        board.makeMove(1);
        board.makeMove(0);
        board.makeMove(0);
        board.makeMove(0);
        board.makeMove(0);
        System.out.println(board.displayBoard());
        assertTrue(board.checkWin());
    }

    @Test
    public void canWinSecondDiagonalShifted() {
        board.makeMove(6);
        board.makeMove(5);
        board.makeMove(5);
        board.makeMove(6);
        board.makeMove(4);
        board.makeMove(4);
        board.makeMove(4);
        board.makeMove(3);
        board.makeMove(3);
        board.makeMove(3);
        board.makeMove(3);
        System.out.println(board.displayBoard());
        assertTrue(board.checkWin());
    }
}
