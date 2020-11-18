package src;

public class LOVBoostCells extends LOVCell{
    private LOVBoostStrategy boostStrategy;


    public LOVBoostCells(int row, int col, char cellType, LOVBoostStrategy boostStrategy) {
        super(row, col, cellType);
        this.boostStrategy = boostStrategy;
    }

    public void doBoostStrategy(Hero hero){
        boostStrategy.doBoostBehavior(hero);
    }
}
