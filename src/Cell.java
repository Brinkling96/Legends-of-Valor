package src;

public class Cell {

	//The class represent cells of the board with row and column, and the type of the cell
	private int row;
	private int col;
	private char cellType;
	private int isHero;
	private int isMonster;
	
	public Cell(int row, int col, char cellType) {
		this.row = row;
		this.col = col;
		this.cellType= cellType;
		this.isHero = 0;
		this.isMonster = 0;
	}
	
	public int getRow() {
		return this.row;
	}
	
	public int getCol() {
		return this.col;
	}
	
    public void setCellType(char type){
        this.cellType = type;
    }

    public char getCellType(){
        return this.cellType;
    }

    public void setIsHero(int num) {
    	this.isHero = num;
    }
	public void setIsMonster(int num) {
		this.isMonster = num;
	}
    public int getIsHero() {
    	return this.isHero;
    }
    public int getIsMonster() {
    	return this.isMonster;
    }
	
}

