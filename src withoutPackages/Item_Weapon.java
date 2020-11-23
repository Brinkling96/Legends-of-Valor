package src;

public class Item_Weapon extends Item{

	//the class represents weapon which extends item class
	private int damage;
	private int handNum;

    public Item_Weapon(String name, int price, int lvl, int dmg, int handNum){
        super(name,price,lvl);
        this.damage = dmg;
        this.handNum = handNum;
    }

    public int getDmg(){
        return this.damage;
    }
    
    public int getHandsReq() {
    	return this.handNum;
    }
}
