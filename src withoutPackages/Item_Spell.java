package src;

public class Item_Spell extends Item{

	//the class represent spells which have 3 types and also extends item class
	
	private int damage;
    private int manaCost;
    private String spellType;
    private double redDmg=1.0;
    private double redDodge=1.0;
    private double redDef=1.0;

    public Item_Spell(String name, int price, int lvl, int dmg, int manaCost, String spellType){
        super(name, price, lvl);
        this.damage = dmg;
        this.manaCost = manaCost;
        this.spellType = spellType;
        spellExe();
    }
    
    public void spellExe() {
    	if(spellType.equals("ice")) {
    		redDmg = 0.9;
    	}else if(spellType.equals("fire")) {
    		redDef = 0.9;
    	}else {
    		redDodge = 0.9;
    	}
    }
    
    public int getDmg(){
        return this.damage;
    }
    public int getManaC(){
        return this.manaCost;
    }
    public double getDmgRed(){
        return this.redDmg;
    }
    public double getDodgeRed(){
        return this.redDodge;
    }
    public double getDefenseRed(){
        return this.redDef;
    }
    public String getSpellType(){
        return this.spellType;
    }
    
    
}
