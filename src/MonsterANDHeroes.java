package src;

import java.util.ArrayList;
import java.util.Random;

public class MonsterANDHeroes extends MonsterGame {
//the class represents the monster and heroes game

	MAHHeroFactory allHeroes = new MAHHeroFactory(MonsterGame.in);
	private ArrayList<Hero> deadHero = new ArrayList<Hero>();
	private ArrayList<Monster> deadMonster = new ArrayList<Monster>();
	private MAHTeam MAHTeam;
	private char lastCell = ' ';
	
	public MonsterANDHeroes() {
		super(new MAHHeroFactory(MonsterGame.in), new ArrayList<Monster>(), new MonsterFactory(),
				new MonsterAndHerosBoardFactory(), 8, 8 );
		MAHTeam = new MAHTeam(getHeros(),'X');
	}

	public static void intro() {
		System.out.println("					Legends: Monsters and Heroes");
		Patterns.printIntHead();
		System.out.println("	In the ancient times kingdom Java, after defeating the commander of the evil troops Python, ");
		System.out.println("	bestowned peace amongst humans and builted his capital. ");
		System.out.println("	However, the peaceful land was in chaos again...\n");
		Patterns.printSand();
		System.out.println("Do you want to visit the basic information of the game?");
		System.out.print("Enter yes/YES to visit or others to start the game: ");
		String y = in.next();
		if(y.equals("YES")|| y.equals("yes")) {
			basicInfo();
		}
		Patterns.printGameBegin();
	}
	public void GameBegin() {
		MAHTeam.printTeam();
		MAHTeam.setPosition(7,7);
		board.setCelltype(7, 7, MAHTeam.getTeamCell());
		board.printBoard();
		System.out.println("Time for our destination! ");
		checkMove();

	}
	
