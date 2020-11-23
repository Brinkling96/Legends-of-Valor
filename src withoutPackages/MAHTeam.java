package src;

import java.util.ArrayList;

public class MAHTeam {

	//the class represents the team of heroes chosen by player
	private ArrayList<Hero> party;
	private char cellType;
	private int row;
	private int col;
	
	public MAHTeam(ArrayList<Hero> party, char cellType) {
		this.party = party;
		this.cellType = cellType;
	}
	
	public void addTeamMemb(Hero h) {
		party.add(h);
	}
	public Hero getTeamMemb(int i) {
		return party.get(i);
	}
	public ArrayList<Hero> getParty(){
		return party;
	}
	public boolean hasRepeatMem(String s) {
		for(int i = 0; i< party.size(); i++) {
			Hero h = party.get(i);
			if(h.name.equals(s)) {
				System.out.println("You have already selected this hero, please select another one!");
				return true;
			}
		}
		return false;
	}

	public int getRow() {
		return row;
	}
	public int getCol() {
		return col;
	}
	public void setPosition(int r, int c) {
		this.row = r;
		this.col = c;
	}
	public char getTeamCell() {
		return cellType;
	}
	
	public int getMaxLv() {
        int lv = 0;
        for(int i = 0; i < party.size(); i++){
            Hero h = party.get(i);
            if(h.getLv()>lv){
                lv = h.getLv();
            }
        }
        return lv;
	}
	
	
	public String space(String str, int num) {
		while(str.length() < num) {
			str += " ";
		}
		return str;
	}
	
	public void printTeam() {
		Hero hero;
		String name, mana, hp, stre, agi, dex, exp, lv;
		System.out.print("\n");
		System.out.println("Your team members: ");
		System.out.println(">>>>>>>>>>>>>>>>>>>>");
		System.out.print("\n");
		System.out.println("Name"+ "                        " + "Magic Power"+ "		   "+"Health Power"+ "              "+ "Strength" + "                "+ "Agility"+ "                 "+"Dexterity"+ "              "+ "Experience"+"              "+ "Level");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for(int i = 0; i< party.size(); i++) {
        	hero = party.get(i);
        	name = hero.getName();
        	name = space(name,20);
        	mana = Integer.toString(hero.getMana());
        	mana = space(mana,16);
        	hp = Integer.toString(hero.getHp());
        	hp = space(hp,10);
        	stre = Integer.toString(hero.getStre());
        	stre = space(stre,10);
        	agi = Integer.toString(hero.getAgi());
        	agi = space(agi,10);
        	dex = Integer.toString(hero.getDex());
        	dex = space(dex,10);
        	exp = Integer.toString(hero.getExp());
        	exp = space(exp,10);
        	lv = Integer.toString(hero.getLv());
        	lv = space(lv,10);
        	System.out.println(i+")"+name + "		"+mana+"	"+hp+"		"+stre+"		"+agi+"		"+dex+"		"+exp+"		"+lv);
        }
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	}
	
	public void printMoney() {
		Hero hero;
		String name, money, lv;
		System.out.print("\n");
		System.out.println("Your team members: ");
		System.out.println(">>>>>>>>>>>>>>>>>>>>");
		System.out.print("\n");
		System.out.println("Name"+ "                        	" + "Money"+"              	"+ "Level");
		System.out.println("------------------------------------------------------------------------------------------");
        for(int i = 0; i< party.size(); i++) {
        	hero = party.get(i);
        	name = hero.getName();
        	name = space(name,20);
        	money = Integer.toString(hero.getMoney());
        	money = space(money,10);
        	lv = Integer.toString(hero.getLv());
        	lv = space(lv,10);
        	System.out.println(i+")"+name + "		"+money+"		"+lv);
        }
		System.out.println("------------------------------------------------------------------------------------------");	
	}
	
	public void printStorage() {
		for(int i = 0; i< party.size(); i++) {
			Hero h = party.get(i);
			System.out.println(h.getName()+":");
			h.printArmorStora();
			h.printPotionStora();
			h.printSpellStora();
			h.printWeaponStora();
		}
	}
	
	
	
}
