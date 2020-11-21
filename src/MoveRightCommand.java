package src;

public class MoveRightCommand implements MoveCommand{
    public MoveRightCommand() {
    }

    @Override
    public LOVCell getCell(LOVBoard board, Creature actor) {

        return board.getCell(actor.getRow() , actor.getCol()+1);
    }

    @Override
    public void doLOVMove(LOVBoard board, Creature actor) {
        actor.setCreaturePosition(board, actor.getRow(), actor.getCol()+1);
    }
}
