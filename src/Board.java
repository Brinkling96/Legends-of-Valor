package src;

import java.util.Random;

public class Board {

	//The class represents the board of the game
	
	private Cell[][] board;
	private int rowNum;
	private int colNum;


	public Board(Cell[][] board, int rowNum, int colNum) {
		this.board = board;
		this.rowNum = rowNum;
		this.colNum = colNum;
	}

	public Board(int rowNum, int colNum) {
		this(new Cell[rowNum][colNum], rowNum,colNum);
	}

	public Board(int rowNum) {
		this(rowNum,rowNum);
	}

	public Board(){
		this(8);
	}

	public int getRowNum() {
		return this.rowNum;
	}
	
	public int getColNum() {
		return this.colNum;
	}
	

	
	public void setCell(int row, int col, char cell) {
		Cell temp = board[row][col];
		temp.setCellType(cell);
	}
	
	public char getCell(int row, int col) {
		Cell temp = board[row][col];
		return temp.getCellType();
	}
	
	public void printBoard() {
		System.out.print("+");
		for(int k = 0; k < colNum; k++) {
			System.out.print("--+");
		}
		for(int i = 0; i<rowNum; i++) {
			System.out.print("\n|");
			for(int j = 0; j<colNum; j++) {
				char t = board[i][j].getCellType();
				System.out.print(t +" |");
			}
			System.out.print("\n+");
			for(int p = 0; p<colNum;p++) {
				System.out.print("--+");
			}
		}
		System.out.println("\n");
		System.out.println("X: Location	M:Market	&:NonAccessable");
		System.out.println();
	}
	
	public int checkCellAccess(int row, int col, char cell) {
		if(row>=rowNum || col>=colNum || row<0 || col<0) {
			System.out.println("Invalid move!");
			return 1;
		}
		if(board[row][col].getCellType() == '&') {
			System.out.println("Inaccessible Cell!");
			return 2;
		}
		if(board[row][col].getCellType() == 'M') {
			return 3;
		}
		setCell(row, col, cell);
		return 0;
	}
	

}
