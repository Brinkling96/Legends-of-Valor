package src;

public class Item_Armor extends Item{

	//the class represents armor which extends item class
	
	private int dmg_red;
	
 	public Item_Armor(String name, int price, int lvlReq, int dmg_red){
		super(name, price, lvlReq);
		this.dmg_red = dmg_red;
	}
 	
 	public int getDmgRed() {
 		return this.dmg_red;
 	}
}
