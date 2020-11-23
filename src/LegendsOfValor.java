package src;

import java.util.ArrayList;
import java.util.Scanner;

public class LegendsOfValor extends MonsterGame {
	//the class represents the Legand of Valor game

    public final static int LOV_ROWS = 8;
    public final static int LOV_COLUMNS = 8;
    public final int LOV_LANE_SIZE = 3;

    public final int LOV_HERO_NEXUS_ROW = LOV_ROWS -1;

    public final int LOV_VILLAIN_NEXUS_ROW = 0;

    public final static int LOV_NUM_LANES = (LOV_COLUMNS + 1) /3;

    public final int LOV_MONSTER_RESPAWN_RATE = 8;

    private LOVBoard board;

    private int winCond;
    //if a nexus is occupied, if wincon<0 villains win, else heros
    private int Nexi_occupied;
    //true means that we can start checking if winCond is equal to or greater than 0

    public LegendsOfValor(){
        super(new LOVHeroFactory(new Scanner(System.in), LOV_NUM_LANES), new ArrayList<Monster>(),new MonsterFactory(),new LOVBoardFactory(),LOV_ROWS,LOV_COLUMNS);
        this.board = (LOVBoard) (super.board);
        this.winCond = 0;
        this.Nexi_occupied = 0;
    }

    public LegendsOfValor(HeroFactory H_factory, ArrayList<Monster> monsterList, MonsterFactory allMonsters, BoardFactory B_Factory, int rows, int columns, ArrayList<Hero> heros, ArrayList<Monster> villains) {
        super(H_factory, monsterList, allMonsters, B_Factory, rows, columns);
    }


    public static void intro(){
    	System.out.println("					Legends	of	Valor");
		Patterns.printIntro();
		String y = in.next();
		if(y.equals("YES")|| y.equals("yes")) {
			basicInfo();
		}
		Patterns.printGameBegin();
    }

    public static void basicInfo() {
		System.out.println("	Basic Information:");
		System.out.println("	=====================\n");
		System.out.println("	For movement:	W - move forward");
		System.out.println("			A - move left");
		System.out.println("			S - move backwards");
		System.out.println("			D - move right");
		System.out.println("You cannot move diagonally!\n");
		System.out.println("In every round every heroes can:");
		System.out.println("[W]Move Up     [A]Move left     [S]Move Down        [D]Move right");
        System.out.println("[F]Fight monster nearby     [T]Teleport");
		System.out.println("[B]Back to nexus        [M]Shopping in the nexus");
        System.out.println("or [Q]Quit the game");
		System.out.println("You should choose 3 heroes to fight!");
		System.out.println("To fight, buy, sell or use an item follow the instructions given during the name(by typing what ever needed).");
		System.out.println("To Quit game press q/Q whenever you are making a move. You CANNOT exit during a fight!");
		System.out.print("Enter start/START whenever you are ready! ");
		String s = in.next();
		while(!s.equals("START")&&!s.equals("start")) {
			System.out.print("Waiting for you...");
			System.out.print("Enter start/START whenever you are ready! ");
			s = in.next();
		}
	}

    private void gameBegin(){
        //Effect: Creates game
    	intro();
        ArrayList<Integer> lanes= new ArrayList<Integer>();
        for(int j = 0; j < LOV_NUM_LANES;){
            j++;
            lanes.add(j);
        }
        for(Hero hero:Heros ){
            int i = selectLane(hero, lanes);
            hero.setCreaturePosition(board, LOV_HERO_NEXUS_ROW,i*LOV_LANE_SIZE);
            Monster monster = allMonsters.generateMonster(1,hero.level).get(0).clone();
            monster.setMarker('M');
            monster.setCreaturePosition(board, LOV_VILLAIN_NEXUS_ROW, i*LOV_LANE_SIZE);
            monsterList.add(monster);
            board.getCell(LOV_HERO_NEXUS_ROW,i*LOV_LANE_SIZE).setPositions(new char[]{hero.getMarker(), ' '});
            board.getCell(LOV_VILLAIN_NEXUS_ROW,i*LOV_LANE_SIZE).setPositions(new char[]{' ', monster.getMarker()});
        }
    }

