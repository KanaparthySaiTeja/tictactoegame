package com.cg.workshop;

import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		System.out.println("Lets play TicTacToe game");
		char[] board = createBoard();
		char player = inputValue();

		char computer = (player == 'x') ? 'o' : 'x';
	}

	/**
	 * @return uc1
	 */
	public static char[] createBoard() {
		char[] board = new char[10];
		for (int i = 0; i < board.length; i++) {
			board[i] = ' ';
		}
		return board;
	}

	public static char inputValue() {

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter value x / o");
		char s = Character.toLowerCase(sc.next().charAt(0));
		return s;
	}
}
