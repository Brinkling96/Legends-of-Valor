package src;

public class LOVBushCell extends LOVCell implements LOVBoostStrategy{
    public LOVBushCell(int row, int col) {
        super(row, col, 'B');
    }

    @Override
    public void doBoostBehavior(LOVHero hero) {
        resetBoost(hero);
        hero.setCellDex((int) (hero.getDex()*0.1));
    }

}
