package src;

import java.util.ArrayList;
import java.util.Scanner;

public class LegendsOfValor extends MonsterGame {

    private LOVBoard board;
    private ArrayList<Hero> HeroList = new ArrayList<Hero>();
    
    public LegendsOfValor(){
        super(new LOVHeroFactory(new Scanner(System.in)), new ArrayList<Monster>(),new MonsterFactory(),new LOVBoardFactory(),8,8);
        this.board = (LOVBoard) (super.board);
    }

    public LegendsOfValor(HeroFactory H_factory, ArrayList<Monster> monsterList, MonsterFactory allMonsters, BoardFactory B_Factory, int rows, int columns, ArrayList<Hero> heros, ArrayList<Monster> villains) {
        super(H_factory, monsterList, allMonsters, B_Factory, rows, columns);
    }


    public static void intro(){
        //d
    }

    private void gameBegin(){
        //Effect: Creates game
        int i =0;
        for(Hero hero:Heros ){
            hero.setCreaturePosition(board, 7,i*3);
            Monster monster = allMonsters.generateMonster(1,hero.level).get(0).clone();
            monster.setMarker('M');
            monster.setCreaturePosition(board, 0, i*3);
            monsterList.add(monster);
            board.getCell(7,i*3).setPositions(new char[]{hero.getMarker(), ' '});
            board.getCell(0,i++*3).setPositions(new char[]{monster.getMarker(), ' '});
        }
    }

    private void basicInfo(){
        //Effect: Explains game in Terminal
    }

    private void heroSelect(){
        //Effect: Selects heros to play in the game
    }

    private void doHerosTurn(){
        //Effect:Loops through heros and do PlayerCharacter.doTurn()
    }

    private void doVillainsTurn(){
        //Effect: Loops thru villains and do Monster.doTurn()
    }

    private boolean IsOver(){
        //Effect: returns if game is complete
        return false;
    }

    private boolean IsVillainWin(){
        //Effect: returns if true If Monsters won
        return false;
    }

    private boolean IsHeroWin(){
        //Effect: returns if true If Hero win
        return false;
    }

    private boolean HeroAction(Hero hero){
        System.out.println("-------------------------------------------------------");
        System.out.println("Enter your action for hero "+hero.getName()+": ");
        System.out.println("[W]Move Up     [A]Move left     [S]Move Down        [D]Move right");
        System.out.println("[F]Fight monster nearby     [T]Teleport");
        System.out.println("[I]Inventory        [Z]Status");
		System.out.println("[B]Back to nexus        [M]Shopping in the nexus");
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
                tgt.setCreaturePosition(board, 7, tgt.getCol());
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
        str = str.toLowerCase();
        boolean done = false;
        while(true){
            if(str.charAt(0)== 'w'){
                return moveHero(new MoveUPCommand(), hero);
            }else if(str.charAt(0)== 'a'){
                return moveHero(new MoveLeftCommand(), hero);
            }else if(str.charAt(0)== 's'){
                return moveHero(new MoveDownCommand(), hero);
            }else if(str.charAt(0)== 'd'){
                return moveHero(new MoveRightCommand(), hero);
            }else if(str.charAt(0)== 'f'){
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
                    return true;
                }

            }else if(str.charAt(0)== 't'){
                return Teleport(hero);
            }else if(str.charAt(0)== 'i'){
                return doInventoryThings(hero);

            }else if(str.charAt(0)== 'z'){
            	hero.printSingleHero(hero);
            	return false;
            }else if(str.charAt(0)== 'b'){
            	return BackNexus(hero);
            }else if(str.charAt(0)== 'm'){
            	return ShopInNexus(hero);
            }else if(str.charAt(0)== 'q'){
                Patterns.printBye();
                System.exit(0);
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
        while(lane<1||lane>3){
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
                cleanUpOldCell(old,'1');
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
                cleanUpOldCell(old,'1');
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
    		market.visitMarket(hero);
    		return false;
    	}else {
    		System.out.println("Sorry! you are not in Nexus! Cannot shopping! Please choose another action!");
    		return false;
    	}
    }

    private boolean doInventoryThings(Hero hero){
        while(true) {
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
        }
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
            return true;
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
            return true;
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
        while(str.charAt(0)!='a' && str.charAt(0)!='c' && str.charAt(0)!='u' && str.charAt(0)!='e' && str.charAt(0)!='q') {
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

    private void displayTargets(ArrayList<Monster> tgts, MonsterFactory fc){
        fc.printMonster(tgts);
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
        }
        else {
            Monster m = monster.get(num);
            return m;
        }
    }


    private boolean checkMove(LOVCell cell, Creature c){
        char[] pos = cell.getPositions();
        if(cell.getCellType() == '&'){
            System.out.println("Inaccessible spot!");
            return false;
        }else if(c.getMarker()==pos[0] || c.getMarker()==pos[1]) {
        	System.out.println("No avalible spot");
        	return false;
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






    @Override
    public void start() {

        gameBegin();
        System.out.println(board.toString());
        while(true) {
            for(Hero hero: Heros) {
                while(!HeroAction(hero));
                System.out.println(board.toString());
            }
            for(Monster monster: monsterList){
                while(!MonsterAction(monster));
                System.out.println(board.toString());
            }
        }
    }
}

