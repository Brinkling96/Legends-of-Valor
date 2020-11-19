package src;

public class LOVMonsterNexus extends LOVCell implements LOVBoostStrategy{
    public LOVMonsterNexus(int row, int col) {
        super(row, col, 'V');
    }

    @Override
    public void doBoostBehavior(LOVHero hero) {
        resetBoost(hero);
    }
}
