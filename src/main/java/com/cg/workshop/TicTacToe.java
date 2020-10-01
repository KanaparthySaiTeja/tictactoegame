package com.cg.workshop;

import java.util.Scanner;

public class TicTacToe {
	static char[] board;
	public static void main(String[] args) {
		System.out.println("Lets play TicTacToe game");
		 board = createBoard();
		char player = inputValue();

		char computer = (player == 'x') ? 'o' : 'x';
		System.out.println("player : "+player);
		System.out.println("computer : "+computer);
		showBoard(board);
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

	private static char inputValue() {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter value x / o");
		char s = Character.toLowerCase(sc.next().charAt(0));
		return s;
	}

	private static void showBoard(char[] board) {
System.out.println("\n.............\n");
		
		System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
		System.out.println("\n.............\n");
	}
}
