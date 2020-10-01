package com.cg.workshop;

public class TicTacToe {

	public static void main(String[] args) {
		System.out.println("Lets play TicTacToe game");
		gameboard();	
	}
	public static char[] gameboard() {
		char[] board = new char[9];
		for (char index : board) {
			index=' ';
			
		}
		return board;
	}
}
