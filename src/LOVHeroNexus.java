package src;

public class LOVHeroNexus extends LOVCell{

    public LOVHeroNexus(int row, int col) {
        super(row, col, 'H');
    }

    @Override
    public void doBoostBehavior(Hero hero) {
        super.doBoostBehavior(hero);
        System.out.println("Visit Market");
        //if yes
        Market.getInstance().visitMarket(hero);
    }

}
