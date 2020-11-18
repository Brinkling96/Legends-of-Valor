package src;



import java.util.ArrayList;
import java.util.Vector;

public class LOVBoard extends Board{

    public LOVBoard(Cell[][] board, int rowNum, int colNum) {
        super(board, rowNum, colNum);
    }

    @Override
    public String toString() {
        String gameBoard = "";
        for(int i = 0; i< board.length; i++) {
            for (int k = 0; k < 3; k++) {
                for (int j = 0; j < board[i].length; j++) {
                    LOVCell lovcell = (LOVCell) board[i][j];
                    gameBoard += lovcell.display().get(k) + " ";
                }

                gameBoard += '\n';
            }
        }
        return gameBoard;
    }
}


