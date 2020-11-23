package src;

public class Item implements canBuyAndSell{

	//the class represent all items sold in market, which can buy and sell
	//and the class also is extended by class Armor, Weapon, Potion and Spell
	
	private String name;
	private int price;
	private int levelReq;
	
	public Item(String name, int p, int lvlReq){
        this.name= name;
        this.price = p;
        this.levelReq= lvlReq;
    }
	
    public String getItemName(){
        return this.name;
    }
    public int getPrice(){
        return this.price;
    } 
    public int getLevelReq(){
        return this.levelReq;
    }
	public boolean heroOwn(Hero hero) {
		return false;
	}
}
