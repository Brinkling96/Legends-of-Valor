package src;

public class Patterns {

	//the class represents some patterns of output
	
	public static void printIntHead() {
		System.out.println("*********************************************************************************************************");
	}
	
	public static void printIntro() {
		printIntHead();
		System.out.println("	In the ancient times kingdom Java, after defeating the commander of the evil troops Python, ");
		System.out.println("	bestowned peace amongst humans and builted his capital. ");
		System.out.println("	However, the peaceful land was in chaos again...\n");
		printSand();
		System.out.println("Do you want to visit the basic information of the game?");
		System.out.print("Enter yes/YES to visit or others to start the game: ");
	}
	
	public static void printSand() {
		System.out.println("* * * * * 					");
		System.out.println(" * * * * 					");
		System.out.println("  * * *  		Fortunately, you was selected to save the world of Java.");
		System.out.println("   * * 						");
		System.out.println("    * 			You will choose a number of heroes help you to beat monsters.");
		System.out.println("    * 						");
		System.out.println("   * * 			Enjoy your journey!");
		System.out.println("  * * *  					");
		System.out.println(" * * * *  					");
		System.out.println("* * * * * 					");
	}
	
	public static void printHint() {
		System.out.println("		Warriors are favored on strength and agility.");
		System.out.println("***HINT***	Sorcerers are favored on the dexterity and the agility.");
		System.out.println("		Paladins are favored on strength and dexterity.");
		System.out.println();
	}
	
	public static void printGameBegin() {
		System.out.println("\n			L E T\tT H E\tG A M E\t   B E G I N");
		System.out.println("\n				* Choose your Team *\n");
	}
	
	public static void printMarket() {
		System.out.println("  =========================== * * * * ===========================");
		System.out.println("||                                                             ||");
		System.out.println("||          - W E L C O M E     T O      M A R K E T -         ||");
		System.out.println("||                                                             ||");
		System.out.println("  =========================== * * * * ===========================");
	}
	
	public static void printAttacked() {
		System.out.println();
		System.out.println();
		System.out.println("		***Oh no! The enemy has appeared! Get ready to fight for your kingdom!***");
		System.out.println("	The monsters are closing the distance rapidly! Check theii status and decide your fight!");
	}
	
	public static void printSafe() {
		System.out.println();
		System.out.println();
		System.out.println("			***Safe place! You can have a rest!***");
		System.out.println();
	}
	
	public static void printTeamSt() {
		System.out.println();
		System.out.println();
		System.out.println("			And here is your Team's status:");
		System.out.println();
	}
	
	public static void printVictory() {
		System.out.println();
		System.out.println("			-----------------");
		System.out.println("			| V I C T O R Y |		:)");
		System.out.println("			-----------------");
		System.out.println();
	}
	
	public static void printDefeat() {
		System.out.println();
		System.out.println("			-------------------");
		System.out.println("			| D E F E A T E D |		:(");
		System.out.println("			-------------------");
		System.out.println();
	}
	
	public static void printBye() {
		System.out.println();
		System.out.println();
		System.out.println("			----------------------------------------");
		System.out.println("			|    Thank you for playing! B Y E !    |");
		System.out.println("			----------------------------------------");
	}
	
}
