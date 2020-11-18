package src;

public abstract class LOVCell extends Cell{
    private char[] positions;

    public LOVCell(int row, int col, char cellType) {
        super(row, col, cellType);
        this.positions = new char[2];
    }

}
