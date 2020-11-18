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


	 
	 
	 public Creature(String name, int level){
		 this.name = name;
		 this.level = level;
		 this.hp = 100*level;
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
}
