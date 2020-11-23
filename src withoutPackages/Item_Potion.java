package src;

public class Item_Potion extends Item{

	//the class represents potion which extends item
	
    private int hp, mana, dex, stre, agi;

    public Item_Potion(String name,int price, int lvlReq, int hp, int mana, int dex, int stre, int agi){
        super(name,price,lvlReq);
        this.hp = hp;
        this.mana = mana;
        this.dex = dex;
        this.stre = stre;
        this.agi = agi;
    }

    public int getAgi() {
        return agi;
    }
    public int getStr(){
        return stre;
    }
    public int getDex(){
        return dex;
    }
    public int getMana(){
        return mana;
    }
    public int getHp(){
        return this.hp;
    }


    
}
