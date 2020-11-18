package src;

import java.util.Random;

public class LOVBoardFactory implements BoardFactory {
    @Override
    public Board createBoard(int rowNum, int colNum) {
        Random random = new Random();
        Cell[][] board = new Cell[rowNum][colNum];
        int num;
        for(int i = 0; i<rowNum; i++) {
            for(int j = 0; j<colNum; j++) {
                if(j == 2 || j == 5){
                    board[i][j] = new LOVInaccesibleCell(i,j);
                }
                else {
                    if (i == rowNum-1){
                        board[i][j] = new LOVHeroNexus(i,j);
                    }
                    else if(i == 0){
                        board[i][j] = new LOVMonsterNexus(i,j);
                    }
                    else {
                        num = random.nextInt(10);
                        if (num < 2) {
                            board[i][j] = new LOVKoulouCell(i,j);
                        }
                        else if (num <4) {
                            board[i][j] = new LOVBushCell(i, j);
                        }
                        else if (num  < 6) {
                            board[i][j] = new LOVCaveCell(i,j);
                        }
                        else{
                            board[i][j] = new LOVPlainsCell(i,j);
                        }

                    }
                }
            }
        }
        return new Board(board,rowNum,colNum);
    }
}
