package src;

public class LOVCaveCell extends LOVCell{
    public LOVCaveCell(int row, int col) {
        super(row, col, 'C');

    }

    @Override
    public void doBoostBehavior(Hero hero) {
        super.doBoostBehavior(hero);
        hero.setCellAgi((int) (hero.getAgi()*0.1));
    }
}
