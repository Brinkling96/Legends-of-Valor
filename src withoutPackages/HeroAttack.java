package src;

public interface HeroAttack {

	//interface represents that heroes can attack 
	public void attack(Monster m);
	public void magicAttack(Monster m);
	public void takenDmg(int d);
}
