package src;

public class LOVInaccesibleCell extends LOVCell{
    public LOVInaccesibleCell(int row, int col) {
        super(row, col, '&');
        setPositions(new char[]{'X','X'});
    }

}