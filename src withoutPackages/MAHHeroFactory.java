package src;

import java.util.ArrayList;
import java.util.Scanner;

public class MAHHeroFactory implements HeroFactory{

	//the class initializes all Monster and Heroes game heroes 
	private ArrayList<Hero> allHeroes;
	private Scanner in;
	
	public MAHHeroFactory(Scanner in) {
		allHeroes = new ArrayList<Hero>();
		this.in = in;
        iniWarrior();
        iniSorcrer();
        iniPaladin();
    }

	@Override
	public ArrayList<Hero> createParty() {
		ArrayList<Hero> party = new ArrayList<Hero>();
		promptHeroChoose(party);
		int i = 0;
		for(Hero hero: party){
			hero.setMarker(Integer.toString(++i).charAt(0));
		}
		return party;
	}

	private int isInt() {
		while(!in.hasNextInt()) {
			System.out.print("Invalid input! Please enter a number: ");
			in.nextLine();
		}
		int n = in.nextInt();
		return n;
	}

	protected int promptHeroCount() {
		System.out.print("Please enter the number of heroes (1-3): ");
		in.nextLine();
		int heroCount = isInt();
		while (heroCount < 1|| heroCount>3) {
			System.out.println("Invalid input! Please enter a number of heroes (1-3): ");
			in.nextLine();
			heroCount = isInt();
		}
		return heroCount;

	}

	protected void promptHeroChoose(ArrayList<Hero> party) {
		//HeroFactory allHeroes = new HeroFactory();
		printHeroes();
		System.out.println();
		Patterns.printHint();

		int heroCount = promptHeroCount();
		for(int i = 1; i<=heroCount; i++) {
			System.out.print("Please enter a number to choose your hero No."+i+" (0 - "+ (allHeroes.size()-1) +"): ");
			in.nextLine();
			int c = isInt();
			while(c<0||c>(allHeroes.size()-1)) {
				System.out.println("Invalid number!");
				System.out.print("Please enter a number to choose your hero No. "+i+" (0 - "+ (allHeroes.size()-1) +"): ");
				in.nextLine();
				c = isInt();
			}
			Hero h = allHeroes.get(c);
			if(party.contains(h)){
				i--;
				System.out.println(h.getName()+" is already on the team!");
			}
			else {
				party.add(h);
				System.out.println(h.getName() + " join the team!");
			}
		}
	}
	
	public void iniWarrior() {
		Hero_Warriors Gaerdal_Ironhand = new Hero_Warriors("Gaerdal_Ironhand", 100, 700, 500, 600, 1354, 7);
		Hero_Warriors Sehanine_Monnbow = new Hero_Warriors("Sehanine_Monnbow", 600, 700, 800, 500, 2500, 8);
		Hero_Warriors Muamman_Duathall = new Hero_Warriors("Muamman_Duathall", 300, 900, 500, 750, 2546, 6);
		Hero_Warriors Flandal_Steelskin = new Hero_Warriors("Flandal_Steelskin", 200, 750, 650, 700, 2500, 7);
		Hero_Warriors Undefeated_Yoj = new Hero_Warriors("Undefeated_Yoj", 400, 800, 400, 700, 2500, 7);
		Hero_Warriors Eunoia_Cyn = new Hero_Warriors("Eunoia_Cyn", 400, 700, 800, 600, 2500, 6);
		allHeroes.add(Gaerdal_Ironhand);
		allHeroes.add(Sehanine_Monnbow);
		allHeroes.add(Muamman_Duathall);
		allHeroes.add(Flandal_Steelskin);
		allHeroes.add(Undefeated_Yoj);
		allHeroes.add(Eunoia_Cyn);

	}
	
	public void iniSorcrer() {
		Hero_Sorcerers Rillifane_Rallathil = new Hero_Sorcerers("Rillifane_Rallathil", 1300, 750, 450, 500, 2500, 9);
		Hero_Sorcerers Segojan_Earthcaller = new Hero_Sorcerers("Segojan_Earthcaller", 900, 800, 500, 650, 2500, 5);
		Hero_Sorcerers Reign_Havoc = new Hero_Sorcerers("Reign_Havoc", 800, 800, 800, 800, 2500, 8);
		Hero_Sorcerers Reverie_Ashels = new Hero_Sorcerers("Reverie_Ashels", 900, 800, 700, 400, 2500, 7);
		Hero_Sorcerers Radiant_Ash = new Hero_Sorcerers("Radiant_Ash", 800, 850, 400, 600, 2500, 6);
		Hero_Sorcerers Skye_Soar = new Hero_Sorcerers("Skye_Soar", 1000, 700, 400, 500, 2500, 5);
		allHeroes.add(Rillifane_Rallathil);
		allHeroes.add(Segojan_Earthcaller);
		allHeroes.add(Reign_Havoc);
		allHeroes.add(Reverie_Ashels);
		allHeroes.add(Radiant_Ash);
		allHeroes.add(Skye_Soar);

	}
	