	public static void basicInfo() {
		System.out.println("	Basic Information:");
		System.out.println("	=====================\n");
		System.out.println("	For movement:	W - move forward");
		System.out.println("			A - move left");
		System.out.println("			S - move backwards");
		System.out.println("			D - move right");
		System.out.println("			Q - quit game");
		System.out.println("			I - show information");
		System.out.println("You cannot move diagonally!\n");
		System.out.println("You can choose up to 3 heroes to fight!");
		System.out.println("To fight, buy, sell or use an item follow the instructions given during the name(by typing what ever needed).");
		System.out.println("To Quit game press q/Q whenever you are making a move. You CANNOT exit when in the market or during a fight!");
		System.out.print("Enter start/START whenever you are ready! ");
		String s = in.next();
		while(!s.equals("START")&&!s.equals("start")) {
			System.out.print("Waiting for you...");
			System.out.print("Enter start/START whenever you are ready! ");
			s = in.next();
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

	
	public void checkMove() {
		System.out.print("Enter your move: ");
		String str = in.next();
		str = str.toLowerCase();
		while(!str.equals("w") && !str.equals("a") &&!str.equals("s") && !str.equals("d")&& !str.equals("i")&& !str.equals("q")) {
			System.out.print("Invalid input! Please enter your move: ");
			str = in.next();
			str = str.toLowerCase();
		}
		moveTeam(str);
	}
	
	public void moveTeam(String move) {
		int row = MAHTeam.getRow();
		int col = MAHTeam.getCol();
		int rowNext, colNext;
		char teamCell = MAHTeam.getTeamCell();
		
		if(move.equals("w")) {
			rowNext = row-1;
			colNext = col;
			if(board.checkCellAccess(rowNext,colNext,teamCell)== 1 ||board.checkCellAccess(rowNext,colNext,teamCell)== 2) {
				checkMove();
			}else if(board.checkCellAccess(rowNext,colNext,teamCell)== 3) {
				board.setCelltype(row, col, lastCell);
				lastCell = 'M';
				board.setCelltype(rowNext, colNext, teamCell);
				MAHTeam.setPosition(rowNext, colNext);
				board.printBoard();
				market();
			}else if(board.checkCellAccess(rowNext,colNext,teamCell)== 0) {
				board.setCelltype(row, col, lastCell);
				lastCell = ' ';
				board.setCelltype(rowNext, colNext, teamCell);
				MAHTeam.setPosition(rowNext, colNext);
				board.printBoard();
				emptyCell();
			}
		}
		
		if(move.equals("a")) {
			rowNext = row;
			colNext = col-1;
			if(board.checkCellAccess(rowNext,colNext,teamCell)== 1 ||board.checkCellAccess(rowNext,colNext,teamCell)== 2) {
				checkMove();
			}else if(board.checkCellAccess(rowNext,colNext,teamCell)== 3) {
				board.setCelltype(row, col, lastCell);
				lastCell = 'M';
				board.setCelltype(rowNext, colNext, teamCell);
				MAHTeam.setPosition(rowNext, colNext);
				board.printBoard();
				market();
			}else if(board.checkCellAccess(rowNext,colNext,teamCell)== 0) {
				board.setCelltype(row, col, lastCell);
				lastCell = ' ';
				board.setCelltype(rowNext, colNext, teamCell);
				MAHTeam.setPosition(rowNext, colNext);
				board.printBoard();
				emptyCell();
			}
		}
		
		if(move.equals("s")) {
			rowNext = row+1;
			colNext = col;
			if(board.checkCellAccess(rowNext,colNext,teamCell)== 1 ||board.checkCellAccess(rowNext,colNext,teamCell)== 2) {
				checkMove();
			}else if(board.checkCellAccess(rowNext,colNext,teamCell)== 3) {
				board.setCelltype(row, col, lastCell);
				lastCell = 'M';
				board.setCelltype(rowNext, colNext, teamCell);
				MAHTeam.setPosition(rowNext, colNext);
				board.printBoard();
				market();
			}else if(board.checkCellAccess(rowNext,colNext,teamCell)== 0) {
				board.setCelltype(row, col, lastCell);
				lastCell = ' ';
				board.setCelltype(rowNext, colNext, teamCell);
				MAHTeam.setPosition(rowNext, colNext);
				board.printBoard();
				emptyCell();
			}
		}
		
		if(move.equals("d")) {
			rowNext = row;
			colNext = col+1;
			if(board.checkCellAccess(rowNext,colNext,teamCell)== 1 ||board.checkCellAccess(rowNext,colNext,teamCell)== 2) {
				checkMove();
			}else if(board.checkCellAccess(rowNext,colNext,teamCell)== 3) {
				board.setCelltype(row, col, lastCell);
				lastCell = 'M';
				board.setCelltype(rowNext, colNext, teamCell);
				MAHTeam.setPosition(rowNext, colNext);
				board.printBoard();
				market();
			}else if(board.checkCellAccess(rowNext,colNext,teamCell)== 0) {
				board.setCelltype(row, col, lastCell);
				lastCell = ' ';
				board.setCelltype(rowNext, colNext, teamCell);
				MAHTeam.setPosition(rowNext, colNext);
				board.printBoard();
				emptyCell();
			}
		}
		if(move.equals("i")) {
			MAHTeam.printTeam();
		}
		if(move.equals("q")) {
			Patterns.printBye();
			System.exit(0);
		}
		allHeroes.LEVELUP(MAHTeam.getParty());
		System.out.print("Enter B/b to show board, q/Q to quit game, anything else to continue move: ");
		String ans = in.next();
		if(ans.charAt(0)=='B' ||ans.charAt(0)=='b') {
			board.printBoard();
		}else if(ans.charAt(0)=='q' ||ans.charAt(0)=='Q') {
			Patterns.printBye();
			System.exit(0);
		}
		checkMove();
	}
	
	public void market() {
		Patterns.printMarket();
		System.out.print("Enter I/i to show inventory, else to directly visit market: ");
		String inv = in.next();
		if(inv.charAt(0)=='I' ||inv.charAt(0)=='i') {
			MAHTeam.printStorage();
		}
		MAHTeam.printMoney();
		System.out.print("Please enter a number to choose a hero to visit the Market(0 - "+(MAHTeam.getParty().size()-1)+"): ");
		in.nextLine();
        int num = isInt();
        while (num < 0|| num> MAHTeam.getParty().size()-1) {
    		System.out.print("Invalid number! Please enter a number to choose a hero(0 - "+(MAHTeam.getParty().size()-1)+"): ");
            in.nextLine();
            num = isInt();
        }
        Hero h = MAHTeam.getTeamMemb(num);
        market = Market.getInstance();
        market.visitMarket(h);
        System.out.print("Enter m/M to display map, or anything else to continue moving: ");
        String str = in.next();
		if(str.equals("m") ||str.equals("M") ) {
			board.printBoard();
		}
        checkMove();
	}
	
	private void emptyCell() {
        int n = new Random().nextInt(100);
        if(n >= 25){
        	Patterns.printAttacked();
        	monsterList = allMonsters.generateMonster(MAHTeam.getParty().size(), MAHTeam.getMaxLv());
        	allMonsters.printMonster(monsterList);
        	Patterns.printTeamSt();
        	MAHTeam.printTeam();
        	fight(1, MAHTeam, monsterList);
        	allHeroes.Revive(deadHero);
        	MAHTeam.getParty().addAll(deadHero);
        	deadHero.removeAll(deadHero);
        	allMonsters.reset(deadMonster);
        }
        else {
        	Patterns.printSafe();
            System.out.println("Check Status or Continue move?");
            safePlace();
        }
	}
	
	private void safePlace() {
		System.out.print("Enter C for check Status, and anything else to continue move: ");
		String check = in.next();
		while(check.charAt(0) == 'C' || check.charAt(0) == 'c') {
			System.out.println("Choose one for:	");
			System.out.println("	[T]Team status");
			System.out.println("	[E]Equip Armor/Weapon");
			System.out.println("	[I]Inventory");
			System.out.println("	[P]Use Potion");
	        System.out.print("	Or [Q]Quit Game:");
	        String str = in.next();
			str = str.toLowerCase();
			while(str.charAt(0)!='t' && str.charAt(0)!='e' && str.charAt(0)!='i' && str.charAt(0)!='p' && str.charAt(0)!='q') {
				System.out.println("Invalid Input!");
				System.out.println("Choose one for:	");
				System.out.println("	[T]Team status");
				System.out.println("	[E]Equip Armor/Weapon");
				System.out.println("	[I]Inventory");
				System.out.println("	[P]Use Potion");
		        System.out.print("	Or [Q]Quit Game:");	
		        str = in.next();
				str = str.toLowerCase();
			}
			if (str.charAt(0) == 't'){
				MAHTeam.printTeam();
			}else if(str.charAt(0) == 'e') {
				equipItem(MAHTeam);
			}else if(str.charAt(0) == 'i') {
				MAHTeam.printStorage();
			}else if(str.charAt(0) == 'p') {
				usePotion(MAHTeam);
			}else {
				Patterns.printBye();
				System.exit(0);
			}
			System.out.println("Enter C for continue checking Status, and anything else to move: ");
			check = in.next();
		}
	}
	
	private Hero chooseFromTeam(MAHTeam team, String str) {
		System.out.print("Choose a hero to "+str+": ");
		team.printTeam();
		System.out.print("Please enter a number to choose a hero to "+str+" (0 - "+(team.getParty().size()-1)+"): ");
		in.nextLine();
		int num = isInt();
		while(num<0||num>(team.getParty().size()-1)) {
			System.out.println("Invalid number!");
			System.out.print("Please enter a number to choose a hero to "+str+" (0 - "+(team.getParty().size()-1)+"): ");
			in.nextLine();
			num = isInt();
		}
		Hero h = team.getTeamMemb(num);
		return h;
	}
	
	
	private void fight(int round, MAHTeam team, ArrayList<Monster> monster) {
		if(team.getParty().size()>0 && monster.size() ==0) {
			Patterns.printVictory();
			for(int i = 0; i < team.getParty().size(); i++){
				team.getTeamMemb(i).addMoney(150);
				team.getTeamMemb(i).addExp(2);
			}
			return;
		}else if(team.getParty().size()==0) {
			Patterns.printDefeat();
			return;
		}
		while(team.getParty().size()>0 && monster.size()>0) {
			System.out.println();
			System.out.println("				--------- R O U N D   "+round+" ---------");
			System.out.println();
			for(int i = 0; i< team.getParty().size(); i++) {
				int j = 0;
				while(j<monster.size()) {
					Monster m = monster.get(j);
					if(m.getHp() == 0) {
						deadMonster.add(m);
						monster.remove(j);
					}else {
						j++;
					}
				}
				Hero h = team.getTeamMemb(i);
				System.out.println("Hero "+h.getName()+"'s turn!");
				Monster m = chooseFromMonster(monster);
				HerosTurn(h,m);
				m.attack(h);
			}
			int k = 0;
			while(k<team.getParty().size()) {
				Hero h = team.getTeamMemb(k);
				if(h.getHp() == 0) {
					deadHero.add(h);
					team.getParty().remove(k);
				}else {
					k++;
				}
			}
			
			allHeroes.recoverRound(team.getParty());
			allHeroes.bonusCoin(team.getParty());
			round++;
			fight(round, team, monster);
		}

		
	}
	
	private Monster chooseFromMonster(ArrayList<Monster> monster) {
    	allMonsters.printMonster(monster);
		System.out.print("Please enter a number to choose a monster to confront (0 - "+(monster.size()-1)+"): ");
		in.nextLine();
		int num = isInt();
		while(num<0||num>(monster.size()-1)) {
			System.out.println("Invalid number!");
			System.out.print("Please enter a number to choose a monster to confront (0 - "+(monster.size()-1)+"): ");
			in.nextLine();
			num = isInt();
		}
		Monster m = monster.get(num);
		return m;
	}
	

	
	public void HerosTurn(Hero h, Monster m) {
		System.out.println("Choose one for "+h.getName()+":");
		System.out.println("	[A]Attack");
		System.out.println("	[C]Cast Spell");
		System.out.println("	[U]Use Potion");
		System.out.println("	[E]Equip Armor/Weapon");
		System.out.print("	Or [Q]Quit Game: ");
		String str = in.next();
		str = str.toLowerCase();
		while(str.charAt(0)!='a' && str.charAt(0)!='c' && str.charAt(0)!='u' && str.charAt(0)!='e' && str.charAt(0)!='q') {
			System.out.println("Invalid Input!");
			System.out.println("Choose one for "+h.getName()+":");
			System.out.println("	[A]Attack");
			System.out.println("	[C]Cast Spell");
			System.out.println("	[U]Use Potion");
			System.out.println("	[E]Equip Armor/Weapon");
			System.out.print("	Or [Q]Quit Game: ");
			str = in.next();
			str = str.toLowerCase();
		}
		if (str.charAt(0) == 'A' || str.charAt(0) == 'a'){
			h.attack(m);
		}else if(str.charAt(0) == 'C' || str.charAt(0) == 'c') {
			h.magicAttack(m);
		}else if(str.charAt(0) == 'U' || str.charAt(0) == 'u') {
			usePotion(h,m);
		}else if(str.charAt(0) == 'E' || str.charAt(0) == 'e') {
			equipItem(h,m);
		}else {
			Patterns.printBye();
			System.exit(0);
		}
	}
	
	public void usePotion(Hero h, Monster m) {
		if(h.getPotionStore().size()==0) {
			System.out.print("Sorry! "+h.getName()+" does not have enough potion! Cannot use!");
			HerosTurn(h ,m);
		}else {
			h.printPotionStora();
			System.out.print("Enter number of the potion to use (0 - "+ (h.getPotionStore().size()-1) +"): ");
			in.nextLine();
	        int num = isInt();
			while(num<0||(num>(h.getPotionStore().size()-1))){
				System.out.println("Invalid input!");
				System.out.print("Enter number of the potion to use (0 - "+ (h.getPotionStore().size()-1) +"): ");
	    		in.nextLine();
	        	num = isInt();
			}
	        h.usePotion(h.getPotionStore().get(num));
		}
	}
	
	
	
	private void usePotion(MAHTeam team) {
		Hero h = chooseFromTeam(team, "use potion");
		if(h.getPotionStore().size()==0) {
			System.out.print("Sorry! "+h.getName()+" does not have enough potion! Cannot use!");
			safePlace();
		}else {
			h.printPotionStora();
			System.out.print("Enter number of the potion to use (0 - "+ (h.getPotionStore().size()-1) +"): ");
			in.nextLine();
	        int num = isInt();
			while(num<0||(num>(h.getPotionStore().size()-1))){
				System.out.println("Invalid input!");
				System.out.print("Enter number of the potion to use (0 - "+ (h.getPotionStore().size()-1) +"): ");
	    		in.nextLine();
	        	num = isInt();
			}
	        h.usePotion(h.getPotionStore().get(num));
		}
		
	}

	private void equipItem(Hero h, Monster m) {
        System.out.println("Choose one for "+h.getName()+":");
        System.out.println("	[A]Equip Armor		[B]Unequip Armor");
        System.out.println("	[C]Equip Weapon		[D]Unequip Weapon: ");
        System.out.println("	[E]Equip spell		[F]Unequip Spell");
        System.out.print("	Or [Q]Quit Game: ");
        String str = in.next();
		str = str.toLowerCase();
		while(str.charAt(0)!='a' && str.charAt(0)!='b' && str.charAt(0)!='c' && str.charAt(0)!='d' && str.charAt(0)!='e' && str.charAt(0)!='f' && str.charAt(0)!='q') {
			System.out.println("Invalid Input!");
	        System.out.println("Choose one for "+h.getName()+":");
	        System.out.println("	[A]Equip Armor		[B]Unequip Armor");
	        System.out.println("	[C]Equip Weapon		[D]Unequip Weapon: ");
	        System.out.println("	[E]Equip spell		[F]Unequip Spell");
	        System.out.print("	Or [Q]Quit Game: ");		
	        str = in.next();
			str = str.toLowerCase();
		}
		if (str.charAt(0) == 'a'){
			if(h.getArmorStore().size()==0) {
				System.out.println("Sorry! "+h.getName()+"does not have enough armor to equip! Please buy in Market!");
				equipItem(h,m);
			}else {
				h.equipArmor();
			}
		}else if(str.charAt(0) == 'b') {
			h.unequipArmor();
		}else if(str.charAt(0) == 'c') {
			if(h.getWeaponStore().size()==0) {
				System.out.println("Sorry! "+h.getName()+"does not have enough weapon to equip! Please buy in Market!");
				equipItem(h,m);
			}else {
				h.equipWeapon();
			}
		}else if(str.charAt(0) == 'd') {
			h.unequipWeapon();
		}else if(str.charAt(0) == 'e') {
			if(h.getSpellStore().size()==0) {
				System.out.println("Sorry! "+h.getName()+"does not have enough spell to equip! Please buy in Market!");
				equipItem(h,m);
			}else {
				h.equipSpell();
			}
		}else if(str.charAt(0) == 'd') {
			h.unequipSpell();
		}else {
			Patterns.printBye();
			System.exit(0);
		}
	}
	
	
	
	
	private void equipItem(MAHTeam team) {
		Hero h = chooseFromTeam(team, "equip item");
		System.out.println("Choose one for "+h.getName()+": ");
		System.out.println("	[A]Equip Armor		[B]Unequip Armor");
	    System.out.println("	[C]Equip Weapon		[D]Unequip Weapon: ");
	    System.out.println("	[E]Equip spell		[F]Unequip Spell: ");
	    System.out.print("	Or [Q]Quit Game: ");
	    String str = in.next();
		str = str.toLowerCase();
		while(str.charAt(0)!='a' && str.charAt(0)!='b' && str.charAt(0)!='c' && str.charAt(0)!='d' && str.charAt(0)!='e' && str.charAt(0)!='f' && str.charAt(0)!='q') {
			System.out.println("Invalid Input!");
			System.out.println("Choose one for "+h.getName()+": ");
			System.out.println("	[A]Equip Armor		[B]Unequip Armor");
	        System.out.println("	[C]Equip Weapon		[D]Unequip Weapon: ");
	        System.out.println("	[E]Equip spell		[F]Unequip Spell: ");
	        System.out.print("	Or [Q]Quit Game: ");			
	        str = in.next();
			str = str.toLowerCase();
		}
		if (str.charAt(0) == 'a'){
			h.equipArmor();
			if(h.getArmorStore().size()==0) {
				safePlace();
			}
		}else if(str.charAt(0) == 'b') {
			h.unequipArmor();
		}else if(str.charAt(0) == 'c') {
			h.equipWeapon();
			if(h.getWeaponStore().size()==0) {
				safePlace();
			}
		}else if(str.charAt(0) == 'd') {
			h.unequipWeapon();
		}else if(str.charAt(0) == 'e') {
			h.equipSpell();
			if(h.getSpellStore().size()==0) {
				safePlace();
			}
		}else if(str.charAt(0) == 'd') {
			h.unequipSpell();
		}else {
			System.out.println("Thank you for playing! B Y E !");
			System.exit(0);
		}
	}

	public  void start() {
		GameBegin();
	}

	
}
