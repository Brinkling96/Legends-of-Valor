package src;

public class LOVHeroNexus extends LOVCell implements LOVBoostStrategy{

    public LOVHeroNexus(int row, int col) {
        super(row, col, 'H');
    }

    @Override
    public void doBoostBehavior(LOVHero hero) {
        resetBoost(hero);
    }

}
