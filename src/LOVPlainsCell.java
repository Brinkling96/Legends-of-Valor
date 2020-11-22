package src;

public class LOVPlainsCell extends LOVCell {
	// the class represent plain cells which extend LOVCell
    public LOVPlainsCell(int row, int col) {
        super(row, col, 'P');
    }

    @Override
    public void doBoostBehavior(Hero hero) {
        super.doBoostBehavior(hero);
    }
}
