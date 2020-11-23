package src;

public class Hero_Paladins extends Hero {

	//The class represent the Paladin hero, extends the hero class
    
    public Hero_Paladins (String name,int mana, int stre, int agi, int dex, int imoney, int iexp){
        super(name,mana,stre,agi,dex,imoney,iexp);
        setHeroType("Paladins");
    }   

    public void levelUp() {
    	super.levelUp();
    	strength = (int)(strength*1.1);
        agility = (int)(agility*1.05);
        dexterity = (int)(dexterity*1.1);
    }
}
