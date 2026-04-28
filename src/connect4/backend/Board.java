package src.connect4.backend;

public class Board {
    public enum Turn {
        RED,
        YELLOW;
    }
    private Turn turn;
    public Turn getCurrentTurn() {
        return this.turn;
    }

    public void makeMove(int column) {

    }

    public Board() {

    }
}