    private int selectLane(Hero hero, ArrayList<Integer> lanes){
        int i =0;
        if(lanes.size() == 1){
            System.out.println(hero.getName() + "autoplaced in lane " + lanes.get(0).toString());
            i = lanes.get(0);
        }
        else {

            boolean valid_lane = false;

            while (!valid_lane) {
                System.out.println("");
                System.out.println("Select which lane to add Hero!");
                System.out.print("Current lanes: ");
                for (Integer lane : lanes) {
                    System.out.print(lane.toString() + " ");
                }
                System.out.println("");
                System.out.println("Hero: " + hero.getName());
                i = isInt();
                if (lanes.contains(i)) {
                    valid_lane = true;
                    lanes.remove((Integer) i);
                } else {
                    System.out.println("Invalid input");
                }
            }
        }
        i--;
        return i;
    }

    private void doHerosTurn(){
        for(Hero hero: Heros) {
            while(!HeroAction(hero));
            System.out.println(board.toString());
        }
    }

    private void doVillainsTurn(){
        for(Monster monster: monsterList) {
            while (!MonsterAction(monster));
            System.out.println(board.toString());
        }
    }

    private boolean IsOver(){
        return isMonsterWin() || isHeroWin();
    }

    private boolean HeroAction(Hero hero){
        System.out.println("-------------------------------------------------------");
        System.out.println("Enter your action for hero "+hero.getName()+": ");
        System.out.println("[W]Move Up     [A]Move left     [S]Move Down        [D]Move right");
        System.out.println("[F]Fight monster nearby     [T]Teleport");
        System.out.println("[I]Inventory        [Z]Status");
		System.out.println("[B]Back to nexus        [M]Shopping in the nexus");
		System.out.println("[;]Skip turn");
        System.out.println("or [Q]Quit the game");
        boolean input = CheckInput(hero);
        return input;
    }

    private boolean MonsterAction(Monster monster){
        Hero tgt = checkMonstersTargets(monster);
        if(tgt != null){
            monster.attack(tgt);
            if(tgt.isDead()){
                System.out.println(tgt.getName() + " is dead");
                cleanUpOldCell(board.getCell(tgt.row,tgt.col), tgt.getMarker());
                int i = 0;
                while(i<8) {
                	if(tgt.getCol()==i||tgt.getCol()==i+1) {
                    	if(!board.checkCellAccess(LOV_HERO_NEXUS_ROW, i)) {
                        	tgt.setCreaturePosition(board, LOV_HERO_NEXUS_ROW, i);
                        	break;
                        }else if(!board.checkCellAccess(LOV_HERO_NEXUS_ROW, i+1)) {
                        	tgt.setCreaturePosition(board, LOV_HERO_NEXUS_ROW, i+1);
                        	break;
                        }else if(!board.checkCellAccess(LOV_HERO_NEXUS_ROW, i+3)){
                        	tgt.setCreaturePosition(board, LOV_HERO_NEXUS_ROW, i+3);
                        	break;
                        }else if(!board.checkCellAccess(LOV_HERO_NEXUS_ROW, i-3)){
                        	tgt.setCreaturePosition(board, LOV_HERO_NEXUS_ROW, i-3);
                        	break;
                        }
                    }
                	i +=3;
                }          
                tgt.addHp((tgt.getLv()*100)/2);
                System.out.println(tgt.getName() + " is back to Nexus!");
            }
            return true;
        }
        if(moveMonster(new MoveDownCommand(), monster)){
            return true;
        }
        else if(moveMonster(new MoveRightCommand(), monster)){
            return true;
        }
        else if( moveMonster(new MoveLeftCommand(), monster)){
            return true;
        }
        else if( moveMonster(new MoveUPCommand(), monster)){
            return true;
        }
        else{
            return false;
        }

    }


