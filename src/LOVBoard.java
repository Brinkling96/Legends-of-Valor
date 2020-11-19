package src;



import java.util.ArrayList;
import java.util.Vector;

public class LOVBoard extends Board{

    public LOVBoard(Cell[][] board, int rowNum, int colNum) {
        super(board, rowNum, colNum);
    }

    //@Override
    public String toString(ArrayList<Hero> hero, ArrayList<Monster> monster) {
        String gameBoard = "";
        for(int i = 0; i< board.length; i++) {
            for (int k = 0; k < 3; k++) {
                for (int j = 0; j < board[i].length; j++) {
                    LOVCell lovcell = (LOVCell) board[i][j];
                    gameBoard += lovcell.display().get(k) + " ";
                    
                    for(int h = 1;h<4;h++){
    					if(hero.get(i).getRow()==i && hero.get(i).getCol()==j){
    						board[i][j].setIsHero(h);
    					}
    				}
                    
                    for(int m = 1;m<=monster.size();m++){
    					if(monster.get(m-1).getRow()==i && monster.get(m-1).getCol()==j){
    						board[i][j].setIsMonster(m);
    					}
    				}
                }

                gameBoard += '\n';
            }
        }
        return gameBoard;
    }
}


