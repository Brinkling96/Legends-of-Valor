package src;

public class LOVSpecialCells extends LOVCell{
    private LOVSpecialStrategy specialStrategy;

    public LOVSpecialCells(int row, int col, char cellType, LOVSpecialStrategy specialStrategy) {
        super(row, col, cellType);
        this.specialStrategy = specialStrategy;
    }

}