	public void iniPaladin() {
		Hero_Paladins Solonor_Thelandira = new Hero_Paladins("Solonor_Thelandira", 300, 750, 650, 700, 2500, 7);
		Hero_Paladins Sehanine_Moonbow = new Hero_Paladins("Sehanine_Moonbow", 300, 750, 700, 700, 2500, 7);
		Hero_Paladins Skoraeus_Stonebones = new Hero_Paladins("Skoraeus_Stonebones", 250, 650, 600, 350, 2500, 4);
		Hero_Paladins Garl_Glittergold = new Hero_Paladins("Garl_Glittergold", 100, 600, 500, 400, 2500, 5);
		Hero_Paladins Amaryllis_Astra = new Hero_Paladins("Amaryllis_Astra", 500, 500, 500, 500, 2500, 5);
		Hero_Paladins Caliber_Heist = new Hero_Paladins("Caliber_Heist", 400, 400, 400, 400, 2500, 8);
		allHeroes.add(Solonor_Thelandira);
		allHeroes.add(Sehanine_Moonbow);
		allHeroes.add(Skoraeus_Stonebones);
		allHeroes.add(Garl_Glittergold);
		allHeroes.add(Amaryllis_Astra);
		allHeroes.add(Caliber_Heist);
	}
	
	public String space(String str, int num) {
		while(str.length() < num) {
			str += " ";
		}
		return str;
	}
	
	
	public void printHeroes() {
		Hero hero;
		String name, mana, hp, stre, agi, dex, exp;
        for(int i = 0; i<allHeroes.size(); i++) {
        	hero = allHeroes.get(i);
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
        	
        	if(i == 0 || i == 6 || i == 12) {
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        		System.out.print("\n");
        		System.out.println("Available "+hero.getHeroType()+" :");
        		System.out.println(">>>>>>>>>>>>>>>>>>>>");
        		System.out.print("\n");
        		System.out.println("Name"+ "                        " + "Magic Power"+ "		   "+"Health Power"+ "              "+ "Strength" + "                "+ "Agility"+ "                 "+"Dexterity"+ "              "+ "Experience");
                System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        	}

        	System.out.println(i+")"+name + "		"+mana+"	"+hp+"		"+stre+"		"+agi+"		"+dex+"		"+exp);
        }
		
	}
	
	public void recoverRound(ArrayList<Hero> hero) {
		for(int i = 0; i<hero.size(); i++) {
			Hero h = hero.get(i);
			h.addHp((int) (0.1*h.getHp()));
			h.addMana((int) (0.1*h.getMana()));
		}
	}

	public void bonusCoin(ArrayList<Hero> hero) {
		for(int i = 0; i<hero.size(); i++) {
			Hero h = hero.get(i);
			h.addMoney(100*h.getLv());
			h.addExp(2);
		}
	}
	public void Revive(ArrayList<Hero> deadHero) {
		for(int i = 0; i< deadHero.size();i++) {
			Hero h = deadHero.get(i);
			h.addHp((h.getLv()*100)/2);
		}
	}
	
	public void LEVELUP(ArrayList<Hero> heroes) {
		for(int i = 0; i < heroes.size(); i++){
			Hero h = heroes.get(i);
			if(h.getExp() >= ((h.getLv())*10) ) {
				if (heroes.get(i) instanceof Hero_Paladins) {
	            	Hero_Paladins sub = (Hero_Paladins) heroes.get(i);
	            	sub.levelUp();
	            }
	            else if (heroes.get(i) instanceof Hero_Sorcerers) {
	            	Hero_Sorcerers sub= (Hero_Sorcerers) heroes.get(i);
	            	sub.levelUp();
	            }
	            else if (heroes.get(i) instanceof Hero_Warriors) {
	            	Hero_Warriors sub= (Hero_Warriors) heroes.get(i);
	            	sub.levelUp();
	            }
			}
        }
	}

	
}
