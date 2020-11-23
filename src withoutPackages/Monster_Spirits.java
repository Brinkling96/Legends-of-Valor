package src;

public class Monster_Spirits extends Monster{

	//The class represent Spirits which extends monster class
	
	public Monster_Spirits(String name, int level, int dmg, int def, int dodge){
		super(name, level, dmg, def, dodge);
		setMonsterType("Spirits");
	}
}
