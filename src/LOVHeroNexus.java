package src;

public class LOVHeroNexus extends LOVCell{
	// the class represent Hero Nexus cells which extend LOVCell
    public LOVHeroNexus(int row, int col) {
        super(row, col, 'H');
    }

    @Override
    public void doBoostBehavior(Hero hero) {
        super.doBoostBehavior(hero);
    }

}
