package src;

public class LOVCaveCell extends LOVCell implements LOVBoostStrategy{
    public LOVCaveCell(int row, int col) {
        super(row, col, 'C');

    }

    @Override
    public void doBoostBehavior(LOVHero hero) {
        resetBoost(hero);
        hero.setCellAgi((int) (hero.getAgi()*0.1));
    }
}
