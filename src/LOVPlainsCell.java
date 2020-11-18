package src;

public class LOVPlainsCell extends LOVCell implements LOVBoostStrategy{

    public LOVPlainsCell(int row, int col) {
        super(row, col, 'P');
    }

    @Override
    public void doBoostBehavior(Hero hero) {
        resetBoost(hero);
    }
}
