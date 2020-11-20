package src;

import java.util.ArrayList;

public abstract class LOVCell extends Cell implements LOVBoostStrategy{
    private char[] positions;
    private ArrayList<String> display;

    public LOVCell(int row, int col, char cellType) {
        super(row, col, cellType);
        this.positions = new char[]{' ',' '};
        this.display = new ArrayList<String>();
        display.add(cellType + "------"+ cellType);
        display.add("| "+ this.positions[0] +"  "+ this.positions[1] +" |");
        display.add(cellType + "------"+ cellType);
    }

    @Override
    public void doBoostBehavior(Hero hero) {
        resetBoost(hero);
    }

    public void setPositions(char[] positions) {
        this.positions = positions;
        display.set(1,("| "+ this.positions[0] +"  "+ this.positions[1] + " |") );
    }

    public char[] getPositions(){
        return positions;
    }

    public ArrayList<String> display() {
        return display;
    }
}
