package revaturetraining.com;

import java.util.Scanner;

public class TicTacGame {


	public static void main(String[] args) {
		System.out.println("Welcome to Tic Tac Toe");

		int turnCount = 0;
		String[] gameBoard = { " ", " ", " ", " ", " ", " ", " ", " ", " " };

		printBoard(gameBoard);

		// Where in our turn logic should we check to see if there's a winner?
		// How are we going to know if someone has won?
		// gameBoard[0] == X AND gameBoard[1] == "X" AND gameBoard[2] == "X"
		// after at least 5 moves

		while (!(gameOver(gameBoard, turnCount))) { //(!(winner(gameBoard)))
			String instructions = "Where would you like to go? 1-9?";

			System.out.println(instructions);

			Scanner input = new Scanner(System.in);
			String firstMove = input.nextLine();

			if (validateInput(firstMove)) {
				int boardIndex = Integer.parseInt(firstMove) - 1;
				if (validateMove(gameBoard, boardIndex)) {
					turnCount++;

					if (turnCount % 2 == 0) {
						gameBoard[boardIndex] = "O";
					} else {
						gameBoard[boardIndex] = "X";
					}

					printBoard(gameBoard);

					// I know that a valid move has been made, good time to check for a winner
					// if there's a winner, say "YOU WON"
					if (winner(gameBoard)) {
						System.out.println("YOU WON!");
						// set turnCount = 100; will abort the program but it is tricking the program so don't do this!!!
						
					}
				}
			} else {
				System.out.println("Please type 1-9 only thank you!");
			}
		}
		System.out.println("Goodbye!");
	}
	
	public static boolean gameOver(String[] theBoard, int turnCount) {
		return winner(theBoard) || turnCount >= 9;
	}

	public static Boolean winner(String[] theBoard) {
		// How can I store that there are 8 win combinations are the pattern is:
		// 0 1 2
		// 3 4 5
		// 0 3 6
		// 1 4 7
		// 2 5 8
		// 0 4 8
		// 2 4 6
		int[][] winCombos = { { 0, 1, 2 }, // Top Row
				{ 3, 4, 5 }, // Middle Row
				{ 6, 7, 8 }, // Bottom Row
				{ 0, 3, 6 }, 
				{ 1, 4, 7 }, 
				{ 2, 5, 8 }, 
				{ 0, 4, 8 }, 
				{ 2, 4, 6 } };
		
		Boolean won = false;

		// for each win combination, check to see if the board has an X in each of the
		// indexes of that
		// combo winCombo = {3, 4, 5},
		// winCombo[0], winCombo[1], winCombo[2]
		// firstComboIndex = winCombo[0]
		// secondComboIndex = winCombo[1]
		// thirdComboIndex = winCombo[2]

		// theBoard[firstComboIndex], theBoard[secondComboIndex],
		// theBoard[thirdComboIndex]
		for (int i = 0; i < winCombos.length; i++) {
			int[] winCombo = winCombos[i]; // 345
			int firstComboIndex = winCombo[0]; // 3
			int secondComboIndex = winCombo[1]; // 4
			int thirdComboIndex = winCombo[2]; // 5

			if (theBoard[firstComboIndex] == "X" && theBoard[secondComboIndex] == "X"
					&& theBoard[thirdComboIndex] == "X") {
				won = true;
				//System.out.println("X wins");

			}else if(theBoard[firstComboIndex] == "O" && theBoard[secondComboIndex] == "O" && theBoard[thirdComboIndex] == "O") {
				won = true;
				//System.out.println("O wins");
			}				
			
		}

		// if (theBoard[0] == "X" && theBoard[1] == "X" && theBoard[2] == "X"){ // Top
		// Row
		// return true;
		// } else if (theBoard[6] == "X" && theBoard[7] == "X" && theBoard[8] == "X"){
		// // Middle Row
		// return true;
		// } else if (theBoard[3] == "X" && theBoard[4] == "X" && theBoard[5] == "X"){
		// // Bottom Row
		// return true;
		// } else if (theBoard[0] == "X" && theBoard[3] == "X" && theBoard[6] == "X"){
		// // Left Column
		// return true;
		// } else if (theBoard[1] == "X" && theBoard[4] == "X" && theBoard[7] == "X"){
		// // Middle Column 1. 4 7
		// return true;
		// } else if (theBoard[2] == "X" && theBoard[5] == "X" && theBoard[8] == "X"){
		// // Right Column 2 5 8
		// return true;
		// } else if (theBoard[0] == "X" && theBoard[4] == "X" && theBoard[8] == "X"){
		// // Diagnal 0 4 8
		// return true;
		// } else if (theBoard[2] == "X" && theBoard[4] == "X" && theBoard[6] == "X"){
		// // Diagnal 2 4 6
		// return true;
		// }
		// else {
		// return false;
		// }
		return won;
	}


	public static Boolean validateInput(String userInput) {
		try {
			if (Integer.parseInt(userInput) > 0 && Integer.parseInt(userInput) < 10) {
				return true;
			} else {
				return false;
			}
		} catch (Exception theError) {
			return false;
		}
	}

	public static Boolean validateMove(String[] board, int boardIndex) {
		if (board[boardIndex] == " ") {
			return true;
		} else {
			System.out.println("You cannot play where someone else has.");
			return false;
		}
	}

	public static void printBoard(String[] board) {
		System.out.println("_" + board[0] + "_|_" + board[1] + "_|_" + board[2] + "_");
		System.out.println("_" + board[3] + "_|_" + board[4] + "_|_" + board[5] + "_");
		System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8] + " ");
	}
}
