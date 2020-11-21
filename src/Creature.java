package src;

public class Creature{

	//the class represent all characters which is hero and monster
	//the class was extended by class hero and monster

	 protected String name;
	 protected int level;
	 protected int hp;
	 protected String cellName="";
	 protected int row;
	 protected int col;

	protected char marker;


	 
	 
	 public Creature(String name, int level){
		 this.name = name;
		 this.level = level;
		 this.hp = 100*level;
	}

	public void setCreaturePosition(LOVBoard board, int row, int col){
		LOVCell temp = board.getCell(row,col);
		char[] pos = temp.getPositions();
		this.row = row;
		this.col = col;
		if (marker !='M'){
			temp.setPositions(new char[]{marker,pos[1]});// needs to be set to old position
		}
		else{
			temp.setPositions(new char[]{pos[0],marker});
		}
	}


	public char getMarker() {
		return marker;
	}

	public void setMarker(char marker) {
		this.marker = marker;
	}

	public void setCellName(String n) {
		 cellName = n;
	 }
	 
	 public String getCellName() {
		 return this.cellName;
	 }
	 
	 public void setRow(int r) {
		 row = r;
	 }
	 
	 public void setCol(int c) {
		 col = c;
	 }
	 
	 public int getRow() {
		 return row;
	 }
	 
	 public int getCol() {
		 return col;
	 }

	 public int getLv() {
		 return this.level;
	 }


	 public boolean isDead(){
	 	if(hp < 1){
	 		return true;
		}
	 	return false;
	 }
}
