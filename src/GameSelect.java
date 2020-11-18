package src;

public class GameSelect {
    public static void main(String[] args) {
        //Effect:Begins logic for starting game select
        //Something like selectGame().start()
        MonsterGame game =  selectGame();
        game.start();
    }

    public static MonsterGame selectGame(){
        //Effect: User Selects which game to play, MAH or LOV and starts Game
        //Returns: Game Selected
        MonsterANDHeroes.intro();
        return new MonsterANDHeroes();

    }
}
