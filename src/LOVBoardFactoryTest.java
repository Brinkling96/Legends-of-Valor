package src;


import org.junit.jupiter.api.Test;


class LOVBoardFactoryTest {

    @Test
    public void createBoard() {
        LOVBoard board = (LOVBoard) new LOVBoardFactory().createBoard(8,8);
        System.out.println(board.toString());
    }
}