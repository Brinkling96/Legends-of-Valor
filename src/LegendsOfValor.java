package src;

import java.util.ArrayList;
import java.util.Vector;

public class LegendsOfValor extends MonsterGame {


    //Characters
    private ArrayList<Hero> Heros;
    private ArrayList<Monster> Villains;

    //World



    public LegendsOfValor() {

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


    @Override
    public void start() {
        //Begins game loop
    }
}
