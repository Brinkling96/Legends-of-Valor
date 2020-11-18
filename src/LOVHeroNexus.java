package src;

public class LOVHeroNexus extends LOVCell implements LOVBoostStrategy{

    public LOVHeroNexus(int row, int col) {
        super(row, col, 'H');
    }

    @Override
    public void doBoostBehavior(Hero hero) {
        resetBoost(hero);
        System.out.println("Visit Market");
        //if yes
        Market.getInstance().visitMarket(hero);
    }

}
