package src;

public class LOVKoulouCell extends LOVCell {
	// the class represent Koulou cells which extend LOVCell
    public LOVKoulouCell(int row, int col) {
        super(row, col, 'K');
    }

    @Override
    public void doBoostBehavior(Hero hero) {
        super.doBoostBehavior(hero);
        hero.setCellStre((int) (hero.getStre()*0.1));
    }
}
