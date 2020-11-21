package src;

public class MoveDownCommand implements MoveCommand{

    public MoveDownCommand() {
    }


    @Override
    public LOVCell getCell(LOVBoard board, Creature actor) {
        return board.getCell(actor.getRow() + 1, actor.getCol());
    }

    @Override
    public void doLOVMove(LOVBoard board, Creature actor) {
        actor.setCreaturePosition(board, actor.getRow() + 1, actor.getCol());
    }
}
