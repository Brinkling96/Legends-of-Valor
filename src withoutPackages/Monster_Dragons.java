package src;

public class Monster_Dragons extends Monster{

	//The class represent dragons which extends monster class
	
	public Monster_Dragons(String name, int level, int dmg, int def, int dodge){
		super(name, level, dmg, def, dodge);
		setMonsterType("Dragons");
	}
}
