package src;

public class Monster_Exoskeletons extends Monster{

	//The class represent exoskeletons which extends monster class
	
	public Monster_Exoskeletons(String name, int level, int dmg, int def, int dodge){
		super(name, level, dmg, def, dodge);
		setMonsterType("Exoskeletons");
	}
}
