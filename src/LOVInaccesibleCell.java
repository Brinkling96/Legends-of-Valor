package src;

public class LOVInaccesibleCell extends LOVCell{
	// the class represent Inaccesible cells which extend LOVCell
    public LOVInaccesibleCell(int row, int col) {
        super(row, col, '&');
        setPositions(new char[]{'X','X'});
    }

    @Override
    public void doBoostBehavior(Hero hero) {
        //DO nothing for now...
    }
}
