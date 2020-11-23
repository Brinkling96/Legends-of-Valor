package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class MonsterFactory {

	//the class initializes all monsters
	private ArrayList<Monster> monsterFactory;

	public MonsterFactory() {
		monsterFactory= new ArrayList<Monster>();
		iniDragon();
        iniExoskeleton();
        iniSpirit();
	}

	public void iniDragon() {
		Monster monster;
		try {
			File file = new File("src/Legends_Monster_Hero/Dragons.txt"); 
			BufferedReader br = new BufferedReader(new FileReader(file)); 
			String str;
			String attr[];
			br.readLine();
			do{
				if ((str = br.readLine()) == null)
					break;
				attr = str.split("\\s+");
				monster = new Monster_Dragons(attr[0], Integer.parseInt(attr[1]), Integer.parseInt(attr[2]), Integer.parseInt(attr[3]), Integer.parseInt(attr[4]));
				monsterFactory.add(monster);
			}while((str = br.readLine()) != null);
		}catch (IOException e){
			e.printStackTrace();
		}
	}


	public void iniExoskeleton() {
		Monster monster;
		try {
			File file = new File("src/Legends_Monster_Hero/Exoskeletons.txt"); 
			BufferedReader br = new BufferedReader(new FileReader(file)); 
			String str;
			String attr[];
			br.readLine();
			do{
				if ((str = br.readLine()) == null)
					break;
				attr = str.split("\\s+");
				monster = new Monster_Dragons(attr[0], Integer.parseInt(attr[1]), Integer.parseInt(attr[2]), Integer.parseInt(attr[3]), Integer.parseInt(attr[4]));
				monsterFactory.add(monster);
			}while((str = br.readLine()) != null);
		}catch (IOException e){
			e.printStackTrace();
		}
	}

	
	public void iniSpirit() {
		Monster monster;
		try {
			File file = new File("src/Legends_Monster_Hero/Spirits.txt"); 
			BufferedReader br = new BufferedReader(new FileReader(file)); 
			String str;
			String attr[];
			br.readLine();
			do{
				if ((str = br.readLine()) == null)
					break;
				attr = str.split("\\s+");
				monster = new Monster_Dragons(attr[0], Integer.parseInt(attr[1]), Integer.parseInt(attr[2]), Integer.parseInt(attr[3]), Integer.parseInt(attr[4]));
				monsterFactory.add(monster);
			}while((str = br.readLine()) != null);
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<Monster> generateMonster(int num, int level) {
		ArrayList<Monster> temp = new ArrayList<Monster>();
		ArrayList<Monster> monsterList = new ArrayList<Monster>();
		Monster monster;
		int i = 0;
		while(i<monsterFactory.size()) {
			monster = monsterFactory.get(i);
			if(monster.getLv()==level) {
				temp.add(monster);
			}
			i++;
		}
		for(int j = 0; j<num; j++) {
			monster = temp.get(new Random().nextInt(temp.size()));
			while(monsterList.contains(monster)) {
				monster = temp.get(new Random().nextInt(temp.size()));
			}
			monsterList.add(monster);
		}
		return monsterList;
	}
	
	private String space(String str, int num) {
		while(str.length() < num) {
			str += " ";
		}
		return str;
	}
	
	public void printMonster(ArrayList<Monster> monsterList) {
		System.out.print("\n");
		System.out.println("Your Enemy's Troops:");
		System.out.println(">>>>>>>>>>>>>>>>>>>>");
		System.out.print("\n");
		System.out.println("Name"+ "                           " + "Level"+ "		      "+"Damage"+ "                  "+ "Defense" + "                "+ "Dodge Chance");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
		Monster monster;
		String name, dmg, lv, defense;
		float dodChance;
        for(int i = 0; i<monsterList.size(); i++) {
        	monster = monsterList.get(i);
        	name = monster.getName();
        	name = space(name,20);
        	
        	dmg = Integer.toString(monster.getDamage());
        	dmg = space(dmg,10);
        	
        	lv = Integer.toString(monster.getLv());
        	lv = space(lv,10);
        	
        	defense = Integer.toString(monster.getDefense());
        	defense = space(defense,10);
        	
        	dodChance = monster.getDodgeRate();
        	
        	System.out.println(i+")"+name + "		"+lv+"		"+dmg+"		"+defense+"		"+dodChance);
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
	}
	
	
	public void reset(ArrayList<Monster> deadMonster) {
		for(int i = 0; i<deadMonster.size();i++) {
			Monster m = deadMonster.get(i);
			m.reset();
		}
		monsterFactory.addAll(deadMonster);
		deadMonster.removeAll(deadMonster);
	}

	
}
