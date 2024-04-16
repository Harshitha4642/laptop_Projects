package chess;

public class Main {
	public static void main(String args[])
	{
		ChessBoard board = new ChessBoard();
		board.printBoard();
		Move.halt();
		String move = "Pe2-e4 Pe7-e5";
		Move m = new Move(move, board);
		move = "Kb2-a4 Bf1-d3";
		m = new Move(move, board);
	}

}