    private boolean CheckInput(Hero hero){
        String str = in.next();
        while(true){
            if(str.charAt(0)== 'w'||str.charAt(0)== 'W'){
                return moveHero(new MoveUPCommand(), hero);
            }else if(str.charAt(0)== 'a'||str.charAt(0)== 'A'){
                return moveHero(new MoveLeftCommand(), hero);
            }else if(str.charAt(0)== 's'||str.charAt(0)== 'S'){
                return moveHero(new MoveDownCommand(), hero);
            }else if(str.charAt(0)== 'd'||str.charAt(0)== 'D'){
                return moveHero(new MoveRightCommand(), hero);
            }else if(str.charAt(0)== 'f'||str.charAt(0)== 'F'){
               return dofight(hero);
            }else if(str.charAt(0)== 't'||str.charAt(0)== 'T'){
                return Teleport(hero);
            }else if(str.charAt(0)== 'i'||str.charAt(0)== 'I'){
                return doInventoryThings(hero);
            }else if(str.charAt(0)== 'z'||str.charAt(0)== 'Z'){
            	hero.printSingleHero(hero);
            	return false;
            }else if(str.charAt(0)== 'b'||str.charAt(0)== 'B'){
            	return BackNexus(hero);
            }else if(str.charAt(0)== 'm'||str.charAt(0)== 'M'){
            	return ShopInNexus(hero);
            }else if(str.charAt(0)== ';') {
            	return true;
            }else if(str.charAt(0)== 'q'||str.charAt(0)== 'Q'){
                Patterns.printBye();
                System.exit(0);
            }
            else{
                System.out.println("Invalid input");
                return false;
            }
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

    private boolean Teleport(Hero hero){
        System.out.println("Which lane you want teleport to?");
        System.out.print("[1]Top lane   [2]Mid lane     [3]Bottom lane : ");
        int lane = isInt();
        while(lane<1||lane>LOV_NUM_LANES){
            System.out.print("Invalid input! Please enter a number to choose from 3 lanes: ");
    		in.nextLine();
    		lane = isInt();
        }
        if(lane == 1){
            if(hero.getCol()==0 || hero.getCol()==1){
                System.out.println("Hero "+hero.getName()+" is already at Top lane!");
                return false;
            }else{
            	LOVCell old = board.getCell(hero.getRow(),hero.getCol());
                cleanUpOldCell(old,hero.getMarker());
            	if(!board.checkCellAccess(hero.getRow(), 0)) {
            		hero.setCreaturePosition(board, hero.getRow(), 0);
            	}else if(!board.checkCellAccess(hero.getRow(), 1)) {
            		hero.setCreaturePosition(board, hero.getRow(), 1);
            	}else if(hero.getRow()==7) {
            		hero.setCreaturePosition(board, hero.getRow()-1, 0);
            	}else {
            		hero.setCreaturePosition(board, hero.getRow()+1, 0);
            	}
            	LOVCell temp = board.getCell(hero.getRow(),hero.getCol());
            	temp.doBoostBehavior(hero);
            	return true;
            }
        }else if(lane ==2) {
        	if(hero.getCol()==3 || hero.getCol()==4){
                System.out.println("Hero "+hero.getName()+" is already at Mid lane!");
                return false;
            }else{
            	LOVCell old = board.getCell(hero.getRow(),hero.getCol());
                cleanUpOldCell(old,hero.getMarker());
            	if(!board.checkCellAccess(hero.getRow(), 3)) {
            		hero.setCreaturePosition(board, hero.getRow(), 3);
            	}else if(!board.checkCellAccess(hero.getRow(), 4)) {
            		hero.setCreaturePosition(board, hero.getRow(), 4);
            	}else if(hero.getRow()==7) {
            		hero.setCreaturePosition(board, hero.getRow()-1, 3);
            	}else {
            		hero.setCreaturePosition(board, hero.getRow()+1, 3);
            	}
            	LOVCell temp = board.getCell(hero.getRow(),hero.getCol());
            	temp.doBoostBehavior(hero);
            	return true;
            }
        }else{
        	if(hero.getCol()==6 || hero.getCol()==7){
                System.out.println("Hero "+hero.getName()+" is already at Bottom lane!");
                return false;
            }else{
            	LOVCell old = board.getCell(hero.getRow(),hero.getCol());
                cleanUpOldCell(old,hero.getMarker());
            	if(!board.checkCellAccess(hero.getRow(), 6)) {
            		hero.setCreaturePosition(board, hero.getRow(), 6);
            	}else if(!board.checkCellAccess(hero.getRow(), 7)) {
            		hero.setCreaturePosition(board, hero.getRow(), 7);
            	}else if(hero.getRow()==7) {
            		hero.setCreaturePosition(board, hero.getRow()-1, 6);
            	}else {
            		hero.setCreaturePosition(board, hero.getRow()+1, 6);
            	}
            	LOVCell temp = board.getCell(hero.getRow(),hero.getCol());
            	temp.doBoostBehavior(hero);
            	return true;
            }
        }
    }

    private boolean BackNexus(Hero hero) {
    	String fullNexus = "The Nexus is already full! You should Teleport to another lane and back to Nexus!";
    	if(hero.getCol()==0||hero.getCol()==1) {
    		if(board.checkCellAccess(7, 0) ||board.checkCellAccess(7, 1)) {
        		System.out.println(fullNexus);
        		return false;
        	}else {
        		if(!board.checkCellAccess(7, 0)) {
        			hero.setCreaturePosition(board,7, 0);
        		}else {
        			hero.setCreaturePosition(board,7, 1);
        		}
        		return true;
        	}
    	}else if(hero.getCol()==3||hero.getCol()==4) {
    		if(board.checkCellAccess(7, 3) ||board.checkCellAccess(7, 4)) {
        		System.out.println(fullNexus);
        		return false;
        	}else {
        		if(!board.checkCellAccess(7, 3)) {
        			hero.setCreaturePosition(board,7, 3);
        		}else {
        			hero.setCreaturePosition(board,7, 4);
        		}
        		return true;
        	}
    	}else {
    		if(board.checkCellAccess(7, 6) ||board.checkCellAccess(7, 7)) {
        		System.out.println(fullNexus);
        		return false;
        	}else {
        		if(!board.checkCellAccess(7, 6)) {
        			hero.setCreaturePosition(board,7, 6);
        		}else {
        			hero.setCreaturePosition(board,7, 7);
        		}
        		return true;
        	}
    	}

    }

    private boolean ShopInNexus(Hero hero) {
    	if(hero.getRow()==7) {
    	    Patterns.printMarket();
    		market.visitMarket(hero);
    		return false;
    	}else {
    		System.out.println("Sorry! you are not in Nexus! Cannot shopping! Please choose another action!");
    		return false;
    	}
    }

    private boolean doInventoryThings(Hero hero){
        do{
            System.out.println("[D]isplay Inventory   Use [P]otion  Equip [I]tem");
            String str2 = in.next();
            str2 = str2.toLowerCase();
            if (str2.charAt(0) == 'd') {
                return Inventory(hero);
            } else if (str2.charAt(0) == 'p') {
                return usePotion(hero);
            } else if (str2.charAt(0) == 'i') {
                return equipItem(hero);
            }
            else{
                System.out.println("Invalid input!");
            }
        }while(true);
    }

    private boolean Inventory(Hero hero) {
    	System.out.println(hero.getName()+":");
    	hero.printArmorStora();
    	hero.printPotionStora();
    	hero.printSpellStora();
    	hero.printWeaponStora();
    	return false;
    }

    private boolean usePotion(Hero h) {
        if(h.getPotionStore().size()==0) {
            System.out.print("Sorry! "+h.getName()+" does not have enough potion! Cannot use!");
            return false;
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
            return true;
        }
    }

    private boolean equipItem(Hero h) {
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
                equipItem(h);
            }else {
                h.equipArmor();
                return true;
            }
        }else if(str.charAt(0) == 'b') {
            h.unequipArmor();
            return false;
        }else if(str.charAt(0) == 'c') {
            if(h.getWeaponStore().size()==0) {
                System.out.println("Sorry! "+h.getName()+"does not have enough weapon to equip! Please buy in Market!");
                equipItem(h);
            }else {
                h.equipWeapon();
                return true;
            }
        }else if(str.charAt(0) == 'd') {
            h.unequipWeapon();
            return false;
        }else if(str.charAt(0) == 'e') {
            if(h.getSpellStore().size()==0) {
                System.out.println("Sorry! "+h.getName()+"does not have enough spell to equip! Please buy in Market!");
                equipItem(h);
            }else {
                h.equipSpell();
                return true;
            }
        }else if(str.charAt(0) == 'd') {
            h.unequipSpell();
            return false;
        }else {
            Patterns.printBye();
            System.exit(0);
        }
        return false;
    }

