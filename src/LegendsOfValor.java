package src;

import java.util.ArrayList;
import java.util.Vector;

public class LegendsOfValor extends MonsterGame {


    //Characters
    private ArrayList<Hero> Heros;
    private ArrayList<Monster> Villains;

    //World
    private LOVBoard board;

    public LegendsOfValor(HeroFactory H_factory, ArrayList<Monster> monsterList, MonsterFactory allMonsters, BoardFactory B_Factory, int rows, int columns, ArrayList<Hero> heros, ArrayList<Monster> villains) {
        super(H_factory, monsterList, allMonsters, B_Factory, rows, columns);
        Heros = heros;
        Villains = villains;
    }


    public static void intro(){
        //d
    }

    private void gameBegin(){
        //Effect: Creates game
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
        while(true){
            if(str.charAt(0)== 'w'){

            }else if(str.charAt(0)== 'a'){

            }else if(str.charAt(0)== 's'){

            }else if(str.charAt(0)== 'd'){

            }else if(str.charAt(0)== 'f'){
                
            }else if(str.charAt(0)== 't'){
                boolean tel = Teleport(hero);
                return tel;
            }else if(str.charAt(0)== 'i'){
                
            }else if(str.charAt(0)== 'z'){

            }else if(str.charAt(0)== 'b'){

            }else if(str.charAt(0)== 'm'){

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
            	if(!board.checkCellAccess(hero.getRow(), 0)) {
            		hero.setHeroPosition(board, hero.getRow(), 0);
            	}else if(!board.checkCellAccess(hero.getRow(), 1)) {
            		hero.setHeroPosition(board, hero.getRow(), 1);
            	}else if(hero.getRow()==7) {
            		hero.setHeroPosition(board, hero.getRow()-1, 0);
            	}else {
            		hero.setHeroPosition(board, hero.getRow()+1, 0);
            	}
            	return true;
            }
        }else if(lane ==2) {
        	if(hero.getCol()==3 || hero.getCol()==4){
                System.out.println("Hero "+hero.getName()+" is already at Mid lane!");
                return false;
            }else{
            	if(!board.checkCellAccess(hero.getRow(), 3)) {
            		hero.setHeroPosition(board, hero.getRow(), 3);
            	}else if(!board.checkCellAccess(hero.getRow(), 4)) {
            		hero.setHeroPosition(board, hero.getRow(), 4);
            	}else if(hero.getRow()==7) {
            		hero.setHeroPosition(board, hero.getRow()-1, 3);
            	}else {
            		hero.setHeroPosition(board, hero.getRow()+1, 3);
            	}
            	return true;
            }
        }else{
        	if(hero.getCol()==6 || hero.getCol()==7){
                System.out.println("Hero "+hero.getName()+" is already at Bottom lane!");
                return false;
            }else{
            	if(!board.checkCellAccess(hero.getRow(), 6)) {
            		hero.setHeroPosition(board, hero.getRow(), 6);
            	}else if(!board.checkCellAccess(hero.getRow(), 7)) {
            		hero.setHeroPosition(board, hero.getRow(), 7);
            	}else if(hero.getRow()==7) {
            		hero.setHeroPosition(board, hero.getRow()-1, 6);
            	}else {
            		hero.setHeroPosition(board, hero.getRow()+1, 6);
            	}
            	return true;
            }
        }



    }


    public ArrayList<Monster> checkTargets(Hero actor) {
        int row = actor.getRow();
        int col = actor.getCol();
        ArrayList<Monster> returnlist = new ArrayList<Monster>();
        //Creature
        for (int i = row - 1; i < row + 1; i++) {
            for (int j = col - 1; j < col + 1; j++) {
                for (Monster mon : Villains) {
                    if (mon.getRow() == i && mon.getCol() == j) {
                        returnlist.add(mon);
                    }
                }
            }
        }
        return returnlist;
    }





    @Override
    public void start() {
        //Begins game loop
    }
}

