package com.cg.workshop;


import java.util.Scanner;

public class TicTacToe {
	static Scanner sc = new Scanner(System.in);
	static char[] board;
	static char USER;
	static char COMPUTER;
	static final int HEAD = 1;
	static final int TAIL = 2;
	public static void main(String[] args) {
		System.out.println("Lets play TicTacToe game");
		char[] board = createBoard();
		USER = letter();
		COMPUTER = computer(USER);
		showBoard(board);
		int emptycell = checkBoard(board);
		String player=startGame(board, emptycell,USER,COMPUTER);
		
	}

	/**
	 * @return uc1
	 */
	private static char[] createBoard() {
		char[] board = new char[10];
		for (int i = 0; i < board.length; i++) {

			board[i] = ' ';
		}
		return board;
	}

	/**
	 * @return uc2
	 */

	public static char letter() {
		System.out.println("Enter your word either 'X' or 'O' ");
		char input = Character.toUpperCase(sc.next().charAt(0));
		if (input == 'X' || input == 'O') {
			return input;
		} else {
			System.out.println("Invalid input,try again");
			return letter();
		}
	}

	public static char computer(char playerLetter) {
		COMPUTER = (playerLetter == 'X') ? 'O' : 'X';
		System.out.println("playerLetter is " + playerLetter + " computer letter is " + COMPUTER);
		return COMPUTER;
	}

	/**
	 * @param board uc3
	 */
	private static void showBoard(char[] board) {
		System.out.println("\n.............\n");

		System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
		System.out.println("\n.............\n");
	}

	/**
	 * @param board
	 * @param sc
	 * @return uc4
	 */
	

public static int checkBoard(char[] board) {
	System.out.println("enter the location to check");
	System.out.println("next move (1-9)");
	int index = sc.nextInt();
	if (board[index] == ' ') {
		System.out.println(index + " cell is Empty");
		return index;
	} else {
		System.out.println("occupied, kindly check another position");
		return checkBoard(board);
	}

}

/**
 * uc5
 * @param board
 * @param emptycell
 * @param player
 */
public static void makeAMove(char[] board, int emptycell,char player) {

	board[emptycell] = player;
	System.out.println("updated Board");
	showBoard(board);
}

/**
 * uc6
 * @param board
 * @param emptycell
 * @param USER
 * @param COMPUTER
 * @return
 */
public static String startGame(char[] board, int emptycell,char USER,char COMPUTER) {
	int toss = (int) (Math.random() * 2 + 1);
	if (toss == HEAD) {
		System.out.println("User plays first");
		makeAMove(board, emptycell,USER);
		
return "USER TURN";
	}
	if (toss == TAIL) {
		System.out.println("Computer plays first");
		makeAMove(board, emptycell,COMPUTER);
		return "COMPUTER TURN";
	}
	return null;
}
	
}