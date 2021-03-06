package src;

import java.util.Scanner;

// the class represent which game to select by player
public class GameSelect {
	static Scanner in = new Scanner(System.in);
	
    public static void main(String[] args) {

		MonsterGame game = selectGame();
		game.start();
        
    }

    public static MonsterGame selectGame(){
        //Effect: User Selects which game to play, MAH or LOV and starts Game
    	
    	System.out.println("We have two games: [1] Legends: Monsters and Heroes");
    	System.out.println("		   [2] Legends of Valor");
    	System.out.print("Please enter a number to choose from games: ");
    	int gameNum = isInt();
    	while (gameNum!=1 && gameNum!=2) {
    		System.out.print("Invalid input! Please enter a number to choose from 2 games: ");
    		in.nextLine();
    		gameNum = isInt();
    	}
    	System.out.println();
    	MonsterGame game;
    	if(gameNum==1) {
    		MonsterANDHeroes.intro();
    		game = new MonsterANDHeroes();
    	}else {
    		LegendsOfValor.intro();
    		game = new LegendsOfValor();
    	}
    	return game;
    }

    
    
    private static int isInt() {
		while(!in.hasNextInt()) {
			System.out.print("Invalid input! Please enter a number: ");
			in.nextLine();
		}
		int n = in.nextInt();
		return n;
	}
}
