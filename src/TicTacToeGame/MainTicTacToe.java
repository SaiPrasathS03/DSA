package TicTacToeGame;

import java.util.Scanner;

public class MainTicTacToe {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n = getN();
		char[][] board = new char[n][n];
		intializeBoard(board);

		boolean isWon = false;
		char currPlayer = 'X';
		int moves = 0;
		while (moves < n * n && !isWon) {
			printBoard(board, n);
			int i = getThePos(currPlayer, n, 'i');
			int j = getThePos(currPlayer, n, 'j');
			if (board[i][j] != '-') {
				System.out.println("-----Please enter the valid positions-----");
				continue;
			}
			board[i][j] = currPlayer;
			if (isWinning(n, board, i, j, currPlayer)) {
				System.out.println("\n\n----The Winner is " + currPlayer+"-----");
				printBoard(board, n);
				return;
			}
			if (moves % 2 == 0)
				currPlayer = 'O';
			else
				currPlayer = 'X';
			moves++;
		}
		System.out.println("\n\n-----Game Draw-----");
		printBoard(board, n);
	}

	private static boolean isWinning(int n, char[][] board, int i, int j, char curr) {
		int rowCount = 0, colCount = 0;
		for (int col = 0; col < n; col++) {
			if (board[i][col] == curr) {
				colCount++;
			} else
				break;
		}
		for (int row = 0; row < n; row++) {
			if (board[row][j] == curr) {
				rowCount++;
			} else
				break;
		}
		int dupI = i, dupJ = j;
		int countD = 0;
		while (j >= 0 && i >= 0) {
			if (board[i][j] == curr)
				countD++;
			else
				break;
			i--;
			j--;
		}
		i = dupI+1;
		j = dupJ+1;
		while (j < n && i < n) {
			if (board[i][j] == curr)
				countD++;
			else
				break;
			i++;
			j++;
		}
		int countD1=0;
		i=dupI;j=dupJ;
		while(j>=0 && i<n) {
			if (board[i][j] == curr)
				countD1++;
			else
				break;
			i++;
			j--;
		}
		i=dupI-1;j=dupJ+1;
		while(j<n && i>=0) {
			if (board[i][j] == curr)
				countD1++;
			else
				break;
			i--;
			j++;
		}
		if (countD1==n || countD == n || rowCount == n || colCount == n)
			return true;

		return false;
	}

	private static int getThePos(char currPlayer, int n, char c) {
		int i = 0;
		try {
			do {
				System.out.print("Enter the position " + c + " (0-(n-1)) to enter " + currPlayer + ": ");
				i = Integer.parseInt(sc.nextLine());
				if (i < 0 || i >= n)
					System.out.println("-----Enter valid positions form 0 to n-1-----");
				else
					break;
			} while (true);
		} catch (Exception e) {
			System.out.println("-----Enter valid positions-----");
		}
		return i;
	}

	private static void printBoard(char[][] board, int n) {
		for (int i = 0; i < n; i++) {
			
			for (int j = 0; j < n; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void intializeBoard(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = '-';
			}
		}
	}

	private static int getN() {
		int n = 0;
		try {
			do {
				System.out.println("Enter the n(3-100) for the board(nxn): ");
				n = Integer.parseInt(sc.nextLine());
				if (n < 3 || n > 100)
					System.out.println("-----Enter valid n-----");
				else
					break;
			} while (true);
		} catch (Exception e) {
			System.out.println("-----Enter valid n-----");
		}
		return n;
	}
}
