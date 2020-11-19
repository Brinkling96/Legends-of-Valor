package src;

import java.util.ArrayList;

public abstract class LOVCell extends Cell{
    private char[] positions;
    private ArrayList<String> display;

    public LOVCell(int row, int col, char cellType) {
        super(row, col, cellType);
        this.positions = new char[2];
        this.display = new ArrayList<String>();
        display.add(cellType + "------"+ cellType);
        display.add("| "+ ' ' + "  " + ' ' + " |");
        display.add(cellType + "------"+ cellType);
    }

    public void setPositions(char[] positions) {
        this.positions = positions;
        display.set(1,("| "+ this.positions[0] +"  "+ this.positions[1] + " |") );
    }

    public char[] getPositions(){
        return positions;
    }

    public int getPositionsOpen() {
        for (int i = 0; i < positions.length; i++) {
            if (positions[i] == ' ') {
                return i;
            }
        }
        return -1;
    }

    public ArrayList<String> display() {
        return display;
    }
}
