package src;

public interface MoveCommand {
    LOVCell getCell(LOVBoard board, Hero hero);
    void doLOVMove(LOVBoard board, Hero hero);
}
