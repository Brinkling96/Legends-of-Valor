package src;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hero extends Creature implements HeroAttack {

	//The class represent all heroes, and extends Creature class
	//the class also extended by class Hero_Paladins, Hero_Sorcerers, Hero_Warriors
	Scanner in = new Scanner(System.in);
	private int mana;
    protected int strength;
    protected int agility;
    protected int dexterity;
    protected int cellStre;
    protected int cellAgi;
    protected int cellDex;

    private int money;
    private int exp;
    private String heroType;
	
    private Item_Weapon curWeapon = null;
    private Item_Armor curArmor = null;
    private Item_Spell curSpell = null;
    private ArrayList<Item_Weapon> weapon_storage;
    private ArrayList<Item_Armor> armor_storage;
    private ArrayList<Item_Potion> potion_storage;
    private ArrayList<Item_Spell> spell_storage;
    
	public Hero(String n,int mana, int stre, int agi, int dex, int money, int exp) {
		super(n,1);
		this.mana = mana;
        this.strength= stre;
        this.agility=agi;
        this.dexterity= dex;
        this.money= money;
        this.exp = exp;
        this.weapon_storage= new  ArrayList<Item_Weapon> ();
        this.armor_storage= new ArrayList<Item_Armor>();
        this.potion_storage= new ArrayList<Item_Potion>();
        this.spell_storage=new ArrayList<Item_Spell>();
	}
	
	public void setHeroType(String str) {
		this.heroType = str;
	}
	public String getHeroType() {
		return this.heroType;
	}
	public String getName() {
		return name;
	}
	//getters of hero
	public int getMana() {
		return this.mana;
	}
	public int getHp() {
		return hp;
	}
	public int getStre() {
		return this.strength;
	}
	public int getAgi() {
		return this.agility;
	}
	public int getDex() {
		return this.dexterity;
	}
	public int getExp() {
		return this.exp;
	}
	public int getMoney() {
		return this.money;
	}
	
	public int getStreWithBoost() {
		return this.strength+ this.cellStre;
	}
	public int getAgilWithBoost() {
		return this.agility+ this.cellAgi;
	}
	public int getDexWithBoost() {
		return this.dexterity+ this.cellDex;
	}

	public void addMana(int x) {
		mana += x;
	}
	public void addHp(int x) {
		hp += x;
	}
	public void addStre(int x) {
		strength += x;
	}
	public void addAgi(int x) {
		agility += x;
	}
	public void addDex(int x) {
		dexterity += x;
	}
	public void addExp(int x) {
		exp += x;
	}
	
	public void addMoney(int m) {
		this.money +=m;
		if(m>0) {
			System.out.println(name+" gains "+m+" amount money!");
		}else {
			System.out.println(name+" loses "+-m+" amount money!");
		}
	}
	
	public boolean checkLvUp() {
		if(exp>=(level*10)) {
			return true;
		}else{
			return false;
		}
	}
	public void levelUp() {
		if(level!=10) {
			level++;
			hp = level*100;
			mana = (int)(mana*1.1);
			System.out.println("LEVEL UP!");
			System.out.println(name+" has leveled up to Lv: " +level);
		}else {
			hp = (int) (hp*1.5);
			mana = (int)(mana*1.5);
		}
	}
	
	//add items to storage
	public void addWeapon(Item_Weapon weapon) {
		weapon_storage.add(weapon);
	}
	public void addArmor(Item_Armor armor) {
		armor_storage.add(armor);
	}
	public void addPotion(Item_Potion potion) {
		potion_storage.add(potion);
	}
	public void addSpell(Item_Spell spell) {
		spell_storage.add(spell);
	}
	
	//getters for item storages
	public ArrayList<Item_Weapon> getWeaponStore() {
		return weapon_storage;
	}
	public ArrayList<Item_Armor> getArmorStore() {
		return armor_storage;
	}
	public ArrayList<Item_Potion> getPotionStore() {
		return potion_storage;
	}
	public ArrayList<Item_Spell> getSpellStore() {
		return spell_storage;
	}
	
    public String space(String str, int num) {
		while(str.length() < num) {
			str += " ";
		}
		return str;
	}
    
    //print item storages
	public void printWeaponStora() {
		Item_Weapon item;
    	String name, price, lv, dmg, handNum;
    	System.out.println("\nAvailable Weapons:");
		System.out.println(">>>>>>>>>>>>>>>>>>>>");
    	System.out.println("Weapon Name"+ "			" + "Cost"+ "		 "+"Level Required"+ "		      "+ "Damage" + "		"+ "Required Hand Number");
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
    	for(int i = 0; i<weapon_storage.size(); i++) {
        	item = weapon_storage.get(i);
        	name = item.getItemName();
        	name = space(name,17);
        	price = Integer.toString(item.getPrice());
        	price = space(price,10);
        	lv = Integer.toString(item.getLevelReq());
        	lv = space(lv,10);
        	dmg = Integer.toString(item.getDmg());
        	dmg = space(dmg,10);
        	handNum = Integer.toString(item.getHandsReq());
        	handNum = space(handNum,10);
        	System.out.println(i+")"+name + "		"+price+"		"+lv+"		"+dmg+"		"+handNum);
        }
	}
	
    public void printArmorStora() {
    	Item_Armor item;
    	String name, price, lv, dmg;
    	System.out.println("\nAvailable Armors:");
		System.out.println(">>>>>>>>>>>>>>>>>>>>");
    	System.out.println("Armor Name"+ "			" + "Cost"+ "		 "+"Level Required"+ "		  "+ "Damage Reduction");
        System.out.println("-----------------------------------------------------------------------------------------------------------");
    	for(int i = 0; i<armor_storage.size(); i++) {
        	item = armor_storage.get(i);
        	name = item.getItemName();
        	name = space(name,17);
        	price = Integer.toString(item.getPrice());
        	price = space(price,10);
        	lv = Integer.toString(item.getLevelReq());
        	lv = space(lv,10);
        	dmg = Integer.toString(item.getDmgRed());
        	dmg = space(dmg,10);
        	System.out.println(i+")"+name + "		"+price+"		"+lv+"		"+dmg);
        }
    }
    
    public void printPotionStora() {
    	Item_Potion item;
    	String name, price, lv, hp, mana, stre, dex, agi;
    	System.out.println("\nAvailable Potions:");
		System.out.println(">>>>>>>>>>>>>>>>>>>>");
    	System.out.println("Potion Name"+ "			" + "Cost"+ "		"+"Level Required"+ "		"+ "Health Increased"+"	   "+"Mana Increased"+"	   "+"Strength Increased"+"	   "+"Dexterity Increased"+"	   "+"Agility Increased");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    	for(int i = 0; i<potion_storage.size(); i++) {
        	item = potion_storage.get(i);
        	name = item.getItemName();
        	name = space(name,17);
        	price = Integer.toString(item.getPrice());
        	price = space(price,10);
        	lv = Integer.toString(item.getLevelReq());
        	lv = space(lv,10);
        	hp = Integer.toString(item.getHp());
        	hp = space(hp,10);
        	mana = Integer.toString(item.getMana());
        	mana = space(mana,10);
        	stre = Integer.toString(item.getStr());
        	stre = space(stre,10);
        	dex = Integer.toString(item.getDex());
        	dex = space(dex,10);
        	agi = Integer.toString(item.getAgi());
        	agi = space(agi,10);
        	System.out.println(i+")"+name + "		"+price+"		"+lv+"		"+hp+"		"+mana+"		"+stre+"		"+dex+"		"+agi);
        }
    }
    
    public void printSpellStora() {
    	Item_Spell item;
    	String name, price, lv, dmg, manaC, type;
    	System.out.println("\nAvailable Spells:");
		System.out.println(">>>>>>>>>>>>>>>>>>>>");
    	System.out.println("Spell Name"+ "			" + "Cost"+ "		"+"Level Required"+ "		      "+ "Damage"+ "		    "+ "Mana Cost"+"		      "+"Spell Type");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
    	for(int i = 0; i<spell_storage.size(); i++) {
        	item = spell_storage.get(i);
        	name = item.getItemName();
        	name = space(name,17);
        	price = Integer.toString(item.getPrice());
        	price = space(price,10);
        	lv = Integer.toString(item.getLevelReq());
        	lv = space(lv,10);
        	dmg = Integer.toString(item.getDmg());
        	dmg = space(dmg,10);
        	manaC = Integer.toString(item.getManaC());
        	manaC = space(manaC,10);
        	type = item.getSpellType();
        	type = space(type,10);
        	System.out.println(i+")"+name + "		"+price+"		"+lv+"		"+dmg+"		"+manaC+"		"+type);
        }
    }
    
	private int isInt() {
		while(!in.hasNextInt()) {
			System.out.print("Invalid input! Please enter a number: ");
			in.nextLine();
		}
		int n = in.nextInt();
		return n;
	}
	
	//hero equip items
	public void equipWeapon() {
		if(weapon_storage.size()==0) {
			System.out.println("Sorry! "+name+"does not have enough weapon to equip! Please buy in Market!");
		}else {
			printWeaponStora();
			System.out.print("Enter number of the weapon to use (0 - "+ (weapon_storage.size()-1) +"): ");
			in.nextLine();
	        int num = isInt();
	        while (num < 0 || num> (weapon_storage.size()-1) ) {
	            System.out.println("Invalid input! ");
				System.out.print("Enter number of the weapon to use (0 - "+ (weapon_storage.size()-1) +"): ");
	            in.nextLine();
	            num = isInt();
	        }
	        Item_Weapon w = weapon_storage.get(num);
	        if(curWeapon == null) {
				curWeapon = w;
				weapon_storage.remove(w);
				System.out.println("Weapon "+w.getItemName()+" has been equiped to "+name+"!");
			}else {
				unequipWeapon();
				curWeapon = w;
				weapon_storage.remove(w);
				System.out.println("Weapon "+w.getItemName()+" has been equiped to "+name+"!");
			}
		}
	}
	
	
	public void equipArmor() {
		if(armor_storage.size()==0) {
			System.out.println("Sorry! "+name+"does not have enough armor to equip! Please buy in Market!");
		}else {
			printArmorStora();
			System.out.print("Enter number of the armor to use (0 - "+ (armor_storage.size()-1) +"): ");
			in.nextLine();
	        int num = isInt();
	        while (num < 0 || num> (armor_storage.size()-1) ) {
	            System.out.println("Invalid input! ");
				System.out.print("Enter number of the armor to use (0 - "+ (armor_storage.size()-1) +"): ");
	            in.nextLine();
	            num = isInt();
	        }
	        Item_Armor w = armor_storage.get(num);
	        if(curArmor == null) {
				curArmor = w;
				armor_storage.remove(w);
				System.out.println("Armor "+w.getItemName()+" has been equiped to "+name+"!");
			}else {
				unequipArmor();
				curArmor = w;
				armor_storage.remove(w);
				System.out.println("Armor "+w.getItemName()+" has been equiped to "+name+"!");
			}
		}
	}
	
	public void equipSpell() {
		if(spell_storage.size()==0) {
			System.out.println("Sorry! "+name+"does not have enough spell to equip! Please buy in Market!");
		}else {
			printSpellStora();
			System.out.print("Enter number of the spell to use (0 - "+ (spell_storage.size()-1) +"): ");
			in.nextLine();
	        int num = isInt();
	        while (num < 0 || num> (spell_storage.size()-1) ) {
	            System.out.println("Invalid input! ");
				System.out.print("Enter number of the spell to use (0 - "+ (spell_storage.size()-1) +"): ");
	            in.nextLine();
	            num = isInt();
	        }
	        Item_Spell w = spell_storage.get(num);
			if(curSpell == null) {
				curSpell = w;
				spell_storage.remove(w);
				System.out.println("Spell "+w.getItemName()+" has been equiped to "+name+"!");
			}else {
				unequipSpell();
				curSpell = w;
				spell_storage.remove(w);
				System.out.println("Spell "+w.getItemName()+" has been equiped to "+name+"!");
			}   
		}
	}
	
	public void usePotion(Item_Potion p) {
		potion_storage.remove(p);
		strength += p.getStr();
		agility += p.getAgi();
		dexterity += p.getDex();
	}
	
	//hero unequip items
	public void unequipWeapon() {
		if(curWeapon == null) {
			System.out.println(name+" is not holding weapon now! Cannot unequip!");
		}else {
			weapon_storage.add(curWeapon);
			System.out.println(curWeapon.getItemName()+" has been unequiped from "+name+"!");
			curWeapon = null;
		}
	}
	public void unequipArmor() {
		if(curArmor == null) {
			System.out.println(name+" is not holding armor now! Cannot unequip!");
		}else {
			armor_storage.add(curArmor);
			System.out.println(curArmor.getItemName()+" has been unequiped from "+name+"!");
			curArmor = null;
		}
	}
	public void unequipSpell() {
		if(curSpell == null) {
			System.out.println(name+" is not holding armor now! Cannot unequip!");
		}else {
			spell_storage.add(curSpell);
			System.out.println(curSpell.getItemName()+" has been unequiped from "+name+"!");
			curSpell = null;
		}
	}

	//Hero sell items
	public void sellWeapon() {
		System.out.println("Weapon Storage: ");
		if(weapon_storage.size()==0) {
			System.out.println("Empty storage!");
			return;
		}else {
			for(int i = 0; i<weapon_storage.size();i++) {
				System.out.println(i+")"+weapon_storage.get(i)+"\tPrice: "+weapon_storage.get(i).getPrice()+"\tRequired Level: "+weapon_storage.get(i).getLevelReq());
			}
			System.out.print("Enter the number of weapon to sell (0 - "+ (weapon_storage.size()-1)+"): ");
	    	int w = in.nextInt();
	    	while(w <0||w>weapon_storage.size()-1) {
	    		System.out.println("Invalid input!");
	    		System.out.print("Enter number of the weapon to sell (0 - "+ (weapon_storage.size()-1) +"): ");
	        	w = in.nextInt();
	    	}
	    	Item_Weapon weapon = weapon_storage.get(w);
	    	if(weapon == curWeapon) {
	    		unequipWeapon();
	    	}
	    	weapon_storage.remove(w);
	    	int p = weapon.getPrice()/2;
	    	money += p;
	    	System.out.println(name+ " sold "+weapon.getItemName()+" for "+p+"!");
	    	System.out.println("Money remain: "+ money);
		}
		
	}
	
	public void sellArmor() {
		System.out.println("Armor Storage: ");
		if(armor_storage.size()==0) {
			System.out.println("Empty storage!");
			return;
		}else {
			for(int i = 0; i<armor_storage.size();i++) {
				System.out.println(i+")"+armor_storage.get(i)+"\tPrice: "+armor_storage.get(i).getPrice()+"\tRequired Level: "+armor_storage.get(i).getLevelReq());
			}
			System.out.print("Enter the number of Armor to sell (0 - "+ (armor_storage.size()-1)+"): ");
	    	int w = in.nextInt();
	    	while(w <0||w>armor_storage.size()-1) {
	    		System.out.println("Invalid input!");
	    		System.out.print("Enter number of the Armor to sell (0 - "+ (armor_storage.size()-1) +"): ");
	        	w = in.nextInt();
	    	}
	    	Item_Armor armor = armor_storage.get(w);
	    	if(armor == curArmor) {
	    		unequipArmor();
	    	}
	    	armor_storage.remove(w);
	    	int p = armor.getPrice()/2;
	    	money += p;
	    	System.out.println(name+ " sold "+armor.getItemName()+" for "+p+"!");
	    	System.out.println("Money remain: "+ money);
		}
	}
	
	public void sellPotion() {
		System.out.println("Potion Storage: ");
		if(potion_storage.size()==0) {
			System.out.println("Empty storage!");
		}else {
			for(int i = 0; i<potion_storage.size();i++) {
				System.out.println(i+")"+potion_storage.get(i)+"\tPrice: "+potion_storage.get(i).getPrice()+"\tRequired Level: "+potion_storage.get(i).getLevelReq());
			}
			System.out.print("Enter the number of Potion to sell (0 - "+ (potion_storage.size()-1)+"): ");
	    	int w = in.nextInt();
	    	while(w <0||w>potion_storage.size()-1) {
	    		System.out.println("Invalid input!");
	    		System.out.print("Enter number of the Potion to sell (0 - "+ (potion_storage.size()-1) +"): ");
	        	w = in.nextInt();
	    	}
	    	Item_Potion potion = potion_storage.get(w);
	    	potion_storage.remove(w);
	    	int p = potion.getPrice()/2;
	    	money += p;
	    	System.out.println(name+ " sold "+potion.getItemName()+" for "+p+"!");
	    	System.out.println("Money remain: "+ money);
		}
	}
	public void sellSpell() {
		System.out.println("Spell Storage: ");
		if(spell_storage.size()==0) {
			System.out.println("Empty storage!");
		}else {
			for(int i = 0; i<spell_storage.size();i++) {
				System.out.println(i+")"+spell_storage.get(i)+"\tPrice: "+spell_storage.get(i).getPrice()+"\tRequired Level: "+spell_storage.get(i).getLevelReq());
			}
			System.out.print("Enter the number of Spell to sell (0 - "+ (spell_storage.size()-1)+"): ");
	    	int w = in.nextInt();
	    	while(w <0||w>spell_storage.size()-1) {
	    		System.out.println("Invalid input!");
	    		System.out.print("Enter number of the Spell to sell (0 - "+ (spell_storage.size()-1) +"): ");
	        	w = in.nextInt();
	    	}
	    	Item_Spell spell = spell_storage.get(w);
	    	spell_storage.remove(w);
	    	int p = spell.getPrice()/2;
	    	money += p;
	    	System.out.println(name+ " sold "+spell.getItemName()+" for "+p+"!");
	    	System.out.println("Money remain: "+ money);
		}
	}
	
	public void attack(Monster m) {
		System.out.println(name+" is attacking "+ m.getName());
		int totalDmg;
		if(curWeapon == null) {
			totalDmg = (int) (strength*0.05);
		}else {
			totalDmg = (int) ((strength+curWeapon.getDmg())*0.05);
		}
		m.takenDmg(totalDmg);
	}
	
	public void magicAttack(Monster m) {
		int totalDmg;
		if(curSpell == null) {
			System.out.println(name+" have no spell! Change to regular attack!");
			attack(m);
		}else {
			System.out.println(name+" is casting "+curSpell.getItemName()+" to "+ m);
			totalDmg = curSpell.getDmg() + (dexterity/10000)*(curSpell.getDmg());
			m.takenMagic(totalDmg, curSpell);
		}
	}
	
	public void takenDmg(int dmg) {
		int random  = new Random().nextInt(100);
		if((agility*0.02)>random) {
			System.out.println(name+" dodged monster's attack!");
		}else {
			if(curArmor != null) {
				dmg -= curArmor.getDmgRed();
			}
			if(dmg>0) {
				hp = hp-dmg;
				if(hp > 0) {
					System.out.println(name+" taken damage:" +dmg+", hp left: "+ hp);
				}else {
					hp = 0;
					System.out.println(name+" taken damage:" +dmg+", hp left: "+ hp+"! "+name+" defeated!");
				}
			}else {
				System.out.println(name+" defensed monster's attack!");
			}
		}	
	}
}
