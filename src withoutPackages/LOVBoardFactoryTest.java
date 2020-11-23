package src;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;


class LOVBoardFactoryTest {

    @Test
    public void createBoard() {
        LOVBoard board = (LOVBoard) new LOVBoardFactory().createBoard(8,8);
        ArrayList<Hero> ht = new ArrayList<Hero>();
        ArrayList<Monster> mt = new ArrayList<Monster>();
        for(int i = 0; i< 3; i++) {
            Hero temp = new Hero("t1", 1, 1, 1, 1, 1, 1);
            temp.setRow(7);
            temp.setCol(3 * i);
            ht.add(temp);
            LOVCell tempCell = (LOVCell)  board.getCell(7,3*i);
            tempCell.setPositions(new char[]{'H',' '});
        }
        System.out.print(board.toString());
    }
}