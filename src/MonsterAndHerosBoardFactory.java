package src;

import java.util.Random;

public class MonsterAndHerosBoardFactory implements BoardFactory{
    @Override
    public Board createBoard(int rowNum, int colNum) {
        Random random = new Random();
        Cell[][] board = new Cell[rowNum][colNum];
        int num;
        for(int i = 0; i<rowNum; i++) {
            for(int j = 0; j<colNum; j++) {
                num = random.nextInt(10);
                if(num == 0 || num == 1) {
                    board[i][j] = new Cell(i,j,'&');
                }
                if(num == 2||num==3||num==4) {
                    board[i][j] = new Cell(i,j,'M');
                }
                if(num>4) {
                    board[i][j] = new Cell(i,j,' ');
                }
            }
        }
        board[rowNum-1][colNum-1] = new Cell(rowNum-1, colNum-1,' ');
        return new Board(board,rowNum,colNum);
    }
}
