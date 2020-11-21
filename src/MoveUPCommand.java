package src;

public class MoveUPCommand implements MoveCommand{

    public MoveUPCommand() {
    }

    @Override
    public LOVCell getCell(LOVBoard board, Creature actor) {
        return board.getCell(actor.getRow() - 1, actor.getCol());
    }

    @Override
    public void doLOVMove(LOVBoard board, Creature actor) {
        actor.setCreaturePosition(board, actor.getRow() - 1, actor.getCol());
    }
}
