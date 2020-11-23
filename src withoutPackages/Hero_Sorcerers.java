package src;

public class Hero_Sorcerers extends Hero{

	//the class represents the sorcerer hero, extends the hero class
    
    public Hero_Sorcerers (String n,int mana, int stre, int agi, int dex, int imoney, int iexp){
        super(n,mana,stre,agi,dex,imoney,iexp);
        setHeroType("Sorcerers");
    }
    
    public void levelUp() {
    	super.levelUp();
    	strength = (int)(strength*1.05);
        agility = (int)(agility*1.1);
        dexterity = (int)(dexterity*1.1);
    }
}
