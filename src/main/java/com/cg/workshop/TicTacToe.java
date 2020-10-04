package com.cg.workshop;

import java.util.Scanner;

public class TicTacToe {

	static Scanner sc = new Scanner(System.in);
	static char[] board;
	static char USER;
	static char COMPUTER;
	static final int HEAD = 1;
	static final int TAIL = 2;
	private static int player;

	public static void main(String[] args) {
		System.out.println("Lets play TicTacToe game");
		char[] board = createBoard();
		USER = letter();
		COMPUTER = computer(USER);
		showBoard(board);
		int emptycell = 1;
		player = startGame();
		nextMove(emptycell, player, board);

	}

	/**
	 * @return uc1
	 */
	private static char[] createBoard() {
		char[] board = new char[10];
		for (int i = 1; i < board.length; i++) {

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
	private static char[] showBoard(char[] board) {
		System.out.println("\n.............\n");

		System.out.println("| " + board[1] + " | " + board[2] + " | " + board[3] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[4] + " | " + board[5] + " | " + board[6] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[7] + " | " + board[8] + " | " + board[9] + " |");
		System.out.println("\n.............\n");
		return board;
	}

	/**
	 * @param board
	 * @param sc
	 * @return uc4
	 */

	public static int checkBoard(char[] board) {
		System.out.println("enter the location to check");
		System.out.println("Enter the cell number (1-9)");
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
	 * 
	 * @param board
	 * @param emptycell
	 * @param player
	 */
	public static char[] makeAMove(char[] board, int emptycell, char player) {
		emptycell = checkBoard(board);
		board[emptycell] = player;
		System.out.println("updated Board");
		showBoard(board);
		return board;
	}

	/**
	 * uc5
	 * 
	 * @param emptycell
	 * @param player
	 * @param board
	 */
	public static void nextMove(int emptycell, int player, char[] board) {
		int k = 0;
		while (k == 0) {
			int toss = startGame();
			int i;
			for (i = 0; i < 9; i++, toss++) {
				if (toss % 2 == HEAD) {
					System.out.println("USER'S TURN");
					makeAMove(board, emptycell, USER);
					if (isWinner(board, USER)) {
						System.out.println("USER win");
						break;
					}
				}

				else {

					System.out.println("COMPUTER'S TURN");
					if (!(computerTurn(board, COMPUTER))) {

						if (!(checkOpponent(board, USER, COMPUTER))) {

							if (cornerCon(board, COMPUTER)) {
								showBoard(board);

							}

						} else {
							showBoard(board);
						}
					} else {
						showBoard(board);
					}
					if (isWinner(board, COMPUTER)) {
						System.out.println("Computer win");
						break;

					}
				}
			}
			if (i == 9) {
				System.out.println("Game Tie");
			} else {
				System.out.println("Do you want to play again Yes/No");
				String choice = sc.next();
				if (choice != "Yes") {
					break;
				}
			}
		}
	}

	/**
	 * uc6
	 * 
	 * @param board
	 * @param emptycell
	 * @param USER
	 * @param COMPUTER
	 * @return
	 */
	public static int startGame() {
		int toss = (int) (Math.random() * 10) % 2;
		return toss;
	}

	/**
	 * uc7
	 * 
	 * @param board
	 * @param ch
	 * @return
	 */
	private static boolean isWinner(char[] board, char ch) {
		return ((board[1] == ch && board[2] == ch && board[3] == ch)
				|| (board[4] == ch && board[5] == ch && board[6] == ch)
				|| (board[7] == ch && board[8] == ch && board[9] == ch)
				|| (board[1] == ch && board[4] == ch && board[7] == ch)
				|| (board[2] == ch && board[5] == ch && board[8] == ch)
				|| (board[3] == ch && board[6] == ch && board[9] == ch)
				|| (board[1] == ch && board[5] == ch && board[9] == ch)
				|| (board[7] == ch && board[5] == ch && board[3] == ch));
	}

	private static boolean computerTurn(char[] board, char COMPUTER) {
		boolean f = false;
		if ((board[3] == ' ') && ((board[1] == COMPUTER && board[2] == COMPUTER)
				|| (board[6] == COMPUTER && board[9] == COMPUTER) || (board[5] == COMPUTER && board[7] == COMPUTER))) {
			board[3] = COMPUTER;
			f = true;
		} else if ((board[1] == ' ') && ((board[2] == COMPUTER && board[3] == COMPUTER)
				|| (board[5] == COMPUTER && board[9] == COMPUTER) || (board[4] == COMPUTER && board[7] == COMPUTER))) {
			board[1] = COMPUTER;
			f = true;
		} else if ((board[2] == ' ')
				&& ((board[1] == COMPUTER && board[3] == COMPUTER) || (board[5] == COMPUTER && board[8] == COMPUTER))) {
			board[2] = COMPUTER;
			f = true;
		} else if ((board[4] == ' ')
				&& ((board[1] == COMPUTER && board[7] == COMPUTER) || (board[5] == COMPUTER && board[6] == COMPUTER))) {
			board[4] = COMPUTER;
			f = true;
		} else if ((board[5] == ' ') && ((board[7] == COMPUTER && board[3] == COMPUTER)
				|| (board[1] == COMPUTER && board[9] == COMPUTER) || (board[4] == COMPUTER && board[6] == COMPUTER)
				|| (board[2] == COMPUTER && board[8] == COMPUTER))) {
			board[5] = COMPUTER;
			f = true;
		} else if ((board[6] == ' ')
				&& ((board[4] == COMPUTER && board[5] == COMPUTER) || (board[3] == COMPUTER && board[9] == COMPUTER))) {
			board[6] = COMPUTER;
			f = true;
		} else if ((board[7] == ' ') && ((board[1] == COMPUTER && board[4] == COMPUTER)
				|| (board[8] == COMPUTER && board[9] == COMPUTER) || (board[5] == COMPUTER && board[3] == COMPUTER))) {
			board[7] = COMPUTER;
			f = true;
		} else if ((board[8] == ' ')
				&& ((board[2] == COMPUTER && board[5] == COMPUTER) || (board[7] == COMPUTER && board[9] == COMPUTER))) {
			board[8] = COMPUTER;
			f = true;
		} else if ((board[9] == ' ') && ((board[1] == COMPUTER && board[5] == COMPUTER)
				|| (board[7] == COMPUTER && board[8] == COMPUTER) || (board[3] == COMPUTER && board[6] == COMPUTER))) {
			board[9] = COMPUTER;
			f = true;
		} else
			System.out.println("checked computer winning chance");
		return f;
	}

	// UC9opponentBlock
	private static boolean checkOpponent(char[] board, char USER, char COMPUTER) {
		boolean f = false;
		if (((board[1] == USER && board[2] == USER) || (board[6] == USER && board[9] == USER)
				|| (board[5] == USER && board[7] == USER)) && board[3] == ' ') {
			board[3] = COMPUTER;
			f = true;
		} else if (((board[2] == USER && board[3] == USER) || (board[5] == USER && board[9] == USER)
				|| (board[4] == USER && board[7] == USER)) && board[1] == ' ') {
			board[1] = COMPUTER;
			f = true;
		} else if (((board[1] == USER && board[3] == USER) || (board[5] == USER && board[8] == USER))
				&& board[2] == ' ') {
			board[2] = COMPUTER;
			f = true;
		} else if (((board[1] == USER && board[7] == USER) || (board[5] == USER && board[6] == USER))
				&& board[4] == ' ') {
			board[4] = COMPUTER;
			f = true;
		} else if (((board[7] == USER && board[3] == USER) || (board[1] == USER && board[9] == USER)
				|| (board[4] == USER && board[6] == USER) || (board[2] == USER && board[8] == USER))
				&& board[5] == ' ') {
			board[5] = COMPUTER;
			f = true;
		} else if (((board[4] == USER && board[5] == USER) || (board[3] == USER && board[9] == USER))
				&& board[6] == ' ') {
			board[6] = COMPUTER;
			f = true;
		} else if (((board[1] == USER && board[4] == USER) || (board[8] == USER && board[9] == USER)
				|| (board[3] == USER && board[5] == USER)) && board[7] == ' ') {
			board[7] = COMPUTER;
			f = true;
		} else if (((board[2] == USER && board[5] == USER) || (board[7] == USER && board[9] == USER))
				&& board[8] == ' ') {
			board[8] = COMPUTER;
			f = true;
		} else if (((board[1] == USER && board[5] == USER) || (board[7] == USER && board[8] == USER)
				|| (board[3] == USER && board[6] == USER)) && board[9] == ' ') {
			board[9] = COMPUTER;
			f = true;
		} else
			System.out.println("Checked opponent Condition");
		return f;
	}

	// UC10cornerCondition&&UC11centerConditionandall
	private static boolean cornerCon(char[] board, char COMPUTER) {
		boolean f = false;
		if (board[1] == ' ') {
			board[1] = COMPUTER;
			f = true;
		} else if (board[3] == ' ') {
			board[3] = COMPUTER;
			f = true;
		} else if (board[7] == ' ') {
			board[7] = COMPUTER;
			f = true;
		} else if (board[9] == ' ') {
			board[9] = COMPUTER;
			f = true;
		} else if (board[5] == ' ') {
			board[5] = COMPUTER;
			f = true;
		} else if (board[2] == ' ') {
			board[2] = COMPUTER;
			f = true;
		} else if (board[4] == ' ') {
			board[4] = COMPUTER;
			f = true;
		} else if (board[6] == ' ') {
			board[6] = COMPUTER;
			f = true;
		} else if (board[8] == ' ') {
			board[8] = COMPUTER;
			f = true;
		}
		return f;
	}
}
