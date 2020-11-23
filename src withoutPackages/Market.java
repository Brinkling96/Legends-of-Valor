package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Market {
	//the class initializes all items

	private static Market uniqueMarket;
	
	Scanner in = new Scanner(System.in);
    private ArrayList<Item_Weapon> weaponFactory;
    private ArrayList<Item_Armor> armorFactory;
    private ArrayList<Item_Potion> potionFactory;
    private ArrayList<Item_Spell> spellFactory;

    public static Market getInstance(){
    	if (uniqueMarket == null){
    		uniqueMarket = new Market();
		}
    	return uniqueMarket;
	}
    private Market() {
    	weaponFactory = new ArrayList<Item_Weapon>();
        armorFactory = new ArrayList<Item_Armor>();
        potionFactory = new ArrayList<Item_Potion>();
        spellFactory = new ArrayList<Item_Spell>();
        iniWeapon();
        iniArmor();
        iniPotion();
        iniSpell();
    }
    
    //initialize items in market
    public void iniWeapon() {
    	Item_Weapon item;
    	try {
			File file = new File("src/Legends_Monster_Hero/Weaponry.txt"); 
			BufferedReader br = new BufferedReader(new FileReader(file)); 
			String str;
			String attr[];
			br.readLine();
			str = br.readLine();
			do{
				if (str == null)
					break;
				attr = str.split("\\s+");
				item = new Item_Weapon(attr[0], Integer.parseInt(attr[1]), Integer.parseInt(attr[2]), Integer.parseInt(attr[3]), Integer.parseInt(attr[4]));
				weaponFactory.add(item);
			}while((str = br.readLine()) != null);
		}catch (IOException e){
			e.printStackTrace();
		}
    }
    
    public void iniArmor(){
    	Item_Armor item;
    	try {
			File file = new File("src/Legends_Monster_Hero/Armory.txt"); 
			BufferedReader br = new BufferedReader(new FileReader(file)); 
			String str;
			String attr[];
			br.readLine();
			str = br.readLine();
			do{
				if (str == null)
					break;
				attr = str.split("\\s+");
				item = new Item_Armor(attr[0], Integer.parseInt(attr[1]), Integer.parseInt(attr[2]), Integer.parseInt(attr[3]));
				armorFactory.add(item);
			}while((str = br.readLine()) != null);
		}catch (IOException e){
			e.printStackTrace();
		}
    }
    
    public void iniPotion(){
    	Item_Potion Healing_potion = new Item_Potion("Healing_Potion", 250, 1, 100, 0, 0, 0, 0);
    	Item_Potion Strength_potion = new Item_Potion("Strength_Potion", 200, 1, 0, 0, 0, 75, 0);
    	Item_Potion Magic_potion =  new Item_Potion("Magic_Potion", 350, 2, 0, 100, 0, 0, 0);
    	Item_Potion Luck_Exlixir = new Item_Potion ("Luck_Exlixir", 500, 4, 0, 0, 0, 0, 65);
    	Item_Potion Mermaid_Tears = new Item_Potion("Mermaid_Tears", 850, 5, 100, 100, 0, 100, 100);
    	Item_Potion Ambrosia = new Item_Potion("Ambrosia", 1000, 8, 150, 150, 150, 150, 150);
    	potionFactory.add(Healing_potion);
    	potionFactory.add(Strength_potion);
    	potionFactory.add(Magic_potion);
    	potionFactory.add(Luck_Exlixir);
    	potionFactory.add(Mermaid_Tears);
    	potionFactory.add(Ambrosia);        
    }
    
    public void iniSpell() {
    	Item_Spell item;
    	try {
			File file = new File("src/Legends_Monster_Hero/FireSpells.txt"); 
			BufferedReader br = new BufferedReader(new FileReader(file)); 
			String str;
			String attr[];
			br.readLine();
			str = br.readLine();
			do{
				if (str == null)
					break;
				attr = str.split("\\s+");
				item = new Item_Spell(attr[0], Integer.parseInt(attr[1]), Integer.parseInt(attr[2]), Integer.parseInt(attr[3]),Integer.parseInt(attr[4]), "fire");
				spellFactory.add(item);
			}while((str = br.readLine()) != null);
			
			
			file = new File("src/Legends_Monster_Hero/IceSpells.txt"); 
			br = new BufferedReader(new FileReader(file)); 
			br.readLine();
			str = br.readLine();
			do{
				if (str == null)
					break;
				attr = str.split("\\s+");
				item = new Item_Spell(attr[0], Integer.parseInt(attr[1]), Integer.parseInt(attr[2]), Integer.parseInt(attr[3]),Integer.parseInt(attr[4]), "ice");
				spellFactory.add(item);
			}while((str = br.readLine()) != null);
			
			
			file = new File("src/Legends_Monster_Hero/LightningSpells.txt"); 
			br = new BufferedReader(new FileReader(file)); 
			br.readLine();
			str = br.readLine();
			do{
				if (str == null)
					break;
				attr = str.split("\\s+");
				item = new Item_Spell(attr[0], Integer.parseInt(attr[1]), Integer.parseInt(attr[2]), Integer.parseInt(attr[3]),Integer.parseInt(attr[4]), "lightning");
				spellFactory.add(item);
			}while((str = br.readLine()) != null);

		}catch (IOException e){
			e.printStackTrace();
		}
    }
    
    //Print items
    public String space(String str, int num) {
		while(str.length() < num) {
			str += " ";
		}
		return str;
	}
    
    public void printWeapon() {
    	Item_Weapon item;
    	String name, price, lv, dmg, handNum;
    	System.out.println("\nAvailable Weapons:");
		System.out.println(">>>>>>>>>>>>>>>>>>>>");
    	System.out.println("Weapon Name"+ "			" + "Cost"+ "		 "+"Level Required"+ "		      "+ "Damage" + "		"+ "Required Hand Number");
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
    	for(int i = 0; i<weaponFactory.size(); i++) {
        	item = weaponFactory.get(i);
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
    
    public void printArmor() {
    	Item_Armor item;
    	String name, price, lv, dmg;
    	System.out.println("\nAvailable Armors:");
		System.out.println(">>>>>>>>>>>>>>>>>>>>");
    	System.out.println("Armor Name"+ "			" + "Cost"+ "		 "+"Level Required"+ "		  "+ "Damage Reduction");
        System.out.println("-----------------------------------------------------------------------------------------------------------");
    	for(int i = 0; i<armorFactory.size(); i++) {
        	item = armorFactory.get(i);
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
    
    public void printPotion() {
    	Item_Potion item;
    	String name, price, lv, hp, mana, stre, dex, agi;
    	System.out.println("\nAvailable Potions:");
		System.out.println(">>>>>>>>>>>>>>>>>>>>");
    	System.out.println("Potion Name"+ "			" + "Cost"+ "		"+"Level Required"+ "		"+ "Health Increased"+"	   "+"Mana Increased"+"	   "+"Strength Increased"+"	   "+"Dexterity Increased"+"	   "+"Agility Increased");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    	for(int i = 0; i<potionFactory.size(); i++) {
        	item = potionFactory.get(i);
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
    
    public void printSpell() {
    	Item_Spell item;
    	String name, price, lv, dmg, manaC, type;
    	System.out.println("\nAvailable Spells:");
		System.out.println(">>>>>>>>>>>>>>>>>>>>");
    	System.out.println("Spell Name"+ "			" + "Cost"+ "		"+"Level Required"+ "		      "+ "Damage"+ "		    "+ "Mana Cost"+"		      "+"Spell Type");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
    	for(int i = 0; i<spellFactory.size(); i++) {
        	item = spellFactory.get(i);
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
    
    //Hero visit market
    public void visitMarket(Hero hero) {
    	do {
    		System.out.println("You can buy and sell items in the market!");
        	System.out.print("Choose:			[B]buy		[S]sell		[L]Leave market: ");
        	String str = in.next();
    		if (str.charAt(0) == 'B' || str.charAt(0) == 'b'){
    			buyMenu(hero);
    		}else if (str.charAt(0) == 'S' || str.charAt(0) == 's'){
    			sellMenu(hero);
    		}else if (str.charAt(0) == 'L' || str.charAt(0) == 'l'){
    			System.out.println();
    			System.out.println("-----------------------------------------------------------------------------------------");
    			System.out.println("----------------------------Thank you for visiting! BYE!---------------------------------");
    			System.out.println("-----------------------------------------------------------------------------------------");
    			return;
    		}else{
    			System.out.println("Invalid input!");
    		}
    	}while(true);
    }
    
    //hero buy items menu
    public void buyMenu(Hero hero) {
    	while(true) {
    		System.out.print("Choose one to buy:	[W]Weapon	[A]Armor	[P]Potion	[S]Spell	[B]Back to Market: ");
        	String str = in.next();
			if (str.charAt(0) == 'W' || str.charAt(0) == 'w'){
				buyWeapon(hero, weaponFactory);
			}else if (str.charAt(0) == 'A' || str.charAt(0) == 'a'){
				buyArmor(hero, armorFactory);
			}else if (str.charAt(0) == 'P' || str.charAt(0) == 'p'){
				buyPotion(hero, potionFactory);
			}else if (str.charAt(0) == 'S' || str.charAt(0) == 's'){
				buySpell(hero, spellFactory);
			}else if (str.charAt(0) == 'B' || str.charAt(0) == 'b'){
				return;
			}else{
				System.out.println("Invalid input!");
			}
    	}
    }
    //hero sell items menu
    public void sellMenu(Hero hero) {
    	while(true) {
    		System.out.println("Hero "+hero.getName() +" will get half of the item price back!");
    		System.out.print("Choose one to sell:	[W]Weapon	[A]Armor	[S]Spell	[B]Back to Market: ");
        	String str = in.next();
			if (str.charAt(0) == 'W' || str.charAt(0) == 'w'){
				hero.sellWeapon();
			}else if (str.charAt(0) == 'A' || str.charAt(0) == 'a'){
				hero.sellArmor();
			}else if (str.charAt(0) == 'P' || str.charAt(0) == 'p'){
				hero.sellPotion();
			}else if (str.charAt(0) == 'S' || str.charAt(0) == 's'){
				hero.sellSpell();
			}else if (str.charAt(0) == 'B' || str.charAt(0) == 'b'){
				return;
			}else{
				System.out.println("Invalid input!");
			}
    	}
    }
    
    //Check whether hero can buy item
    public boolean cantBuy(Hero hero, Item item) {
    	if(item.heroOwn(hero)) {
    		System.out.println(item.getItemName()+" already owned by hero "+hero.getName()+"!");
    		return false;
    	}
    	int lv = hero.getLv();
    	int lvReq = item.getLevelReq();
    	if(lv<lvReq) {
    		System.out.println(hero.getName() + " does not reach level " +lvReq+" to purchase "+item.getItemName()+"!");
    		return false;
    	}
    	if(hero.getMoney()<item.getPrice()) {
    		System.out.println(hero.getName() + " does not have enough money to purchase "+item.getItemName()+"!");
    		return false;
    	}
    	return true;
    }
    
    //hero buy items
    public void buyWeapon(Hero hero, ArrayList<Item_Weapon> item) {
    	printWeapon();
    	System.out.print("Enter number of the weapon to buy (0 - "+ (item.size()-1) +"): ");
    	in.nextLine();
    	int w = isInt();
    	while(w <0||w>item.size()-1) {
    		System.out.println("Invalid input!");
    		System.out.print("Enter number of the weapon to buy (0 - "+ (item.size()-1) +"): ");
    		in.nextLine();
        	w = isInt();
    	}
    	Item_Weapon weapon = item.get(w);
    	if(cantBuy(hero, weapon)) {
    		System.out.println(hero.getName() +" buy "+weapon.getItemName()+"!");
    		hero.addMoney(-weapon.getPrice());
    		item.remove(w);
    		hero.addWeapon(weapon);
    	}
		System.out.println("-----------------------------------------------------------------------------------");
    }

    public void buyArmor(Hero hero, ArrayList<Item_Armor> item) {
    	printArmor();
    	System.out.print("Enter number of the armor to buy (0 - "+ (item.size()-1) +"): ");
    	in.nextLine();
    	int w = isInt();
    	while(w <0||w>item.size()-1) {
    		System.out.println("Invalid input!");
    		System.out.print("Enter number of the weapon to buy (0 - "+ (item.size()-1) +"): ");
    		in.nextLine();
        	w = isInt();
    	}
    	Item_Armor armor = item.get(w);
    	if(cantBuy(hero, armor)) {
    		System.out.println(hero.getName() +" buy "+armor.getItemName()+"!");
    		hero.addMoney(-armor.getPrice());
    		item.remove(w);
    		hero.addArmor(armor);
    	}
		System.out.println("-----------------------------------------------------------------------------------");
    }
    
    public void buyPotion(Hero hero, ArrayList<Item_Potion> item) {
    	printPotion();
    	System.out.print("Enter number of the potion to buy (0 - "+ (item.size()-1) +"): ");
    	in.nextLine();
    	int w = isInt();
    	while(w <0||w>item.size()-1) {
    		System.out.println("Invalid input!");
    		System.out.print("Enter number of the weapon to buy (0 - "+ (item.size()-1) +"): ");
    		in.nextLine();
        	w = isInt();
    	}
    	Item_Potion potion = item.get(w);
    	if(cantBuy(hero, potion)) {
    		System.out.println(hero.getName() +" buy "+potion.getItemName()+"!");
    		hero.addMoney(-potion.getPrice());
    		item.remove(w);
    		hero.addPotion(potion);
    	}
		System.out.println("-----------------------------------------------------------------------------------");
    }

    
    public void buySpell(Hero hero, ArrayList<Item_Spell> item) {
    	printSpell();
    	System.out.print("Enter number of the spell to buy (0 - "+ (item.size()-1) +"): ");
    	in.nextLine();
    	int w = isInt();
    	while(w <0||w>item.size()-1) {
    		System.out.println("Invalid input!");
    		System.out.print("Enter number of the weapon to buy (0 - "+ (item.size()-1) +"): ");
    		in.nextLine();
        	w = isInt();
    	}
    	Item_Spell spell = item.get(w);
    	if(cantBuy(hero, spell)) {
    		System.out.println(hero.getName() +" buy "+spell.getItemName()+"!");
    		hero.addMoney(-spell.getPrice());
    		item.remove(w);
    		hero.addSpell(spell);
    	}
		System.out.println("-----------------------------------------------------------------------------------");
    }

	private int isInt() {
		while(!in.hasNextInt()) {
			System.out.print("Invalid input! Please enter a number: ");
			in.nextLine();
		}
		int n = in.nextInt();
		return n;
	}
    
  
    
}
