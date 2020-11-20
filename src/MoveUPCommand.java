package src;

public class MoveUPCommand implements MoveCommand{

    public MoveUPCommand() {
    }

    @Override
    public LOVCell getCell(LOVBoard board, Hero hero) {
        return board.getCell(hero.getRow() - 1, hero.getCol());
    }

    @Override
    public void doLOVMove(LOVBoard board, Hero hero) {
        hero.setHeroPosition(board, hero.getRow() - 1, hero.getCol());
    }
}
