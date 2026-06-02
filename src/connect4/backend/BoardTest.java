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
}
