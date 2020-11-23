package src;

import java.util.Random;

public class Monster extends Creature implements MonsterAttack, Cloneable{

	//The class represent all Monsters, and extends Creature class
	//the class also extended by class Monster_Dragons, Monster_Exoskeletons, Monster_Spirits
    private int damage;
    private int dodgeChance;
    private int defense;
    private String monsterType;


    public Monster(String name, int level, int damage, int defense, int dodgeC){
        super(name,level);
        this.damage = damage;
        this.defense = defense;
        this.dodgeChance = dodgeC;
    }

	@Override
	public Monster clone(){
		return new Monster(this.name, this.level, this.damage, this.defense, this.dodgeChance);
	}

	public void setMonsterType(String str) {
		this.monsterType = str;
	}
	public String getMonsterType() {
		return this.monsterType;
	}
	public String getName() {
		return name;
	}
	public int getDamage(){
		return damage;
	}
	public int getDefense(){
		return defense;
	}
	public float getDodgeRate(){
		return dodgeChance;
	}
	public int getHp() {
		return hp;
	}
	
	public void reset() {
		hp = 100*level;
	}
	
	public void takenDmg(int dmg) {
		Random r  = new Random();
		int random = r.nextInt(100);
		if(dodgeChance>random) {
			System.out.println(name+" dodged the attack!");
		}else{
			dmg = (int) (dmg - defense*0.05);
			hp -= dmg;
			if(dmg>0){
				hp = hp-dmg;
				if(hp > 0) {
					System.out.println(name+" taken damage:" +dmg+",hp left: "+ hp);
				}else {
					hp = 0;
					System.out.println(name+" taken damage:" +dmg+",hp left: "+ hp+"! "+name+" defeated!");
				}
			}else {
				System.out.println(name+" defensed the attack!");
			}
		}
	}
	
	public void takenMagic(int dmg, Item_Spell spell) {
		defense = (int) (defense*spell.getDefenseRed());
		dmg -= (int) (dmg*spell.getDmgRed() - defense*0.05);
		dodgeChance = (int) (dodgeChance*spell.getDodgeRed());		
		int random  = new Random().nextInt(100);
		if(dodgeChance>random) {
			System.out.println(name+" dodged the spell!");
		}else {
			if(dmg>0) {
				hp = hp-dmg;
				if(hp>0) {
					System.out.println(name+" taken spell damage:" +dmg+",hp left: "+ hp);
				}else {
					hp = 0;
					System.out.println(name+" taken spell damage:" +dmg+",hp left: "+ hp+"! "+name+" defeated!");
				}
			}else {
				System.out.println(name+" defensed the spell attack!");
			}

		}
	}
	
	public void attack(Hero h) {
		if(hp>0) {
			System.out.println(name+" is fighting back to "+h.getName()+"!");
			h.takenDmg(damage);
		}
		
	}

}
