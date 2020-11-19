package src;

public class LOVKoulouCell extends LOVCell implements LOVBoostStrategy {
    public LOVKoulouCell(int row, int col) {
        super(row, col, 'K');
    }

    @Override
    public void doBoostBehavior(LOVHero hero) {
        resetBoost(hero);
        hero.setCellStre((int) (hero.getStre()*0.1));
    }
}
