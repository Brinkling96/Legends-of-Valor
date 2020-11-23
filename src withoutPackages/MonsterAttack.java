package src;

public interface MonsterAttack {

	//interface represents that monsters can attack
	public void takenDmg(int dmg);
	public void takenMagic(int d, Item_Spell s);
	public void attack(Hero h);
}