    public void HerosTurn(Hero h, Monster m) {
        System.out.println("Choose one for "+h.getName()+":");
        System.out.println("	[A]Attack");
        System.out.println("	[C]Cast Spell");
        System.out.print("	Or [Q]Quit Game: ");
        String str = in.next();
        str = str.toLowerCase();
        while(str.charAt(0)!='a' && str.charAt(0)!='c' && str.charAt(0)!='q') {
            System.out.println("Invalid Input!");
            System.out.println("Choose one for "+h.getName()+":");
            System.out.println("	[A]Attack");
            System.out.println("	[C]Cast Spell");
            System.out.print("	Or [Q]Quit Game: ");
            str = in.next();
            str = str.toLowerCase();
        }
        if (str.charAt(0) == 'A' || str.charAt(0) == 'a'){
            h.attack(m);
        }else if(str.charAt(0) == 'C' || str.charAt(0) == 'c') {
            h.magicAttack(m);
        }else {
            Patterns.printBye();
            System.exit(0);
        }
    }

    public boolean dofight(Hero hero){
        ArrayList<Monster> tgts = checkHerosTargets(hero);
        if (tgts.size() > 0) {
            Monster m = chooseFromMonster(tgts);
            if (m == null){
                return false;
            }
            else{
                HerosTurn(hero,m);
                if(m.isDead()){
                    System.out.println(m.getName() + " is dead");
                    cleanUpOldCell(board.getCell(m.row,m.col), m.getMarker());
                    monsterList.remove(m);
                    hero.addExp(2);
                    hero.addMoney(100*m.level);
                    if(hero.checkLvUp()){
                        System.out.println(hero.getName() + " levels up to "+ hero.level+1 );
                        hero.levelUp();
                    }
                }
                return true;
            }
        }
        else{
            System.out.println("No Targets in range!");
            return false;
        }
    }

