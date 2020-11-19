package src;

public class LOVBushCell extends LOVCell{
    public LOVBushCell(int row, int col) {
        super(row, col, 'B');
    }

    @Override
    public void doBoostBehavior(Hero hero) {
        super.doBoostBehavior(hero);
        hero.setCellDex((int) (hero.getDex()*0.1));
    }

}
