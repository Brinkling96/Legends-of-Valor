package src;

public class Marker {
    private int row;
    private int column;
    private char display;

    public Marker(int row, int column, char display) {
        this.row = row;
        this.column = column;
        this.display = display;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public char getDisplay() {
        return display;
    }

    public void setDisplay(char display) {
        this.display = display;
    }
}
