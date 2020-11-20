package src;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class LegendsOfValor extends MonsterGame {

    private LOVBoard board;
    private ArrayList<Hero> HeroList = new ArrayList<Hero>();
    //private ArrayList<Monster> MonsterList = new ArrayList<Monster>();
    
    public LegendsOfValor(){
        super(new MAHHeroFactory(new Scanner(System.in)), null,null,new LOVBoardFactory(),8,8);
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
            if (i*3 == 12){
                System.out.println("no");
            }
            hero.setHeroPosition(board, 7,i*3);
            board.getCell(7,i++*3).setPositions(new char[]{hero.getMarker(), ' '});
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
            }else if(str.charAt(0)== 't'){
                return Teleport(hero);
            }else if(str.charAt(0)== 'i'){
                return Inventory(hero);
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
            		hero.setHeroPosition(board, hero.getRow(), 0);
            	}else if(!board.checkCellAccess(hero.getRow(), 1)) {
            		hero.setHeroPosition(board, hero.getRow(), 1);
            	}else if(hero.getRow()==7) {
            		hero.setHeroPosition(board, hero.getRow()-1, 0);
            	}else {
            		hero.setHeroPosition(board, hero.getRow()+1, 0);
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
            		hero.setHeroPosition(board, hero.getRow(), 3);
            	}else if(!board.checkCellAccess(hero.getRow(), 4)) {
            		hero.setHeroPosition(board, hero.getRow(), 4);
            	}else if(hero.getRow()==7) {
            		hero.setHeroPosition(board, hero.getRow()-1, 3);
            	}else {
            		hero.setHeroPosition(board, hero.getRow()+1, 3);
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
            		hero.setHeroPosition(board, hero.getRow(), 6);
            	}else if(!board.checkCellAccess(hero.getRow(), 7)) {
            		hero.setHeroPosition(board, hero.getRow(), 7);
            	}else if(hero.getRow()==7) {
            		hero.setHeroPosition(board, hero.getRow()-1, 6);
            	}else {
            		hero.setHeroPosition(board, hero.getRow()+1, 6);
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
        			hero.setHeroPosition(board,7, 0);
        		}else {
        			hero.setHeroPosition(board,7, 1);
        		}
        		return true;
        	}
    	}else if(hero.getCol()==3||hero.getCol()==4) {
    		if(board.checkCellAccess(7, 3) ||board.checkCellAccess(7, 4)) {
        		System.out.println(fullNexus);
        		return false;
        	}else {
        		if(!board.checkCellAccess(7, 3)) {
        			hero.setHeroPosition(board,7, 3);
        		}else {
        			hero.setHeroPosition(board,7, 4);
        		}
        		return true;
        	}
    	}else {
    		if(board.checkCellAccess(7, 6) ||board.checkCellAccess(7, 7)) {
        		System.out.println(fullNexus);
        		return false;
        	}else {
        		if(!board.checkCellAccess(7, 6)) {
        			hero.setHeroPosition(board,7, 6);
        		}else {
        			hero.setHeroPosition(board,7, 7);
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
    
    private boolean Inventory(Hero hero) {
    	System.out.println(hero.getName()+":");
    	hero.printArmorStora();
    	hero.printPotionStora();
    	hero.printSpellStora();
    	hero.printWeaponStora();
    	return false;
    }
    
    private ArrayList<Monster> checkTargets(Hero actor) {
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

    private void displayTargets(ArrayList<Monster> tgts, MonsterFactory fc){
        fc.printMonster(tgts);
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

    private boolean checkMove(LOVCell cell){
        char[] pos = cell.getPositions();
        if(cell.getCellType() == '&'){
            System.out.println("Inaccessible spot!");
            return false;
        }
        else if( ! (pos[0] == ' ')  && !(pos[1] == ' ')){
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
            if (!checkMove(temp)) {
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






    @Override
    public void start() {
        gameBegin();
        System.out.println(board.toString());
        while(true) {
            for(Hero hero: Heros) {
                while(!HeroAction(hero));
                System.out.println(board.toString());
            }
        }
    }
}

