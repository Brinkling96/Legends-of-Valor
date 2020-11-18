package src;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class MonsterGame {
//abstract class for the game
	protected static Scanner in = new Scanner(System.in);
	private ArrayList<Hero> Heros;
	protected ArrayList<Monster> monsterList;
	protected MonsterFactory allMonsters;
	protected Board board;
	protected Market market;

	public MonsterGame(HeroFactory H_factory, ArrayList<Monster> monsterList, MonsterFactory allMonsters,
					   BoardFactory B_Factory, int rows, int columns) {
		this.Heros = H_factory.createParty();
		this.monsterList = monsterList;
		this.allMonsters = allMonsters;
		this.board = B_Factory.createBoard(rows,columns);
		this.market = Market.getInstance();
	}

	public ArrayList<Hero> getHeros() {
		return Heros;
	}

	public abstract void start();
}