    private ArrayList<Monster> checkHerosTargets(Hero actor) {
        int row = actor.getRow();
        int col = actor.getCol();
        ArrayList<Monster> returnlist = new ArrayList<Monster>();
        //Creature
        for (int i = row - 1; i < row + 1; i++) {
            for (int j = col - 1; j < col + 1; j++) {
                for (Monster mon : monsterList) {
                    if (mon.getRow() == i && mon.getCol() == j) {
                        returnlist.add(mon);
                    }
                }
            }
        }
        return returnlist;
    }

    private Hero checkMonstersTargets(Monster actor) {
        int row = actor.getRow();
        int col = actor.getCol();
        //Creature
        for (int i = row + 1; i > row - 1; i--) {
            for (int j = col + 1; j > col - 1; j--) {
                for (Hero hero : Heros) {
                    if (hero.getRow() == i && hero.getCol() == j) {
                        return hero;
                    }
                }
            }
        }
        return null;
    }

    private Monster chooseFromMonster(ArrayList<Monster> monster) {
        allMonsters.printMonster(monster);
        String userMsg = "Please enter a number to choose a monster to confront (0 - "+(monster.size()-1)+") or enter -1 to do another action:  ";
        System.out.print(userMsg);
        in.nextLine();
        int num = isInt();
        while(num<-1||num>(monster.size()-1)) {
            System.out.println("Invalid number!");
            System.out.print(userMsg);
            in.nextLine();
            num = isInt();
        }
        if(num == -1){
            return null;
        }else {
            Monster m = monster.get(num);
            return m;
        }
    }


    private boolean checkMove(LOVCell cell, Creature c){
        char[] pos = cell.getPositions();
        if(cell.getCellType() == '&'){
            System.out.println("Inaccessible spot!");
            return false;
        }
        if(c instanceof Hero) {
            if (pos[0]!= ' ') {

            }
        }
        else if(c instanceof Monster){
            if(pos[1] != ' '){
                System.out.println("No avalible spot");
                return false;
            }
        }
        return true;
    }


