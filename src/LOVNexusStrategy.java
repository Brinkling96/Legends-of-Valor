package src;

public class LOVNexusStrategy implements LOVBoostStrategy{
    @Override
    public void doBoostBehavior(Hero hero) {
        Market.getInstance().visitMarket(hero);
    }
}
