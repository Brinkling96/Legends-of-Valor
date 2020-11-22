package src;

public interface MoveCommand {
	//interface for actors who can move 
    LOVCell getCell(LOVBoard board, Creature actor);
    void doLOVMove(LOVBoard board, Creature actor);
}
