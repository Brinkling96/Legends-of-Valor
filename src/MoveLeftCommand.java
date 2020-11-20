package src;

public class MoveLeftCommand implements MoveCommand{
    public MoveLeftCommand() {
    }

    @Override
    public LOVCell getCell(LOVBoard board, Hero hero) {
        return board.getCell(hero.getRow(), hero.getCol()-1);
    }

    @Override
    public void doLOVMove(LOVBoard board, Hero hero) {
        hero.setHeroPosition(board, hero.getRow(), hero.getCol()-1);
    }
}
