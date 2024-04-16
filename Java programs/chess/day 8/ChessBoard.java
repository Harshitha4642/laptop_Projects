package chess;

import java.util.HashMap;

public class ChessBoard {
	//String[] vertical = {"a","b","c","d","e","f","g","h"};
	HashMap <String, Integer> vertical = new HashMap<String, Integer>();
	
	public static Piece board[][] = new Piece[9][9];
	
	public ChessBoard()
	{
		board[8][1] = new Piece(0,5);
		board[8][2] = new Piece(0,4);
		board[8][3] = new Piece(0,3);
		board[8][4] = new Piece(0,1);
		board[8][5] = new Piece(0,2);
		board[8][6] = new Piece(0,3);
		board[8][7] = new Piece(0,4);
		board[8][8] = new Piece(0,5);
		
		board[1][1] = new Piece(1,5);
		board[1][2] = new Piece(1,4);
		board[1][3] = new Piece(1,3);
		board[1][4] = new Piece(1,1);
		board[1][5] = new Piece(1,2);
		board[1][6] = new Piece(1,3);
		board[1][7] = new Piece(1,4);
		board[1][8] = new Piece(1,5);
		
		for(int i=1; i<=8; i++)
		{
			board[2][i] = new Piece(1,0);
			board[7][i] = new Piece(0,0);
		}	
		
		for(int i=3; i<=6; i++)
		{
			for(int j=1; j<=8; j++)
				board[i][j] = new Piece(2,6);
		}
		
		vertical.put("a", 1);
		vertical.put("b", 2);
		vertical.put("c", 3);
		vertical.put("d", 4);
		vertical.put("e", 5);
		vertical.put("f", 6);
		vertical.put("g", 7);
		vertical.put("h", 8);
	}
	public void printBoard()
	{
		System.out.println("---------------------------------------------------------------------\n");
		for(int i=1; i<=8; i++)
		{
			for(int j=1; j<=8; j++)
				System.out.print(board[i][j].toString()+"  ");
			System.out.println();
		}
		System.out.println("---------------------------------------------------------------------\n");
		
	}
	
	public void makeMove(int ox, int oy, int nx, int ny)
	{
		Piece p = board[nx][ny];		
		board[nx][ny] = board[ox][oy];
		board[ox][oy] = p;
	}
}




