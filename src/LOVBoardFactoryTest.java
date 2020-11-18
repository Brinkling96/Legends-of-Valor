package src;


import org.junit.jupiter.api.Test;


class LOVBoardFactoryTest {

    @Test
    public void createBoard() {
        Board board = new LOVBoardFactory().createBoard(8,8);
        board.printBoard();
    }
}