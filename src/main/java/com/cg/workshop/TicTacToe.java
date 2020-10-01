package com.cg.workshop;

public class TicTacToe {

	public static void main(String[] args) {
		System.out.println("Lets play TicTacToe game");
		char [] board = createBoard();
		
	}

	/**
	 * @return  uc1
	 */
	public static char[] createBoard() {
		char[] board = new char[10];
		for (int i=0; i<board.length;i++) {
			board[i] = ' ';
		}
		return board;
	}
}
