package src;

public class Hero_Warriors extends Hero {

	//the class represents the warrior hero, extends the hero class

    public Hero_Warriors (String n,int mana, int stre, int agi, int dex, int imoney, int iexp){
        super(n,mana,stre,agi,dex,imoney,iexp);
        setHeroType("Warriors");
    }
    
    public void levelUp() {
    	super.levelUp();
    	strength = (int)(strength*1.1);
        agility = (int)(agility*1.1);
        dexterity = (int)(dexterity*1.05);
    }
}
