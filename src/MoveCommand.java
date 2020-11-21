package src;

public interface MoveCommand {
    LOVCell getCell(LOVBoard board, Creature actor);
    void doLOVMove(LOVBoard board, Creature actor);
}
