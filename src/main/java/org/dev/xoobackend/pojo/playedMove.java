package org.dev.xoobackend.pojo;

public class playedMove {
    private int row;
    private int col;

    public playedMove(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString() {
        return "playedMove{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