    private void cleanUpOldCell(LOVCell old, char c){
        char[] oldPos = old.getPositions();
        if(oldPos[0] == c){
            oldPos[0] = ' ';
        }
        else{
            oldPos[1] = ' ';
        }
        old.setPositions(oldPos);
    }

    private boolean moveHero(MoveCommand moveCommand, Hero hero){
        try {
            LOVCell temp = moveCommand.getCell(board,hero);
            if (!checkMove(temp, hero)) {
                return false;
            } else {
                LOVCell old = board.getCell(hero.getRow(), hero.getCol());
                char monsterSpot = old.getPositions()[1];
                if (monsterSpot != ' '){
                    System.out.println("Cannot move past a monster! Try killing it!");
                    return false;
                }
                if(old.getCellType() == 'V'){
                    Nexi_occupied--;
                    winCond--;
                }
                if(temp.getCellType() == 'V'){
                    Nexi_occupied++;
                    winCond++;
                }
                cleanUpOldCell(old, hero.getMarker());
                moveCommand.doLOVMove(board,hero);
            }
            temp.doBoostBehavior(hero);
            return true;
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Cannot move up anymore!");
            return false;
        }
	}

    private boolean moveMonster(MoveCommand moveCommand, Monster monster){
        try {
            LOVCell temp = moveCommand.getCell(board,monster);
            if (!checkMove(temp, monster)) {
                return false;
            } else {
                LOVCell old = board.getCell(monster.getRow(), monster.getCol());
                if(old.getCellType()== 'H'){
                    Nexi_occupied--;
                    winCond++;
                }
                if(temp.getCellType() == 'H'){
                    Nexi_occupied++;
                    winCond--;
                }

                cleanUpOldCell(old, monster.getMarker());
                moveCommand.doLOVMove(board,monster);
            }
            return true;
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Cannot move up anymore!");
            return false;
        }
    }



    private boolean isMonsterWin(){
        if(Nexi_occupied>0){
            if(winCond<0){
                return true;
            }
        }
        return false;
    }

    private boolean isHeroWin(){
        if(Nexi_occupied>0){
            if(winCond>0){
                return true;
            }
        }
        return false;
    }


    public void spawnMonsters(){
        int max_lvl = 1;
        int i = 0;
        for(Hero hero: Heros){
            if (max_lvl >hero.getLv()){
                max_lvl = hero.getLv();
            }
            i++;
        }
        ArrayList<Monster> respawnlist = allMonsters.generateMonster(i++,max_lvl);
        i = 0;
        for(Monster mob: respawnlist){
            mob.setMarker('M');
            boolean noSpawn = false;
            LOVCell cell= board.getCell(LOV_VILLAIN_NEXUS_ROW, i*LOV_LANE_SIZE);
            if (cell.getPositions()[1] != ' '){
                cell = board.getCell(LOV_VILLAIN_NEXUS_ROW ,(i*LOV_LANE_SIZE)+1);
                if (cell.getPositions()[1] != ' '){
                    System.out.println("No place to spawn!");
                    noSpawn = true;
                }
            }
            i++;
            if(!noSpawn) {
                System.out.println( mob.getName() + " arrives at lane "+ (i));
                monsterList.add(mob);
                mob.setCreaturePosition(board,cell.getRow(),cell.getCol());
            }
        }
    }




    @Override
    public void start() {

        gameBegin();
        System.out.println(board.toString());
        int round = 0;
        while(!IsOver()) {
        	for(Hero hero:Heros ){
        		hero.addHp((int) (hero.getHp()*0.1));
        		hero.addMana((int) (hero.getMana()*0.1));
        	}
            doHerosTurn();
            doVillainsTurn();
            round++;
            if(round == LOV_MONSTER_RESPAWN_RATE){
                spawnMonsters();
                round =0;
            }
        }
        if(isHeroWin()){
            Patterns.printVictory();
        }else{
            Patterns.printDefeat();
        }
        Patterns.printBye();
    }
}
